
package red.social;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

public class FileManager
{
   public static BufferedReader ReadFile(String Path)
   {
      try
      {
         BufferedReader bufferedReader = new BufferedReader(new FileReader(Path));
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
            
            CreateBinnacle(path, data.split(Pattern.quote(SEPARADOR))[0]);
            CreateFile(DIRECTORY + BINNACLE + path);
            ///   Bitacora
         }
         
         try
         {
            BufferedReader fileDescription = ReadFile(DIRECTORY + DESCRIPTION +BINNACLE +path);
            BufferedReader fileBinnacle = ReadFile(DIRECTORY + BINNACLE + path);
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
      if (CreateFile(DIRECTORY + DESCRIPTION + BINNACLE + path))
      {
         try
         {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DIRECTORY + DESCRIPTION + BINNACLE + path), ENCODING));
            
            writer.write("ARCHIVO::"+ DIRECTORY + BINNACLE + path + "\r\n");
            writer.write("DESCRIPCION::Bitácora de " + path.split(Pattern.quote("."))[0] +"\r\n");
            writer.write("TIPO::ARCHIVO DE DATOS\r\n");
            writer.write("ORGANIZACION::Apilo\r\n");
            writer.write("AUTOR::"+ author  +"\r\n");
            writer.write("CREADO::" + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
            writer.write("MODIFICADO::" + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
            writer.write("SEPARADOR::|\r\n");
            writer.write("ACTIVOS::0\r\n");
            writer.write("INACTIVOS::0\r\n");
            writer.write("MAXIMO::5");
            
            writer.close();
            return true;
         }
         catch (Exception e)
         {
            return false;
         }
      }
      return false;
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
