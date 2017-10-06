
package red.social;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import static red.social.RedSocial.USER_FILE;
import static red.social.RedSocial.ENCODING;
import static red.social.RedSocial.BINNACLE;
import static red.social.RedSocial.MASTER;
import static red.social.RedSocial.DESCRIPTION;
import static red.social.RedSocial.TEMP;
import static red.social.RedSocial.DIRECTORY;
import static red.social.RedSocial.SEPARADOR;
import static red.social.RedSocial.pSEPARADOR;


public class FileManager
{
   private static final String BACKUP_FILE = "backup.txt";
   private static final String BACKUP_DIRECTORY = File.separator + "MEIA_backup";
   private static final String FRIENDS_FILE = "lista_amigos.txt";
   private static final String GROUPS_FILE = "grupo.txt";
   private static final String GROUPS_FRIENDS_FILE = "grupo_amigos_n.txt";
   
   public static RandomAccessFile OpenFile(String path) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
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
   
   public static boolean FileExists(String path)
   {
      return new File(DIRECTORY + DESCRIPTION + path).getAbsoluteFile().exists();
   }
   
   public static String SearchUser(String key)
   {
      try
      {
         if (FileExists(MASTER + USER_FILE))
         {
            RandomAccessFile File = OpenFile(MASTER + USER_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[0].equals(key) && line.split(Pattern.quote(SEPARADOR))[10].equals("1"))
               {
                  File.close();
                  return line;
               }
            }
            File.close();
         }
         
         if (FileExists(BINNACLE + USER_FILE))
         {
            RandomAccessFile File = OpenFile(BINNACLE + USER_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               
               ////// CHANGE
               
               
               if(line.split(Pattern.quote(SEPARADOR))[0].equals(key) && line.split(Pattern.quote(SEPARADOR))[10].equals("1"))
               {
                  File.close();
                  return line;
               }   
            }
            File.close();
         }
         return null;
      }
      catch (Exception e)
      {
         return null;
      }
   }
   
   public static String SearchFriend(String userKey, String friendKey)
   {
      try
      {
         String[] keyIndex = GetKeys(FRIENDS_FILE).split(Pattern.quote(","));
         int statusIndex = GetIndex(FRIENDS_FILE, "status");
         
         if (FileExists(MASTER + FRIENDS_FILE))
         {
            RandomAccessFile File = OpenFile(MASTER + FRIENDS_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[statusIndex].equals("0")) continue;
               if (line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(userKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[1])].equals(friendKey))
               {
                  File.close();
                  return line;
               }
            }
            File.close();
         }
         
         if (FileExists(BINNACLE + FRIENDS_FILE))
         {
            RandomAccessFile File = OpenFile(BINNACLE + FRIENDS_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[statusIndex].equals("0")) continue;
               if (line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(userKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[1])].equals(friendKey))
               {
                  File.close();
                  return line;
               }  
            }
            File.close();
         }
         return null;
      }
      catch (Exception e)
      {
         return null;
      }
   }
   
   public static String SearchGroup(String groupKey, String userKey)
   {
      try
      {
         String[] keyIndex = GetKeys(GROUPS_FILE).split(Pattern.quote(","));
         int statusIndex = GetIndex(GROUPS_FILE, "status");
         
         if (FileExists(MASTER + GROUPS_FILE))
         {
            RandomAccessFile File = OpenFile(MASTER + GROUPS_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[statusIndex].equals("0")) continue;
               if (line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(userKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[1])].equals(groupKey))
               {
                  File.close();
                  return line;
               }
            }
            File.close();
         }
         
         if (FileExists(BINNACLE + GROUPS_FILE))
         {
            RandomAccessFile File = OpenFile(BINNACLE + GROUPS_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[statusIndex].equals("0")) continue;
               if (line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(userKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[1])].equals(groupKey))
               {
                  File.close();
                  return line;
               }  
            }
            File.close();
         }
         return null;
      }
      catch (Exception e)
      {
         return null;
      }
   }
   
   public static String SearchFriendInGroup(String groupKey, String userKey, String friendKey)
   {
      try
      {
         String[] keyIndex = GetKeys(GROUPS_FRIENDS_FILE).split(Pattern.quote(","));
         int statusIndex = GetIndex(GROUPS_FRIENDS_FILE, "status");
         
         if (FileExists(MASTER + GROUPS_FRIENDS_FILE))
         {
            RandomAccessFile File = OpenFile(MASTER + GROUPS_FRIENDS_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[statusIndex].equals("0")) continue;
               if (line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(userKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[1])].equals(groupKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[2])].equals(friendKey))
               {
                  File.close();
                  return line;
               }
            }
            File.close();
         }
         
         if (FileExists(BINNACLE + GROUPS_FRIENDS_FILE))
         {
            RandomAccessFile File = OpenFile(BINNACLE + GROUPS_FRIENDS_FILE);
            String line;
            while(File.getFilePointer() != File.length())
            {
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[statusIndex].equals("0")) continue;
               if (line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(userKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[0])].equals(groupKey) && line.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keyIndex[2])].equals(friendKey))
               {
                  File.close();
                  return line;
               }  
            }
            File.close();
         }
         return null;
      }
      catch (Exception e)
      {
         return null;
      }
   }
   
   public static boolean WriteFile(String path, String data)  // only used to add new lines to text file
   {
         if(!FileExists(BINNACLE + path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Bitacora
            CreateBinnacle(path, data.split(Pattern.quote(SEPARADOR))[GetIndex(path, "user")]);
         }
         
         try
         {
            if (path.equals(BACKUP_FILE))
            {
               String[] keys = GetKeys(path).split(Pattern.quote(","));
               
               if (path.equals(USER_FILE) && SearchUser(data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[0])]) != null) return false;
               if (path.equals(FRIENDS_FILE) && SearchFriend(data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[0])],data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[1])]) != null) return false;
               if (path.equals(GROUPS_FILE) && SearchGroup(data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[0])],data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[1])]) != null) return false;
               if (path.equals(GROUPS_FRIENDS_FILE) && SearchFriendInGroup(data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[0])], data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[1])], data.split(Pattern.quote(SEPARADOR))[Integer.parseInt(keys[2])]) != null) return false;
            }
            
            RandomAccessFile binnacleDescription = OpenFile(DESCRIPTION + BINNACLE + path);
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
               Reorganize(path, data);
            }
            else
            {
               // Write to binnacle
               RandomAccessFile binnacleFile = OpenFile(BINNACLE + path);
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
   
   public static boolean UpdateUser(String data)//*-
   {
      try
      {
         if (FileExists(BINNACLE + USER_FILE))
         {
            RandomAccessFile File = OpenFile(BINNACLE + USER_FILE);
            long seek;
            String line;

            while(File.getFilePointer() != File.length())
            {
               seek = File.getFilePointer();
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[0].equals(data.split(Pattern.quote(SEPARADOR))[0]))
               {
                  File.seek(seek);
                  File.writeBytes(data);
                  File.close();
                  
                  RandomAccessFile binnacleDescription = OpenFile(DESCRIPTION + BINNACLE + USER_FILE);
                  int active = 0;
                  int inactive = 0;
                  while(binnacleDescription.getFilePointer() != binnacleDescription.length())
                  {
                     line = binnacleDescription.readLine();

                     switch (line.split(Pattern.quote(pSEPARADOR))[0])
                     {
                        case "ACTIVOS":
                           active = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                           break;
                        case "INACTIVOS":
                           inactive = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                           break;
                     }
                  }
                  binnacleDescription.close();
                  
                  int x = Integer.parseInt(data.split(Pattern.quote(SEPARADOR))[10]) - 1;
                  UpdateDescription(BINNACLE + USER_FILE, null, active + x, inactive - x);
                  
                  return true;
               }   
            }
            File.close();
         }
         if (FileExists(MASTER + USER_FILE))
         {
            RandomAccessFile File = OpenFile(MASTER + USER_FILE);
            long seek;
            String line;

            while(File.getFilePointer() != File.length())
            {
               seek = File.getFilePointer();
               line = File.readLine();
               if(line.split(Pattern.quote(SEPARADOR))[0].equals(data.split(Pattern.quote(SEPARADOR))[0]))
               {
                  File.seek(seek);
                  File.writeBytes(data);
                  File.close();
                  
                  RandomAccessFile masterDescription = OpenFile(DESCRIPTION + MASTER + USER_FILE);
                  int active = 0;
                  int inactive = 0;
                  
                  while(masterDescription.getFilePointer() != masterDescription.length())
                  {
                     line = masterDescription.readLine();

                     switch (line.split(Pattern.quote(pSEPARADOR))[0])
                     {
                        case "ACTIVOS":
                           active = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                           break;
                        case "INACTIVOS":
                           inactive = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                           break;
                     }
                  }
                  masterDescription.close();
                  
                  int x = Integer.parseInt(data.split(Pattern.quote(SEPARADOR))[10]) - 1;
                  UpdateDescription(MASTER + USER_FILE, null, active + x, inactive - x);
                  
                  return true;
               }   
            }
            File.close();
         }
         return false;
      }
      catch (Exception e)
      {
         return false;
      }
   }
   
   public static boolean Backup(String data)//*-
   {
      WriteFile(BACKUP_FILE, data);
      try
      {
         String path = data.split(Pattern.quote(SEPARADOR))[0];
         if (path.endsWith(BACKUP_DIRECTORY))
         {
            copyDirectory(new File(DIRECTORY),new File(data.split(Pattern.quote(SEPARADOR))[0]));
         }
         else
         {
            new File(data.split(Pattern.quote(SEPARADOR))[0] + BACKUP_DIRECTORY).mkdir();
            copyDirectory(new File(DIRECTORY),new File(data.split(Pattern.quote(SEPARADOR))[0] + BACKUP_DIRECTORY));
         }
      }
      catch (IOException e)
      {
         return false;
      }
      return true;
   }
   
    private static void copyDirectory(File sourceLocation , File targetLocation)
    throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
   
   private static boolean Reorganize(String path, String data)
   {
      if(!FileExists(MASTER + path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Maestro
            if (path.equals(BACKUP_FILE))
            {
               CreateMaster(path, data); // data is user
            }
            
            CreateMaster(path, data.split(Pattern.quote(SEPARADOR))[GetIndex(path, "user")]);
         }
         
         try
         {
            RandomAccessFile masterDescription = OpenFile(DESCRIPTION + MASTER + path);
            int inactive = 0;
            int keyPosition = 0;
            int lines = 0;
            String sort = "NULL";
            
            // Get values
            
            while(masterDescription.getFilePointer() != masterDescription.length())
            {
               String line = masterDescription.readLine();
               
               switch (line.split(Pattern.quote(pSEPARADOR))[0])
               {
                  case "ORDEN":
                     sort = line.split(Pattern.quote(pSEPARADOR))[1];
                     break;
                  case "LLAVE":
                     keyPosition = Integer.parseInt(line.split(Pattern.quote(pSEPARADOR))[1]);
                     break;
               }
            }
            masterDescription.close();
            
            // First, create a temp file
            if (CreateFile(DIRECTORY + TEMP))
            {
               // second, Transfer values from binnacle and master to temp
               lines = TransferData(path, data, sort, keyPosition);
               
               //change name
               File masterFile = new File(DIRECTORY + MASTER + path);
               masterFile.delete();
               File tempFile = new File(DIRECTORY +TEMP);
               tempFile.renameTo(new File(DIRECTORY + MASTER + path));
               
               //clean binnacle
               RandomAccessFile binnacleFile = OpenFile(BINNACLE + path);
               binnacleFile.setLength(0);
               binnacleFile.close();
            }
            
            if (path.equals(BACKUP_FILE))
            {
               UpdateDescription(MASTER + path, data.split(Pattern.quote(SEPARADOR))[GetIndex(path, "user")], lines, 0);
               UpdateDescription(BINNACLE + path, data.split(Pattern.quote(SEPARADOR))[GetIndex(path, "user")], 0, 0);
            }
            else
            {
               RandomAccessFile masterFile = OpenFile(MASTER + path);

               while(masterFile.getFilePointer() != masterFile.length())
               {
                     inactive += (masterFile.readLine().split(Pattern.quote(SEPARADOR))[GetIndex(path, "status")].equals("0")) ? 1:0;
               }
               masterFile.close();
               UpdateDescription(MASTER + path, data.split(Pattern.quote(SEPARADOR))[GetIndex(path, "user")], lines -inactive, inactive);
               UpdateDescription(BINNACLE + path, data.split(Pattern.quote(SEPARADOR))[GetIndex(path, "user")], 0, 0);
            }
            return WriteFile(path, data);
         }
         catch (IOException | NumberFormatException e)
         {
            return false;
         }
   
   }
  
   private static  int TransferData(String path, String data, String sort, int keyPosition)
   {
      try
      {
         int length = 0;
         RandomAccessFile masterFile = OpenFile(MASTER + path);
         RandomAccessFile binnacleFile = OpenFile(BINNACLE + path);
         RandomAccessFile tempFile = OpenFile(TEMP);
                
         // from binnacle first
         while (binnacleFile.getFilePointer() != binnacleFile.length())
         {
            tempFile.seek(0);
            long seek = 0;
            String newLine = binnacleFile.readLine();
            String tempLine = "";
            
            if(!path.equals(BACKUP_FILE) && newLine.split(Pattern.quote(SEPARADOR))[GetIndex(path, "status")].equals("0")) continue;
            
            while (tempFile.getFilePointer() != tempFile.length())
            {
               seek = tempFile.getFilePointer();
               tempLine = tempFile.readLine();
               // Sort
               if ("ASC".equals(sort))
               {
                  // first, transfer register from binnacle
                  if (newLine.split(Pattern.quote(SEPARADOR))[keyPosition].compareTo(tempLine.split(Pattern.quote(SEPARADOR))[keyPosition]) <= 0)
                  {
                     break;
                  }

               }
               else if ("DES".equals(sort))
               {
                  if (newLine.split(Pattern.quote(SEPARADOR))[keyPosition].compareTo(tempLine.split(Pattern.quote(SEPARADOR))[keyPosition]) > 0)
                  {
                     break;
                  }

               }
               if (tempFile.getFilePointer() == tempFile.length())
               {
                  seek = tempFile.getFilePointer();
               }
            }
            if (seek >= tempFile.length())
            {
               tempFile.writeBytes(newLine+ "\r\n");
            }
            else 
            {
               while(true)
               {
                  tempFile.seek(seek);
                  tempFile.writeBytes(newLine + "\r\n");
                  newLine = tempLine;
                  seek = tempFile.getFilePointer();
                  tempLine = tempFile.readLine();
                  if (tempLine == null)
                  {
                     tempFile.writeBytes(newLine+ "\r\n");
                     break;
                  }
               }
            }
            length++;
         }
         
         // from master last
         while (masterFile.getFilePointer() != masterFile.length())
         {
            tempFile.seek(0);
            long seek = 0;
            String newLine = masterFile.readLine();
            String tempLine = "";
            
            if(!path.equals(BACKUP_FILE) && newLine.split(Pattern.quote(SEPARADOR))[GetIndex(path, "status")].equals("0")) continue;

            while (tempFile.getFilePointer() != tempFile.length())
            {
               seek = tempFile.getFilePointer();
               tempLine = tempFile.readLine();
               // Sort
               if ("ASC".equals(sort))
               {
                  // first, transfer register from binnacle
                  if (newLine.split(Pattern.quote(SEPARADOR))[keyPosition].compareTo(tempLine.split(Pattern.quote(SEPARADOR))[keyPosition]) <= 0)
                  {
                     break;
                  }

               }
               else if ("DES".equals(sort))
               {
                  if (newLine.split(Pattern.quote(SEPARADOR))[keyPosition].compareTo(tempLine.split(Pattern.quote(SEPARADOR))[keyPosition]) > 0)
                  {
                     break;
                  }

               }
               if (tempFile.getFilePointer() == tempFile.length())
               {
                  seek = tempFile.getFilePointer();
               }
            }
            if (seek >= tempFile.length())
            {
               tempFile.writeBytes(newLine + "\r\n");
            }
            else 
            {
               while(true)
               {
                  tempFile.seek(seek);
                  tempFile.writeBytes(newLine + "\r\n");
                  newLine = tempLine;
                  seek = tempFile.getFilePointer();
                  tempLine = tempFile.readLine();
                  if (tempLine == null)
                  {
                     tempFile.writeBytes(newLine + "\r\n");
                     break;
                  }
               }
            }  
            length++;
         }
         
         
         tempFile.close();
         masterFile.close();
         binnacleFile.close();
         return length;
      }
      catch (Exception e)
      {
         return -1;
      }
   }
  
   private static boolean UpdateDescription(String path, String author, int active, int inactive) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
   {
      try
      {
         
         CreateFile(DIRECTORY + TEMP + DESCRIPTION + path);
         RandomAccessFile fileDescription = OpenFile(DESCRIPTION + path);
         RandomAccessFile fileTempDescription = OpenFile(TEMP + DESCRIPTION + path);
         
         while(fileDescription.getFilePointer() != fileDescription.length())
         {
            String line = fileDescription.readLine();            
            switch (line.split(Pattern.quote(pSEPARADOR))[0])
            {
               case "ACTIVOS":
                  line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + active + "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "INACTIVOS":
                  line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + inactive+ "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "MODIFICADO":
                  line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date())+ "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "AUTOR":
                  if (author != null)
                  {
                     line = line.split(Pattern.quote(pSEPARADOR))[0] + pSEPARADOR + author;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               default:
                     fileTempDescription.writeBytes(line + "\r\n");
                  break;
            }
         }
         fileDescription.close();
         fileTempDescription.close();
         
         //change name
         File oldDescription = new File(DIRECTORY +DESCRIPTION + path);
         oldDescription.delete();
         File newDescription = new File(DIRECTORY + TEMP +DESCRIPTION + path);
         newDescription.renameTo(new File(DIRECTORY + DESCRIPTION + path));
         
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
   
   private static boolean CreateMaster(String path, String author)
   {
      if (CreateFile(DIRECTORY + DESCRIPTION + MASTER + path)) //Creates file description
      {
         if (CreateFile(DIRECTORY + MASTER + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DIRECTORY + DESCRIPTION + MASTER + path), ENCODING)))
               {
                  writer.write("ARCHIVO" + pSEPARADOR + DIRECTORY + MASTER + path + "\r\n");
                  writer.write("DESCRIPCION" + pSEPARADOR + path.split(Pattern.quote("."))[0] + " del sistema\r\n");
                  writer.write("TIPO" + pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + pSEPARADOR + "Secuencial\r\n");
                  writer.write("AUTOR" + pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + pSEPARADOR + "|\r\n");
                  writer.write("LLAVE" + pSEPARADOR + GetKeys(path) + "\r\n");
                  writer.write("ORDEN" + pSEPARADOR + "ASC\r\n");
                  writer.write("ACTIVOS" + pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + pSEPARADOR + "0\r\n");
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
   
   private static String GetKeys(String path)
   {
      String[] fileName = path.split(Pattern.quote(File.separator));
      String name = fileName[fileName.length -1];
      
      switch (name)
      {
         case USER_FILE:
            return "0";//user
         case BACKUP_FILE:
            return "2";//date
         case FRIENDS_FILE:
            return "0,1"; //user, user's friend
         case GROUPS_FILE:
            return "0,1"; //user, group
         case GROUPS_FRIENDS_FILE:
            return "0,1,2"; //user, group,  user's friend
         default:
            return "0";
      }
   }
   
   private static int GetIndex(String path, String value)
   {
      String[] fileName = path.split(Pattern.quote(File.separator));
      String name = fileName[fileName.length -1];
      
      switch (name)
      {
         case USER_FILE:
            switch (value.toUpperCase())
            {
               case "STATUS":
                  return 10;
               case "USER":
                  return 0;
               default:
                  return -1;
            }
         case BACKUP_FILE:
            switch (value.toUpperCase())
            {
               case "USER":
                  return 1;
               default:
                  return -1;
            }
         case FRIENDS_FILE:
            switch (value.toUpperCase())
            {
               case "STATUS":
                  return 5;
               case "USER":
                  return 0;
               default:
                  return -1;
            }
         case GROUPS_FILE:
            switch (value.toUpperCase())
            {
               case "STATUS":
                  return 5;
               case "USER":
                  return 0;
               default:
                  return -1;
            }
         case GROUPS_FRIENDS_FILE:
            switch (value.toUpperCase())
            {
               case "STATUS":
                  return 4;
               case "USER":
                  return 0;
               default:
                  return -1;
            }
         default:
            return -1;
      }
   }
}
