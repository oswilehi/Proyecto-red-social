
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
         RandomAccessFile bufferedReader = new RandomAccessFile(path, "r");
         return bufferedReader;
      }
      catch (FileNotFoundException e)
      {
         return null;
      }
   }
   
   public static boolean WriteFile(String path, String data)
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
            String[] binnacleDescription = ReadDescription(BINNACLE + path, 3);
            return true;
         }
         catch (Exception e)
         {
            return false;
         }
   }
   
   public static boolean FileExists(String path)
   {
      return new File(DIRECTORY + DESCRIPTION + path).getAbsoluteFile().exists();
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
   
   private static String[] ReadDescription(String path, int lastLines) //only file's name: example.txt // do not: C:\Directory\test.txt
   {
      try
      {
         // Get FileReader
         String[] data = new String[lastLines];
         RandomAccessFile reader = ReadFile(DIRECTORY + DESCRIPTION + path);
         int lines = 0;
         while(reader.getFilePointer() != reader.length() )
         {
             reader.readLine();
             lines++;
         }
         
         reader.seek(0);
         
         for (int i = 0; i < lines; i++)
         {
            if (i >= lines - lastLines)
            {
               data[i + lastLines - lines] = reader.readLine();
               continue;
            }
            reader.readLine();
         }
         return data;
         
      }
      catch (IOException e)
      {
         return null;
      }
   }
   
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
