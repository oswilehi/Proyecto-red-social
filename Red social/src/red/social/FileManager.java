
package red.social;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import static red.social.RedSocial.ENCODING;
import static red.social.RedSocial.USER_FILE;
import static red.social.RedSocial.BINNACLE;
import static red.social.RedSocial.MASTER;
import static red.social.RedSocial.DESCRIPTION;
import static red.social.RedSocial.DIRECTORY;
import static red.social.RedSocial.SEPARADOR;
import static red.social.RedSocial.pSEPARADOR;

public class FileManager
{
   public static RandomAccessFile ReadFile(String path)
   {
      try
      {
         RandomAccessFile rReader = new RandomAccessFile(DIRECTORY + path, "rw");
         return rReader;
      }
      catch (FileNotFoundException e)
      {
         return null;
      }
   }
   
   public static boolean WriteFile(String path, String data)  // only used for add new lines to text file
   {
         if(!FileExists(path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Bitacora
            CreateBinnacle(path, data.split(Pattern.quote(SEPARADOR))[0]);
         }
         
         try
         {
            RandomAccessFile binnacleDescription = ReadFile(DESCRIPTION + BINNACLE + path);
            int active = 0;
            int inactive = 0;
            int max = 0;
            while(binnacleDescription.getFilePointer() != binnacleDescription.length())
            {
               String line = binnacleDescription.readLine();
               
               switch (line.split(Pattern.quote(pSEPARADOR))[0])
               {
                  case "ACTIVOS":
                     active = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     inactive = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                     break;
                  case "MAXIMO":
                     max = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                     break;
               }
            }
            
            binnacleDescription.close();
            
            if (active + inactive >=  max)
            {
               // Reorganize
            }
            else if (true)
            {
               // Write (append) to binnacle
               RandomAccessFile binnacleFile = ReadFile(BINNACLE + path);
               binnacleFile.seek(binnacleFile.length());
               binnacleFile.writeBytes(data + "\r\n");
               binnacleFile.close();
               //update desc_binnacle
               UpdateDescription(BINNACLE + path, null, active + 1, inactive);
            }
            return true;
         }
         catch (IOException | NumberFormatException e)
         {
            return false;
         }
   }
   
   public static boolean FileExists(String path)
   {
      return new File(DIRECTORY + DESCRIPTION + BINNACLE + path).getAbsoluteFile().exists();
   }
   
   private static boolean UpdateDescription(String path, String author, int active, int inactive) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
   {
      try
      {
         RandomAccessFile fileDescription = ReadFile(DESCRIPTION + path);
         while(fileDescription.getFilePointer() != fileDescription.length())
         {
            long start = fileDescription.getFilePointer();
            String line = fileDescription.readLine();            
            switch (line.split(Pattern.quote(pSEPARADOR))[0])
            {
               case "ACTIVOS":
                  line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + active;
                  fileDescription.seek(start);
                  fileDescription.writeBytes(line);
                  break;
               case "INACTIVOS":
                  line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + inactive;
                  fileDescription.seek(start);
                  fileDescription.writeBytes(line);
                  break;
               case "MODIFICADO":
                  line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date());
                  fileDescription.seek(start);
                  fileDescription.writeBytes(line);
                  break;
               case "AUTOR":
                  if (author != null)
                  {
                     line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + author;
                  }
                  fileDescription.seek(start);
                  fileDescription.writeBytes(line);
                  
            }
         }
         fileDescription.close();
         return true;
      }
      catch (Exception e)
      {
         return false;
      }
   }
   
   private static boolean CreateBinnacle(String path, String author)
   {
      if (CreateFile(DIRECTORY + DESCRIPTION + BINNACLE + path)) //Creates file description
      {
         if (CreateFile(DIRECTORY + BINNACLE + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DIRECTORY + DESCRIPTION + BINNACLE + path), ENCODING)))
               {
                  writer.write("ARCHIVO" + pSEPARADOR + DIRECTORY + BINNACLE + path + "\r\n");
                  writer.write("DESCRIPCION" + pSEPARADOR + "Bitácora de " + path.split(Pattern.quote("."))[0] +"\r\n");
                  writer.write("TIPO" + pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + pSEPARADOR + "Apilo\r\n");
                  writer.write("AUTOR" + pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + pSEPARADOR + "|\r\n");
                  writer.write("ACTIVOS" + pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + pSEPARADOR + "0\r\n");
                  writer.write("MAXIMO" + pSEPARADOR + "5");
                  writer.close();
               }
               return true;
            }
            catch (IOException e)
            {
               return false;
            }
         }
         
      }
      return false;
   }
   
//   private static String[] ReadDescription(String path) //only file's name: example.txt // do not: C:\Directory\test.txt
//   {
//      try
//      {
//         // Get FileReader
//         
//         RandomAccessFile reader = ReadFile(DIRECTORY + DESCRIPTION + path);
//         int i = 0;
//         while(reader.getFilePointer() != reader.length() )
//         {
//             i++;
//         }
//         
//         reader.seek(0);
//         String[] data = new String[i];
//         for (int j = 0; j < i; j++)
//         {
//            data[j] = reader.readLine();
//         }
//         
//         reader.close();
//         return data;
//         
//      }
//      catch (IOException e)
//      {
//         return null;
//      }
//   }
   
   private static boolean CreateFile(String path)
   {
      try
      {
         FileOutputStream directory = new FileOutputStream(path); 
         directory.close();
         return true;
      }
      catch(IOException e)
      {
         return false;
      }
   }
}
