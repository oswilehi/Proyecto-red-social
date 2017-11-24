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
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

public class FileManager
{
   public static final String DIRECTORY = "C:" + File.separator + "MEIA" + File.separator; 
   public static final String USER_FILE = "Usuario.txt";
   public static final String BINNACLE = "bitacora_";
   public static final String MASTER = "";
   public static final String TEMP = "data.temp";
   public static final String DESCRIPTION ="Desc_";
   public static final String IMAGES = "fotografia";
   public static final String ANOTHER_IMAGES = "imagenes";
   public static final String ENCODING = "utf-8";
   public static final String SEPARADOR = "|";
   public static final String pSEPARADOR = "::";
   public static final String BACKUP_FILE = "backup.txt";
   public static final String BACKUP_DIRECTORY = File.separator + "MEIA_backup";
   public static final String FRIENDS_FILE = "lista_amigos.txt";
   public static final String GROUPS_FILE = "grupo.txt";
   public static final String MESSAGE_FILE = "mensajes.txt";
   public static final String IMAGE_FILE = "imagen_usuario.txt";
   public static final String GROUPS_FRIENDS_FILE = "grupo_amigos.txt";
   public static final String INDEX  = "indice_";
   
   public static final int Length = 260;
   public static final int UserLength = 260;
   public static final int FriendLength = 77;
   public static final int GroupLength = 130;
   public static final int GaleryLength = 100;
  
   public static final int BackupLength = 150;
   protected FileManager(){}
   
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
      if (key == null || "".equals(key)) return null;
      return Secuencial.Search(USER_FILE, GetKeys(USER_FILE), key);
   }
   
   public static String SearchFriend(String userKey, String friendKey)
   {
      if (userKey == null || "".equals(userKey)) return null;
      if (friendKey == null || "".equals(friendKey)) return null;
      return Secuencial.Search(FRIENDS_FILE, GetKeys(FRIENDS_FILE), userKey + friendKey);
   }
   
   public static String SearchGroup(String userKey, String groupKey)
   {
      if (userKey == null || "".equals(userKey)) return null;
      if (groupKey == null || "".equals(groupKey)) return null;
      return Secuencial.Search(GROUPS_FILE, GetKeys(GROUPS_FILE), userKey + groupKey);
   }
   
   public static String SearchFriendInGroup(String groupKey, String userKey, String friendKey)
   {
      if (groupKey == null || "".equals(groupKey)) return null;
      if (userKey == null || "".equals(userKey)) return null;
      if (friendKey == null || "".equals(friendKey)) return null;
      return SecuencialIndizado.Search(GROUPS_FRIENDS_FILE, GetKeys(GROUPS_FRIENDS_FILE), groupKey + userKey + friendKey);
   }
   
   public static String SearchImage(String path, String key, String value){
       if (path.equals(IMAGE_FILE)) return ArbolBinario.Search(path, key, value, false);
       return null;
   }
   
   public static String SearchByKey(String path, String keys, String values)
   {
      if (path.equals(USER_FILE) || path.equals(FRIENDS_FILE) || path.equals(GROUPS_FILE) || path.equals(BACKUP_FILE) || path.equals(MESSAGE_FILE)) return Secuencial.GetAllOfKey(path, keys, values);
      if (path.equals(GROUPS_FRIENDS_FILE)) return SecuencialIndizado.GetAllOfKey(path, keys, values); // debe retornar del metodo secuencial indiza (a crear)...
      if (path.equals(IMAGE_FILE)) return ArbolBinario.Search(path, keys, values, true);
      return null;
   }
   
   public static boolean WriteFile(String path, String data)  // only used to add new lines to text file
   {
         if (path.equals(USER_FILE) || path.equals(FRIENDS_FILE) || path.equals(GROUPS_FILE) || path.equals(BACKUP_FILE) || path.equals(MESSAGE_FILE)) return Secuencial.Write(path, data);
         if (path.equals(GROUPS_FRIENDS_FILE)) return SecuencialIndizado.Write(path, GetKeys(path), data) ; // debe retornar del metodo secuencial indiza (a crear)...
         if (path.equals(IMAGE_FILE)) return ArbolBinario.Write(path, GetKeys(path), data);
         return false;
   }
   
   public static boolean Update(String path, String data)//*-
   {
      if (path.equals(USER_FILE) || path.equals(FRIENDS_FILE) || path.equals(GROUPS_FILE) || path.equals(MESSAGE_FILE)) return Secuencial.Update(path, data);
      if (path.equals(GROUPS_FRIENDS_FILE)) return SecuencialIndizado.Update(path, data); // debe retornar del metodo update secuencial indiza (a crear)...
      if (path.equals(IMAGE_FILE)) return ArbolBinario.Delete(path, GetKeys(path), data);
      return false;
   }
   
   public static boolean Reorganize(String user)
   {
      if(FileManager.FileExists(FileManager.INDEX + GROUPS_FRIENDS_FILE))
      {
         return SecuencialIndizado.Reorganize(GROUPS_FRIENDS_FILE, user);
      }
      return false;
   }
   
   public static String GetFriendsOfUser(String userKey)
   {
      return Secuencial.GetAllOfKey(FRIENDS_FILE, "0", userKey);
   }
   
   public static String GetGroupsOfUser(String userKey)
   {
      return Secuencial.GetAllOfKey(GROUPS_FILE, "0", userKey);
   }
   
   protected static void copyDirectory(File sourceLocation , File targetLocation)
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
   
   protected static boolean CreateFile(String path)
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
   
   protected static String GetKeys(String path)
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
         case MESSAGE_FILE:
            return "0,1,2"; //user,user's friend, date
         case IMAGE_FILE:
            return "0,1";
         default:
            return "0";
      }
   }
   
   protected static int GetIndexOf(String path, String value)
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
         case MESSAGE_FILE:
            switch (value.toUpperCase())
            {
               case "STATUS":
                  return 5;
               case "USER":
                  return 0;
               default:
                  return -1;
            }
         case IMAGE_FILE:
            switch (value.toUpperCase())
            {
               case "STATUS":
                  return 3;
               case "USER":
                  return 0;
               default:
                  return -1;
            }
         default:
            return -1;
      }
   }
   
   protected static String FixSize(String data, int length)
   {
      int x = data.length();
      for (int i = 0; i < length - x - 2; i++)
      {
         data += "¬";
      }
      return data;
   }
}

class Secuencial
{
   protected static boolean Write(String path, String data)
   {
      if(!FileManager.FileExists(FileManager.BINNACLE + path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Bitacora
            CreateBinnacle(path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")]);
         }
         
         try
         {
            //Validamos que no exista otra clave igual
            String[] keys = FileManager.GetKeys(path).split(Pattern.quote(","));
            if (path.equals(FileManager.USER_FILE) && FileManager.SearchUser(data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[0])]) != null) return false;
            if (path.equals(FileManager.FRIENDS_FILE) && FileManager.SearchFriend(data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[0])],data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[1])]) != null) return false;
            if (path.equals(FileManager.GROUPS_FILE) && FileManager.SearchGroup(data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[0])],data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[1])]) != null) return false;

            //Clave validada
            //Abrimos el descriptor de la bitacora del archivo
            //para obtener los registra activos, inactivos y el límite 
            //de inactivos para reorganizar
            RandomAccessFile binnacleDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.BINNACLE + path);
            int active = 0;
            int inactive = 0;
            int max = 0;
            while(binnacleDescription.getFilePointer() != binnacleDescription.length())
            {
               String line = binnacleDescription.readLine();
               
               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "ACTIVOS":
                     active = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     inactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "MAXIMO":
                     max = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            //se cierra el discriptor de bitacora.
            binnacleDescription.close();
            
            
            //se valida si es necesario reorganizar
            if (active + inactive >=  max)
            {
               Secuencial.Reorganize(path, data);
            }
            else
            {
               // No se reorganiza; se escribe a bitacora
               RandomAccessFile binnacleFile = FileManager.OpenFile(FileManager.BINNACLE + path);
               binnacleFile.seek(binnacleFile.length());
               binnacleFile.writeBytes(data + "\r\n");
               binnacleFile.close();
               //se actualiza el descriptor
               UpdateDescription(FileManager.BINNACLE + path, null, active + 1, inactive);
            }
            return true;
         }
         catch (IOException | NumberFormatException e)
         {
            return false;
         }
   }   
   
   protected static boolean Update(String path, String data)
   {
      try
      {
         if (FileManager.FileExists(FileManager.BINNACLE + path))
         {
            RandomAccessFile File = FileManager.OpenFile(FileManager.BINNACLE + path);
            long seek;
            String line;
            String[] keys = FileManager.GetKeys(path).split(Pattern.quote(","));
            boolean matchKeys = true;
            
            while(File.getFilePointer() != File.length())
            {
               seek = File.getFilePointer();
               line = File.readLine();
               for (String key : keys)
               {
                  matchKeys = (line.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)].equals(data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)])) && line.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("1");
                  if(!matchKeys) break;
               }
               if(!matchKeys) continue;
               
               File.seek(seek);
                  File.writeBytes(data);
                  File.close();
                  
                  RandomAccessFile binnacleDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.BINNACLE + path);
                  int active = 0;
                  int inactive = 0;
                  while(binnacleDescription.getFilePointer() != binnacleDescription.length())
                  {
                     line = binnacleDescription.readLine();

                     switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
                     {
                        case "ACTIVOS":
                           active = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                        case "INACTIVOS":
                           inactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                     }
                  }
                  binnacleDescription.close();
                  
                  int x = Integer.parseInt(data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")]) - 1;
                  UpdateDescription(FileManager.BINNACLE + path, null, active + x, inactive - x);
                  
                  return true;
            }
            File.close();
         }
         
         if (FileManager.FileExists(FileManager.MASTER + path))
         {
            RandomAccessFile File = FileManager.OpenFile(FileManager.MASTER + path);
            long seek;
            String line;
            String[] keys = FileManager.GetKeys(path).split(Pattern.quote(","));
            boolean matchKeys = true;
            
            while(File.getFilePointer() != File.length())
            {
               seek = File.getFilePointer();
               line = File.readLine();
               for (String key : keys)
               {
                  matchKeys = (line.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)].equals(data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)]));
                  if(!matchKeys) break;
               }
               if(!matchKeys) continue;
               
               File.seek(seek);
                  File.writeBytes(data);
                  File.close();
                  
                  RandomAccessFile masterDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.MASTER + path);
                  int active = 0;
                  int inactive = 0;
                  while(masterDescription.getFilePointer() != masterDescription.length())
                  {
                     line = masterDescription.readLine();

                     switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
                     {
                        case "ACTIVOS":
                           active = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                        case "INACTIVOS":
                           inactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                     }
                  }
                  masterDescription.close();
                  
                  int x = Integer.parseInt(data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")]) - 1;
                  UpdateDescription(FileManager.MASTER + path, null, active + x, inactive - x);
                  
                  return true;
            }
            File.close();
         }
         return false;
      }
      catch (IOException | NumberFormatException e)
      {
         return false;
      }
   }
   
   protected static String Search(String path, String keys, String values)
   {
      try
      {
         if (FileManager.FileExists(FileManager.MASTER + path))
         {
            RandomAccessFile File = FileManager.OpenFile(FileManager.MASTER + path);
            String[] keysPosition = keys.split(Pattern.quote(","));
            int statusIndex = FileManager.GetIndexOf(path, "status");
            
            while(File.getFilePointer() != File.length())
            {
               String line = File.readLine();
               
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[statusIndex].equals("0")) continue;
               
               String tempLine = "";
               for (int i = 0; i < keysPosition.length; i++)
               {
                  tempLine += line.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keysPosition[i])];
               }
               
               if(tempLine.equals(values))
               {
                  File.close();
                  return line;
               }
            }
            File.close();
         }
         
         if (FileManager.FileExists(FileManager.BINNACLE + path))
         {
            RandomAccessFile File = FileManager.OpenFile(FileManager.BINNACLE + path);
            String[] keysPosition = keys.split(Pattern.quote(","));
            int statusIndex = FileManager.GetIndexOf(path, "status");
            
            while(File.getFilePointer() != File.length())
            {
               String line = File.readLine();
               
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[statusIndex].equals("0")) continue;
               
               String tempLine = "";
               for (int i = 0; i < keysPosition.length; i++)
               {
                  tempLine += line.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keysPosition[i])];
               }
               
               if(tempLine.equals(values))
               {
                  File.close();
                  return line;
               }
            }
            File.close();
         }
         return null;
      }
      catch (IOException | NumberFormatException e)
      {
         return null;
      }
   }
   
   protected static boolean Reorganize(String path, String data)
   {
      if(!FileManager.FileExists(FileManager.MASTER + path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Maestro
            
            CreateMaster(path, path.equals(FileManager.BACKUP_FILE) ? data : data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")]);
         }
         
         try
         {
            RandomAccessFile masterDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.MASTER + path);
            int inactive = 0;
            String[] keys = null;
            int lines = 0;
            String sort = "NULL";
            
            // Get values
            
            while(masterDescription.getFilePointer() != masterDescription.length())
            {
               String line = masterDescription.readLine();
               
               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "ORDEN":
                     sort = line.split(Pattern.quote(FileManager.pSEPARADOR))[1];
                     break;
                  case "LLAVE":
                     keys = (line.split(Pattern.quote(FileManager.pSEPARADOR))[1]).split(Pattern.quote(","));
                     break;
               }
            }
            masterDescription.close();
            
            // First, create a temp file
            if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.TEMP))
            {
               // second, Transfer values from binnacle and master to temp
               lines = TransferData(path, data, sort, keys);
               
               //change name
               File masterFile = new File(FileManager.DIRECTORY + FileManager.MASTER + path);
               masterFile.delete();
               File tempFile = new File(FileManager.DIRECTORY +FileManager.TEMP);
               tempFile.renameTo(new File(FileManager.DIRECTORY + FileManager.MASTER + path));
               
               //clean binnacle
               RandomAccessFile binnacleFile = FileManager.OpenFile(FileManager.BINNACLE + path);
               binnacleFile.setLength(0);
               binnacleFile.close();
            }
            
            if (path.equals(FileManager.BACKUP_FILE))
            {
               UpdateDescription(FileManager.MASTER + path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")], lines, 0);
               UpdateDescription(FileManager.BINNACLE + path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")], 0, 0);
            }
            else
            {
               RandomAccessFile masterFile = FileManager.OpenFile(FileManager.MASTER + path);

               while(masterFile.getFilePointer() != masterFile.length())
               {
                     inactive += (masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("0")) ? 1:0;
               }
               masterFile.close();
               UpdateDescription(FileManager.MASTER + path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")], lines -inactive, inactive);
               UpdateDescription(FileManager.BINNACLE + path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")], 0, 0);
            }
            return FileManager.WriteFile(path, data);
         }
         catch (IOException | NumberFormatException e)
         {
            return false;
         }
   
   }
  
   protected static  int TransferData(String path, String data, String sort, String[] keys)
   {
      try
      {
         // inciamos una variable que guardara el número de lineas que se transfieren...
         int length = 0;
         RandomAccessFile masterFile = FileManager.OpenFile(FileManager.MASTER + path);
         RandomAccessFile binnacleFile = FileManager.OpenFile(FileManager.BINNACLE + path);
         RandomAccessFile tempFile = FileManager.OpenFile(FileManager.TEMP);
                
         // se traslada primero el maestro porque ya está ordenado:
         
         while (masterFile.getFilePointer() != masterFile.length())
         {
            tempFile.seek(0);
            long seek = 0;
            String newLine = masterFile.readLine();
            String tempLine = "";
            
            if(!path.equals(FileManager.BACKUP_FILE) && newLine.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("0")) continue;

            while (tempFile.getFilePointer() != tempFile.length())
            {
               seek = tempFile.getFilePointer();
               tempLine = tempFile.readLine();
               String newLineKeyJoined = "", tempLineKeyJoined = "";
               
               for (String key : keys)
               {
                  newLineKeyJoined += newLine.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)];
                  tempLineKeyJoined += tempLine.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)];
               }
               // Se verifica que tipo de ordenamiento se requiere
               if ("ASC".equals(sort))
               {
                  // first, transfer register from binnacle
                  if (newLineKeyJoined.compareTo(tempLineKeyJoined) <= 0)
                  {
                     break;
                  }

               }
               else if ("DES".equals(sort))
               {
                  if (newLineKeyJoined.compareTo(tempLineKeyJoined) >= 0)
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
         
         // luego se traslada la bitacora 
         while (binnacleFile.getFilePointer() != binnacleFile.length())
         {
            tempFile.seek(0);
            long seek = 0;
            String newLine = binnacleFile.readLine();
            String tempLine = "";
            
            if(!path.equals(FileManager.BACKUP_FILE) && newLine.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("0")) continue;
            
            while (tempFile.getFilePointer() != tempFile.length())
            {
               seek = tempFile.getFilePointer();
               tempLine = tempFile.readLine();
               
               String newLineKeyJoined = "", tempLineKeyJoined = "";
               
               for (String key : keys)
               {
                  newLineKeyJoined += newLine.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)];
                  tempLineKeyJoined += tempLine.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)];
               }
               // Sort
               if ("ASC".equals(sort))
               {
                  // first, transfer register from binnacle
                  if (newLineKeyJoined.compareTo(tempLineKeyJoined) <= 0)
                  {
                     break;
                  }

               }
               else if ("DES".equals(sort))
               {
                  if (newLineKeyJoined.compareTo(tempLineKeyJoined) >= 0)
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
  
   protected static boolean UpdateDescription(String path, String author, int active, int inactive) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
   {
      try
      {
         
         FileManager.CreateFile(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + path);
         RandomAccessFile fileDescription = FileManager.OpenFile(FileManager.DESCRIPTION + path);
         RandomAccessFile fileTempDescription = FileManager.OpenFile(FileManager.TEMP + FileManager.DESCRIPTION + path);
         
         while(fileDescription.getFilePointer() != fileDescription.length())
         {
            String line = fileDescription.readLine();            
            switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
            {
               case "ACTIVOS":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + active + "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "INACTIVOS":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + inactive+ "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "MODIFICADO":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date())+ "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "AUTOR":
                  if (author != null)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + author;
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
         File oldDescription = new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + path);
         oldDescription.delete();
         File newDescription = new File(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + path);
         newDescription.renameTo(new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + path));
         
         return true;
      }
      catch (IOException e)
      {
         return false;
      }
   }
   
   protected static boolean CreateBinnacle(String path, String author)
   {
      if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.BINNACLE + path)) //Creates file description
      {
         if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.BINNACLE + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.BINNACLE + path), FileManager.ENCODING)))
               {
                  writer.write("ARCHIVO" + FileManager.pSEPARADOR + FileManager.DIRECTORY + FileManager.BINNACLE + path + "\r\n");
                  writer.write("DESCRIPCION" + FileManager.pSEPARADOR + "Bitácora de " + path.split(Pattern.quote("."))[0] +"\r\n");
                  writer.write("TIPO" + FileManager.pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + FileManager.pSEPARADOR + "Apilo\r\n");
                  writer.write("AUTOR" + FileManager.pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + FileManager.pSEPARADOR + "|\r\n");
                  writer.write("ACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("MAXIMO" + FileManager.pSEPARADOR + "5");
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
   
   protected static boolean CreateMaster(String path, String author)
   {
      if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + path)) //Creates file description
      {
         if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.MASTER + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + path), FileManager.ENCODING)))
               {
                  writer.write("ARCHIVO" + FileManager.pSEPARADOR + FileManager.DIRECTORY + FileManager.MASTER + path + "\r\n");
                  writer.write("DESCRIPCION" + FileManager.pSEPARADOR + path.split(Pattern.quote("."))[0] + " del sistema\r\n");
                  writer.write("TIPO" + FileManager.pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + FileManager.pSEPARADOR + "Secuencial\r\n");
                  writer.write("AUTOR" + FileManager.pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + FileManager.pSEPARADOR + "|\r\n");
                  writer.write("LLAVE" + FileManager.pSEPARADOR + FileManager.GetKeys(path) + "\r\n");
                  writer.write("ORDEN" + FileManager.pSEPARADOR + "ASC\r\n");
                  writer.write("ACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
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
   
   protected static String GetAllOfKey(String path, String keys, String values)
   {
      try
      {
         String data = "";
         String[] Keys = keys.split(Pattern.quote(","));
         String[] Values = values.split(Pattern.quote(","));
         int statusIndex = FileManager.GetIndexOf(path, "status");
         
         if (Keys.length != Values.length) return null;
         
         if(FileManager.FileExists(FileManager.BINNACLE + path))
         {
            RandomAccessFile File = FileManager.OpenFile(FileManager.BINNACLE + path);
            
            while(File.getFilePointer() != File.length())
            {
               String line = File.readLine();
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[statusIndex].equals("0")) continue;
               boolean ok = false;
               for (int i = 0; i < Keys.length; i++)
               {
                  if (!line.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(Keys[i])].toUpperCase().startsWith(Values[i].toUpperCase())) break;
                  ok = i == Keys.length - 1;
               }
               
               if (ok) data += line.replace("¬", "") + FileManager.pSEPARADOR;
            }
            File.close();
         }
         
         if(FileManager.FileExists(FileManager.MASTER + path))
         {
            RandomAccessFile File = FileManager.OpenFile(FileManager.MASTER + path);
            
            while(File.getFilePointer() != File.length())
            {
               String line = File.readLine();
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[statusIndex].equals("0")) continue;
               boolean ok = false;
               for (int i = 0; i < Keys.length; i++)
               {
                  if (!line.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(Keys[i])].toUpperCase().startsWith(Values[i].toUpperCase())) break;
                  ok = i == Keys.length - 1;
               }
               
               if (ok) data += line.replace("¬", "") + FileManager.pSEPARADOR;
            }
            File.close();
         }
         
         if (data.equals("")) return null;
         return data.substring(0, data.length() - 2);
      }
      catch (Exception e)
      {
         return null;
      }
   }
}

class SecuencialIndizado
{
   protected static boolean Write(String path, String keysString, String data)
   {
      if(!FileManager.FileExists(FileManager.INDEX + path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Índice
            CreateIndex(path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")]);
         }
         
         try
         {
            //Validamos que no exista otra clave igual
            String[] keys = keysString.split(Pattern.quote(","));
            if (path.equals(FileManager.GROUPS_FRIENDS_FILE) && FileManager.SearchFriendInGroup(data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[0])], data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[1])], data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(keys[2])]) != null) return false;

            //Clave validada
            //Abrimos el descriptor del indice del archivo
            //para obtener el primer registro y el bloque actual
            RandomAccessFile indexDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.INDEX + path);
            int firstR = 0;
            int indexCount = 0;
            int currentBlock = 0;
            int indexActive = 0;
            int indexInactive = 0;
            
            while(indexDescription.getFilePointer() != indexDescription.length())
            {
               String line = indexDescription.readLine();
               
               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "INICIAL":
                     firstR = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "BLOQUE_ACTUAL":
                     currentBlock = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "ACTIVOS":
                     indexActive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     indexInactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "REGISTROS":
                     indexCount = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            //se cierra el descriptor del indice.
            indexDescription.close();
            
            
            //Se valida la existencia del bloque actual
            if (!FileManager.FileExists(FileManager.MASTER + currentBlock + "_" + path ))
            {
               CreateMaster(currentBlock + "_" + path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")]);
            }
            
            //Abrimos el descriptor del maestro del archivo
            //para obtener el número de registros, el maximo de registro del bloque, y tipo de ordenamiento

            RandomAccessFile masterDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.MASTER + currentBlock + "_" + path);
            int masterCount = 0;
            int maxR = 0;
            int masterActive = 0;
            int masterInactive = 0;
                  

            while(masterDescription.getFilePointer() != masterDescription.length())
            {
               String line = masterDescription.readLine();
               
               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "REGISTROS":
                     masterCount = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "MAXIMO":
                     maxR = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "ACTIVOS":
                     masterActive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     masterInactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            
            masterDescription.close();
            
            //se valida si el bloque actual aun puede almacenar datos
            if (masterCount >=  maxR)
            {
               //El bloque ya esta lleno, se crea el siguiente.
               currentBlock++;
               CreateMaster(currentBlock + "_" +path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")]);
               //Se actualizan los datos con los valores correctos
               masterCount = 0;
               masterActive = 0;
               masterInactive = 0;
            }
            
            //Se abren los archivos correctos
            RandomAccessFile indexFile = FileManager.OpenFile(FileManager.INDEX + path);
            RandomAccessFile masterFile = FileManager.OpenFile(FileManager.MASTER + currentBlock + "_" + path);
            
            //Escribimos primero al archivo maestro
            //Escribimos al final del archivo
            masterFile.seek(masterFile.length());
            masterFile.writeBytes(FileManager.FixSize(data, FileManager.Length)+"\r\n");
            //Cerramos el archivo maestro
            masterFile.close();
            
            //Escribimos ahora en el archivo indizado
            //Las llaves ya las hemos verificado anteriomente... Generamos una clave con las claves
            String key = "";
            for (String value : keys)
            {
               key += data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(value)];
            }
            //Ahora se obtiene la posicion en la que se debe ubicar de forma logica, pues el registro siempre se escribe al final
            String dataToAdd = "";
            String dataToUpdate = "";
            
            
            if (firstR == 0)
            {

               dataToAdd = (indexCount+1) + FileManager.SEPARADOR + currentBlock + "." +  (masterCount+1) + FileManager.SEPARADOR + key + FileManager.SEPARADOR + "0" + FileManager.SEPARADOR + "1" + FileManager.SEPARADOR;
               indexFile.seek(indexFile.length());
               indexFile.writeBytes(FileManager.FixSize(dataToAdd, FileManager.Length)+"\r\n");
               indexFile.close();
               firstR = indexCount+1;

            }
            else
            {
               int lastR = firstR;
               int newR = firstR;
               while(true)
               {
                  indexFile.seek((newR-1) * FileManager.Length);
                  String line = indexFile.readLine();
                  
                  if (Integer.parseInt(line.split(Pattern.quote(FileManager.SEPARADOR))[3]) == 0 && key.compareTo(line.split(Pattern.quote(FileManager.SEPARADOR))[2]) > 0 ) // Debe ir al final
                  {

                     dataToAdd = (indexCount +1) + FileManager.SEPARADOR + currentBlock + "." + (masterCount+1) + FileManager.SEPARADOR + key + FileManager.SEPARADOR + "0" + FileManager.SEPARADOR + "1" + FileManager.SEPARADOR;
                     String[] temp = line.split(Pattern.quote(FileManager.SEPARADOR));
                     temp[3] = Integer.toString(indexCount+1);

                     for (int i = 0; i < temp.length - 1; i++)
                     {
                        dataToUpdate += temp[i] + FileManager.SEPARADOR;
                     }
                     break;
                  }
                  else if (key.compareTo(line.split(Pattern.quote(FileManager.SEPARADOR))[2]) <= 0 && newR == firstR) // Queda como primer elemento
                  {

                     firstR  =  indexCount + 1;
                     dataToAdd = (indexCount +1) + FileManager.SEPARADOR + currentBlock + "." + (masterCount+1) + FileManager.SEPARADOR + key + FileManager.SEPARADOR + line.split(Pattern.quote(FileManager.SEPARADOR))[0] + FileManager.SEPARADOR + "1" + FileManager.SEPARADOR;

                     break;
                  }
                  else if (key.compareTo(line.split(Pattern.quote(FileManager.SEPARADOR))[2]) <= 0)// va en medio de dos valores
                  {

                     dataToAdd = (indexCount+1) + FileManager.SEPARADOR + currentBlock + "." + (masterCount +1) + FileManager.SEPARADOR + key + FileManager.SEPARADOR + newR + FileManager.SEPARADOR + "1" + FileManager.SEPARADOR;
                     indexFile.seek((lastR-1) * FileManager.Length);
                     String[] temp = indexFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                     temp[3] = Integer.toString(indexCount + 1);

                     for (int i = 0; i < temp.length - 1; i++)
                     {
                        dataToUpdate += temp[i]+ FileManager.SEPARADOR;
                     }
                     newR = lastR;
                     break;
                  }
                  
                  lastR = newR;
                  newR = Integer.parseInt(line.split(Pattern.quote(FileManager.SEPARADOR))[3]);
               }
               
               indexFile.seek(indexFile.length());
               indexFile.writeBytes(FileManager.FixSize(dataToAdd, FileManager.Length)+"\r\n");
               if (!dataToUpdate.equals(""))
               {
                  indexFile.seek((newR-1) * FileManager.Length);
                  indexFile.writeBytes(dataToUpdate);
               }
               indexFile.close();
            }
            //Actualizamos los descriptores
            UpdateMasterDescription(currentBlock + "_" + path, null, masterCount+1, masterActive +1, masterInactive);
            UpdateIndexDescription(path, null, currentBlock, firstR, indexCount +1, indexActive +1,indexInactive);
            return true;
         }
         catch (IOException | NumberFormatException e)
         {
            return false;
         }
   }
   
   protected static boolean Update(String path, String data)
   {
      try
      {
         //Se verifica que el archivo exista
         if(FileManager.FileExists(FileManager.INDEX + path))
         {
            //Se abre el descriptor para obtener el puntero al primer elemento
            RandomAccessFile indexDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.INDEX + path);
            int firstR = 0;
            int indexCount = 0;
            int currentBlock = 0;
            int indexActive = 0;
            int indexInactive = 0;
            while(indexDescription.getFilePointer() != indexDescription.length())
            {
               String line = indexDescription.readLine();

               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "INICIAL":
                     firstR = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "BLOQUE_ACTUAL":
                     currentBlock = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "ACTIVOS":
                     indexActive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     indexInactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "REGISTROS":
                     indexCount = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            indexDescription.close();
            //Obtenemos las llaves
            String[] keys = FileManager.GetKeys(path).split(Pattern.quote(","));
            String newKey = "";
            String oldKey = null;
            
            //Generamos la llave que se va a actualizar
            for (String key : keys)
            {
               newKey += data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)];
            }
            
            //Variables puntero
            int newR = firstR;
            int lastR = firstR;
            
            //Cargamos el indice para buscar
            RandomAccessFile indexFile = FileManager.OpenFile(FileManager.INDEX + path);
            while (true)
            {
               //Establecemos el puntero en el lugar correcto para leer la línea
               indexFile.seek((newR -1) * FileManager.Length);
               String line = indexFile.readLine();
               
               //Obtenemos la llave
               oldKey = line.split(Pattern.quote(FileManager.SEPARADOR))[2];
               
               //Encaja la llave vieja con la nueva?
               if (newKey.equals(oldKey)) // Son iguales pero no esta dado de baja
               {
                     
                  //Movemos el puntero a la posicion correcta
                  indexFile.seek((newR -1) * FileManager.Length);
                  
                  //Separamos los datos para obtenerlos más facil
                  String[] temp = line.split(Pattern.quote(FileManager.SEPARADOR));
                  
                  //Escribimos la cadena ya actualizada en el indice
                  indexFile.writeBytes(FileManager.FixSize((temp[0] + FileManager.SEPARADOR + temp[1] + FileManager.SEPARADOR + oldKey + FileManager.SEPARADOR + temp[3] + FileManager.SEPARADOR + data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")] + FileManager.SEPARADOR), FileManager.Length)+ "\r\n");
                  
                  //Escribimos el registro ya actualizado
                  //Primero abrimos el master del archivo
                  RandomAccessFile masterFile = FileManager.OpenFile(FileManager.MASTER + temp[1].split(Pattern.quote("."))[0] + "_" + path);
                  //Colocamos el punteoro en la posicion correcta
                  masterFile.seek((Integer.parseInt(temp[1].split(Pattern.quote("."))[1]) - 1 ) * FileManager.Length);
                  //Escribimos el puntero
                  masterFile.writeBytes(data);
                  
                  //Salvamos el bloque actual
                  currentBlock = Integer.parseInt(temp[1].split(Pattern.quote("."))[0]);
                  
                  RandomAccessFile masterDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.MASTER + temp[1].split(Pattern.quote("."))[0] + "_" + path);
                  int masterCount = 0;
                  int maxR = 0;
                  int masterActive = 0;
                  int masterInactive = 0;

                  while(masterDescription.getFilePointer() != masterDescription.length())
                  {
                     String tempLine = masterDescription.readLine();

                     switch (tempLine.split(Pattern.quote(FileManager.pSEPARADOR))[0])
                     {
                        case "REGISTROS":
                           masterCount = Integer.parseInt(tempLine.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                        case "MAXIMO":
                           maxR = Integer.parseInt(tempLine.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                        case "ACTIVOS":
                           masterActive = Integer.parseInt(tempLine.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                        case "INACTIVOS":
                           masterInactive = Integer.parseInt(tempLine.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                           break;
                     }
                  }
                  masterDescription.close();
                  masterFile.close();//Se cierra el archivo
                  
                  //Se valida si la data actualizada fue dada de baja
                  if (data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("0") && newR == firstR)
                  {
                     //El registro se dio de baja y era el primer registro del indice... 
                     //Solo se cambia el puntero del descriptor del archivo.
                     firstR = Integer.parseInt(temp[3]);
                     indexActive--;
                     indexInactive++;
                     masterActive--;
                     masterInactive++;
                  }
                  else if(data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("0"))
                  {
                     //El registro se dio de baja pero no era el primer registro del indice...
                     //Se recupera el puntero al siguiente registro que guarda el anterior registro ahora dado de baja
                     String pointer = temp[3];
                     //Se coloca el puntero en el registro anterior al registro dado de baja
                     indexFile.seek((lastR -1) * FileManager.Length);
                     //Se obtienen los datos para manejarlos mejor
                     temp = indexFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                     //Se coloca el puntero en la posicion correcta
                     indexFile.seek((lastR -1) * FileManager.Length);
                     //Se actualiza el anterior registro con el punto que el registro dado de baja tenia
                     indexFile.writeBytes(FileManager.FixSize((temp[0] + FileManager.SEPARADOR + temp[1] + FileManager.SEPARADOR + temp[2] + FileManager.SEPARADOR + pointer + FileManager.SEPARADOR + temp[4] + FileManager.SEPARADOR), FileManager.Length)+ "\r\n");
                     
                     indexActive--;
                     indexInactive++;
                     masterActive--;
                     masterInactive++;
                  }
                  
                  //Se actualizan el descriptor del indice
                  //Al final siempre se cierra el archivo y se retorna true
                  indexFile.close();
                  UpdateIndexDescription(path, null, -1, firstR, indexCount, indexActive, indexInactive);
                  UpdateMasterDescription(FileManager.MASTER + currentBlock + "_" + path, null, masterCount, masterActive, masterInactive);
                  return true;
               }
               
               // El registro a actualizar no existe
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[3].equals("0"))// No se ha encontrado la llave -> el puntero siguiente es 0 o null 
               {
                  indexFile.close();
                  break;
               }
               lastR = newR;
               newR = Integer.parseInt(line.split(Pattern.quote(FileManager.SEPARADOR))[3]);
            }
            indexFile.close();           
            return false;
         }
         //El archivo no existe, nada que actualizar
         return false;
      }
      catch (Exception e)
      {
         return false;
      }
   }
   
   protected static String Search(String path, String keys, String values)
   {
      try
      {
         if (FileManager.FileExists(FileManager.INDEX + path))
         {
            RandomAccessFile indexDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.INDEX + path);
            int first = 0;
            
            while(indexDescription.getFilePointer() != indexDescription.length())
            {
               String line = indexDescription.readLine();

               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "INICIAL":
                     first = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            indexDescription.close();
            
            RandomAccessFile indexFile = FileManager.OpenFile(FileManager.INDEX + path);
            String[] keysPosition = keys.split(Pattern.quote(","));
            int statusIndex = FileManager.GetIndexOf(path, "status");
            indexFile.seek((first - 1) * FileManager.Length);
            
            while(true)
            {
               String line = indexFile.readLine();
               
               String currentKey = line.split(Pattern.quote(FileManager.SEPARADOR))[2];
               
               if(currentKey.equals(values))
               {
                  indexFile.close();
                  if (line.split(Pattern.quote(FileManager.SEPARADOR))[statusIndex].equals("0")) return null;
                  return line;
               }
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[3].equals("0"))
               {
                  break;
               }
               indexFile.seek((Integer.parseInt(line.split(Pattern.quote(FileManager.SEPARADOR))[3]) - 1) * FileManager.Length);
            }
            indexFile.close();
            return null;
         }
         return null;
      }
      catch (IOException | NumberFormatException e)
      {
         return null;
      }
   }
   
   protected static boolean Reorganize(String path, String user)
   {
      try
      {
         // Primero, se crea un archivo temporal
         if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.INDEX + "_" +FileManager.TEMP))
         {  
            
            //Abrimos el archivo temporal
             RandomAccessFile tempFile = FileManager.OpenFile(FileManager.INDEX + "_" +FileManager.TEMP);
            
            //Ahora abrimos el index para obtener el numero de bloques
            //Obtenemos el primer puntero
            RandomAccessFile indexDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.INDEX + path);
            int count = 0;
            
            while(indexDescription.getFilePointer() != indexDescription.length())
            {
               String line = indexDescription.readLine();

               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "BLOQUE_ACTUAL":
                     count = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            indexDescription.close();
            
            //Ahora recorremos los archivos y tomamos los datos activos
            for (int i = 1; i < count + 1; i++)
            {
               // abrimos el archivo i
               RandomAccessFile masterFile = FileManager.OpenFile(FileManager.MASTER + i + "_" + path);
               if (masterFile == null) continue ;
               while(masterFile.getFilePointer() != masterFile.length())
               {
                  String line = masterFile.readLine().replace("¬", "");
                  if (line.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "status")].equals("1")) tempFile.writeBytes(FileManager.FixSize(line, FileManager.Length) + "\r\n");
               }
               masterFile.close();
               
               //Ya se validó el archivo, se borra
               File oldMasterFile = new File(FileManager.DIRECTORY + FileManager.MASTER + i + "_" + path);
               oldMasterFile.delete();
               File oldMasterDescription = new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + i + "_" + path);
               oldMasterDescription.delete();
            }
            
            //Ya se tienen todos los datos válidos. Se procede a la reestructuración.
            //Primero se borra el índice
            File oldIndexFile = new File(FileManager.DIRECTORY + FileManager.INDEX + path);
            oldIndexFile.delete();
            File oldIndexDescription = new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.INDEX + path);
            oldIndexDescription.delete();
            
            //Se coloca el puntero en el inicio del archivo
            tempFile.seek(0);
            
            //Se reorganiza el archivo secuencial indizado
            while(tempFile.getFilePointer() != tempFile.length())
            {
               FileManager.WriteFile(path, tempFile.readLine());
            }
            
            //Se actualiza el descriptor del archivo con el usuario que genero la reorganizacion
            if (FileManager.FileExists(FileManager.DESCRIPTION + FileManager.INDEX + path))
            {
               UpdateIndexDescription(path, user, -1, -1,-1,-1,-1);
            }
            
            //Se borra el archivo temporal
            tempFile.close();
            File oldTempFile = new File(FileManager.DIRECTORY + FileManager.INDEX + "_" +FileManager.TEMP);
            oldTempFile.delete();
            return true;
         }
         return false;
      }
      catch (IOException | NumberFormatException e)
      {
         return false;
      }
   }
   
   protected static boolean UpdateIndexDescription(String path, String author, int current_block, int first, int count, int active, int inactive) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
   {
      try
      {
         FileManager.CreateFile(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + FileManager.INDEX + path);
         RandomAccessFile fileDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.INDEX + path);
         RandomAccessFile fileTempDescription = FileManager.OpenFile(FileManager.TEMP + FileManager.DESCRIPTION + FileManager.INDEX + path);
         
         while(fileDescription.getFilePointer() != fileDescription.length())
         {
            String line = fileDescription.readLine();            
            switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
            {
               case "MODIFICADO":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date());
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "BLOQUE_ACTUAL":
                  if (current_block >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + current_block;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "INICIAL":
                  if (first >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + first;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "ACTIVOS":
                  if (active >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + active;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "INACTIVOS":
                  if (inactive >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + inactive;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "REGISTROS":
                  if (count >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + count;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "AUTOR":
                  if (author != null)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + author;
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
         File oldDescription = new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.INDEX + path);
         oldDescription.delete();
         File newDescription = new File(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + FileManager.INDEX+ path);
         newDescription.renameTo(new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.INDEX + path));
         return true;
      }
      catch (IOException e)
      {
         return false;
      }
   }
   
   protected static boolean UpdateMasterDescription(String path, String author, int count, int active, int inactive) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
   {
      try
      {
         
         FileManager.CreateFile(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + FileManager.MASTER + path);
         RandomAccessFile fileDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.MASTER + path);
         RandomAccessFile fileTempDescription = FileManager.OpenFile(FileManager.TEMP + FileManager.DESCRIPTION + FileManager.MASTER + path);
         
         while(fileDescription.getFilePointer() != fileDescription.length())
         {
            String line = fileDescription.readLine();            
            switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
            {
               case "MODIFICADO":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date())+ "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "REGISTROS":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + count + "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "ACTIVOS":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + active + "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "INACTIVOS":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + inactive + "\r\n";
                  fileTempDescription.writeBytes(line);
                  break;
               case "AUTOR":
                  if (author != null)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + author;
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
         File oldDescription = new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + path);
         oldDescription.delete();
         File newDescription = new File(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + FileManager.MASTER + path);
         newDescription.renameTo(new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + path));
         
         return true;
      }
      catch (IOException e)
      {
         return false;
      }
   }
   
   protected static boolean CreateIndex(String path, String author)
   {
      if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.INDEX + path)) //Creates file description
      {
         if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.INDEX + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.INDEX + path), FileManager.ENCODING)))
               {
                  writer.write("ARCHIVO" + FileManager.pSEPARADOR + FileManager.DIRECTORY + FileManager.INDEX + path + "\r\n");
                  writer.write("DESCRIPCION" + FileManager.pSEPARADOR + "Índice de " + path.split(Pattern.quote("."))[0] +"\r\n");
                  writer.write("TIPO" + FileManager.pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + FileManager.pSEPARADOR + "Indizado\r\n");
                  writer.write("AUTOR" + FileManager.pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + FileManager.pSEPARADOR + "|\r\n");
                  writer.write("REGISTROS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("ACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INICIAL" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("BLOQUE_ACTUAL" + FileManager.pSEPARADOR + "1");
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
   
   protected static boolean CreateMaster(String path, String author)
   {
      if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + path)) //Creates file description
      {
         if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.MASTER + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileManager.DIRECTORY + FileManager.DESCRIPTION + FileManager.MASTER + path), FileManager.ENCODING)))
               {
                  writer.write("ARCHIVO" + FileManager.pSEPARADOR + FileManager.DIRECTORY + FileManager.MASTER + path + "\r\n");
                  writer.write("DESCRIPCION" + FileManager.pSEPARADOR + path.split(Pattern.quote("."))[0] + " del sistema\r\n");
                  writer.write("TIPO" + FileManager.pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + FileManager.pSEPARADOR + "Secuencial\r\n");
                  writer.write("AUTOR" + FileManager.pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + FileManager.pSEPARADOR + "|\r\n");
                  writer.write("LLAVE" + FileManager.pSEPARADOR + FileManager.GetKeys(path) + "\r\n");
                  writer.write("ORDEN" + FileManager.pSEPARADOR + "ASC\r\n");
                  writer.write("REGISTROS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("ACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("MAXIMO" + FileManager.pSEPARADOR + "5");
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
   
   protected static String GetAllOfKey(String path, String keys, String values)
   {
      try
      {
         String data = "";
         String[] Keys = keys.split(Pattern.quote(","));
         String[] Values = values.split(Pattern.quote(","));
         int statusIndex = FileManager.GetIndexOf(path, "status");
         
         if (Keys.length != Values.length) return null;
         
         if(FileManager.FileExists(FileManager.INDEX + path))
         {
            RandomAccessFile indexDescription = FileManager.OpenFile(FileManager.DESCRIPTION + FileManager.INDEX + path);
            int first = 0;
            
            while(indexDescription.getFilePointer() != indexDescription.length())
            {
               String line = indexDescription.readLine();

               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "INICIAL":
                     first = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            indexDescription.close();
            
            if (first == 0) return null;
            RandomAccessFile indexFile = FileManager.OpenFile(FileManager.INDEX + path);
            indexFile.seek((first -1) *FileManager.Length);
            
            while(true)
            {
               String line = indexFile.readLine();
               
               String[] block = line.split(Pattern.quote(FileManager.SEPARADOR))[1].split(Pattern.quote("."));
               
               RandomAccessFile masterFile = FileManager.OpenFile(FileManager.MASTER + block[0] + "_" + path);
               masterFile.seek((Integer.parseInt(block[1])-1) * FileManager.Length);
               String register = masterFile.readLine();
               masterFile.close();
               
               boolean ok = false;
               for (int i = 0; i < Keys.length; i++)
               {
                  if (!register.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(Keys[i])].equals(Values[i])) break;
                  ok = i == Keys.length - 1;
               }
               if (ok) data += register.replace("¬", "") + FileManager.pSEPARADOR;
               if (line.split(Pattern.quote(FileManager.SEPARADOR))[3].equals("0")) break;
               indexFile.seek((Integer.parseInt(line.split(Pattern.quote(FileManager.SEPARADOR))[3]) - 1) * FileManager.Length);
            }
            indexFile.close();
         }
         
         if (data.equals("")) return null;
         return data.substring(0, data.length() - 2);
      }
      catch (IOException | NumberFormatException e)
      {
         return null;
      }
   }
}

class ArbolBinario{
   
   private static int val = 0;
   private static String vals = "";
   
   protected static boolean Write(String path, String keysString, String data)
   {
      if(!FileManager.FileExists(path))
         {
            // El archivo no existe ->
            /// Crear:
            ///   Descriptor
            ///   Índice
            CreateFile(path, data.split(Pattern.quote(FileManager.SEPARADOR))[FileManager.GetIndexOf(path, "user")]);
         }
         
         try
         {
            //Validamos que no exista otra clave igual
            String[] keys = keysString.split(Pattern.quote(","));
            
               String dataKey = "";
               for (String key : keys)
               {
                  dataKey += data.split(Pattern.quote(FileManager.SEPARADOR))[Integer.parseInt(key)];
               }
            val = -1;
            if (!Search(path, keysString, dataKey, false).equals("")) return false;

            //Clave validada
            //Abrimos el descriptor del archivo
            //para obtener el registro raiz
            RandomAccessFile descriptionFile = FileManager.OpenFile(FileManager.DESCRIPTION + path);
            int First = 0;
            int Count = 0;
            int Active = 0;
            int Inactive = 0;
            
            while(descriptionFile.getFilePointer() != descriptionFile.length())
            {
               String line = descriptionFile.readLine();
               
               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "INICIAL":
                     First = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "ACTIVOS":
                     Active = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     Inactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "REGISTROS":
                     Count = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            //se cierra el descriptor del indice.
            descriptionFile.close();
            
            RandomAccessFile masterFile = FileManager.OpenFile( FileManager.MASTER + path);
            
            if (First == 0)
            {
               masterFile.seek(Count * FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize((Count+1)+FileManager.SEPARADOR+"0"+FileManager.SEPARADOR+"0"+FileManager.SEPARADOR+"0"+FileManager.SEPARADOR+ data, FileManager.Length) +"\r\n");
               First = Count + 1;
            }
            else
            {
               int last = First;
               int next = First;
               String[] value = null;
               while (true)
               {
                  if (next == 0)
                  {
                     break;
                  }
                  else
                  {
                     masterFile.seek((next - 1) * FileManager.Length);
                     value = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));

                     String valueKey = "";
                     for (String key : keys)
                     {
                        valueKey += value[Integer.parseInt(key) + 4];
                     }

                     if (dataKey.compareTo(valueKey) <= 0)
                     {
                        //El registro va a la izquierda
                        last = next;
                        next = Integer.parseInt(value[1]);
                     }
                     else {
                        //El registro va a la derecha
                        last = next;
                        next = Integer.parseInt(value[2]);
                     }

                  }
               }

               //Ya se conoce en que parte va el registro...
               masterFile.seek(masterFile.length());
               String prefix = (Count + 1) +FileManager.SEPARADOR+ "0"+FileManager.SEPARADOR+"0"+FileManager.SEPARADOR+ last + "|";
               masterFile.writeBytes(FileManager.FixSize(prefix + data, FileManager.Length) +"\r\n");

               //Actualizamos el registro anterior...
               masterFile.seek((last == 0 ) ? 0 : (last -1) * FileManager.Length);
               value = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));

               String valueKey = "";
               for (String key : keys)
               {
                  valueKey += value[Integer.parseInt(key) + 4];
               }

               if (dataKey.compareTo(valueKey) <= 0)
               {
                  //El registro va a la izquierda
                  value[1] = (Count + 1) + "" ;
               }
               else {
                  //El registro va a la derecha
                  value[2] = (Count + 1) + "";
               }
               masterFile.seek((last == 0 ) ? 0 : (last -1) * FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, value) , FileManager.Length)+ "\r\n");
            }
            masterFile.close();
            UpdateDescription(path, First, Count +1, Active +1, -1);
            return true;
         }
         catch (IOException | NumberFormatException ex){
            return false;
         }
                 
         
   }
   
   protected static String Search(String path, String keysString, String dataKey, boolean all)
   {
      if(!FileManager.FileExists(path))
         {
            return "";
         }
         
         try
         {
            String[] keys = keysString.split(Pattern.quote(","));
            
            //Clave validada
            //Abrimos el descriptor del archivo
            //para obtener el registro raiz
            RandomAccessFile descriptionFile = FileManager.OpenFile(FileManager.DESCRIPTION + path);
            int First = 0;
            int Count = 0;
            int Active = 0;
            int Inactive = 0;
            
            while(descriptionFile.getFilePointer() != descriptionFile.length())
            {
               String line = descriptionFile.readLine();
               
               switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
               {
                  case "INICIAL":
                     First = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "ACTIVOS":
                     Active = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "INACTIVOS":
                     Inactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
                  case "REGISTROS":
                     Count = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                     break;
               }
            }
            //se cierra el descriptor del indice.
            descriptionFile.close();            
            if (First == 0) return "";
            
            RandomAccessFile masterFile = FileManager.OpenFile( FileManager.MASTER + path);
            
            String data = "";
            
            if (!all){
                val = -1;
                int line = Search(masterFile, keys, First, String.join("", dataKey.split(Pattern.quote(","))));
                if (line != -1)
                {
                   masterFile.seek((line-1) * FileManager.Length);
                   String[] x = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));
                   data = String.join(FileManager.SEPARADOR, Arrays.copyOfRange(x,4,x.length));
                }
            }
            else {
                vals = "";
                SearchAll(masterFile, keys, First, String.join("", dataKey.split(Pattern.quote(","))));
                if (!vals.equals("")) {
                    for (String key : vals.split(Pattern.quote(FileManager.pSEPARADOR))) {
                        masterFile.seek((Integer.parseInt(key)-1) * FileManager.Length);
                        String[] x = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));
                        data += String.join(FileManager.SEPARADOR, Arrays.copyOfRange(x,4,x.length))+ FileManager.pSEPARADOR;
                    }
                    data = data.substring(0, data.length() - FileManager.pSEPARADOR.length());
                }
            }
            
            masterFile.close();
            return data;
         }
         catch (IOException | NumberFormatException ex){
            return "";
         }
                 
         
   }
   
   private static int Search(RandomAccessFile masterFile, String[] keys, int next, String dataKey)
   {
      try
      {
         masterFile.seek((next - 1) * FileManager.Length);
         String[] value = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));

         String valueKey = "";
         for (String key : keys)
         {
            valueKey += value[Integer.parseInt(key) + 4];
         }
         if (valueKey.equals(dataKey))
         {
            val = next;
            return val;
         }
         else if ("0".equals(value[1]) && "0".equals(value[2]))
         {
            return -1;
         }
         else
         {
            if(Search(masterFile, keys, Integer.parseInt(value[1]), dataKey) != -1) return val;
            if(Search(masterFile, keys, Integer.parseInt(value[2]), dataKey) != -1) return val;
            return -1;
         }
      }
      catch (IOException | NumberFormatException e)
      {
         return -1;
      }
   }
   
   private static void SearchAll(RandomAccessFile masterFile, String[] keys, int next, String dataKey)
   {
      try
      {
        if (next == 0) return;
        masterFile.seek((next - 1) * FileManager.Length);
        String[] value = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));

        String valueKey = "";
        for (String key : keys)
        {
           valueKey += value[Integer.parseInt(key) + 4];
        }
        if (valueKey.equals(dataKey))
        {
           vals += next + FileManager.pSEPARADOR;
        }
        else if ("0".equals(value[1]) && "0".equals(value[2]))
        {
           return;
        }
        SearchAll(masterFile, keys, Integer.parseInt(value[1]), dataKey);
        SearchAll(masterFile, keys, Integer.parseInt(value[2]), dataKey);
      }
      catch (IOException | NumberFormatException e)
      {
         vals = "";
         return;
      }
   }
   
   protected static boolean Delete(String path, String keysString, String dataKey)
   {
      if(!FileManager.FileExists(path))
      {
         return false;
      }
      String[] dataKeys = dataKey.split(Pattern.quote("|"));
      dataKey = "";
      for (String key : keysString.split(Pattern.quote(",")))
      {
         dataKey += dataKeys[Integer.parseInt(key)];
      }
      
      try
      {
         //Validamos que no exista otra clave igual
         String[] keys = keysString.split(Pattern.quote(","));
       
         //Abrimos el descriptor del archivo
         //para obtener el registro raiz
         RandomAccessFile descriptionFile = FileManager.OpenFile(FileManager.DESCRIPTION + path);
         int First = 0;
         int Count = 0;
         int Active = 0;
         int Inactive = 0;

         while(descriptionFile.getFilePointer() != descriptionFile.length())
         {
            String line = descriptionFile.readLine();

            switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
            {
               case "INICIAL":
                  First = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                  break;
               case "ACTIVOS":
                  Active = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                  break;
               case "INACTIVOS":
                  Inactive = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                  break;
               case "REGISTROS":
                  Count = Integer.parseInt(line.split(Pattern.quote(FileManager.pSEPARADOR))[1]);
                  break;
            }
         }
         //se cierra el descriptor del indice.
         descriptionFile.close();
         
         // Abrimos el archivo y obtenemos la linea del registro a borrar
         RandomAccessFile masterFile = FileManager.OpenFile( FileManager.MASTER + path);
         val = -1;
         int next = Search(masterFile, keys, First, dataKey);
         if (next == -1) return false;
         
         //La marcamos como dada de baja
         masterFile.seek((next-1)*FileManager.Length);
         String[] values = masterFile.readLine().replace("¬", "").split(Pattern.quote(FileManager.SEPARADOR));
         values[FileManager.GetIndexOf(path, "status") + 4] = "0";
         masterFile.seek((next-1)*FileManager.Length);
         masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, values), FileManager.Length));
         
         //Necesitamos validar si el nodo era hoja, intermedio o raiz
         if(next == First)
         {
            //Es la raíz
            if (values[1].equals("0") && values[2].equals("0"))
            {
               //La raiz es nodo hoja (solo hay un registro) -> Solo se cambia First a 0
               First = 0;
            }
            else
            {
               //La raiz tiene hijos, vemos cuantos hijos hay
               if (!values[1].equals("0") && !values[2].equals("0"))
               {
                  // Tiene dos hijos
                  // Buscamos el mas grande a la izquierda
                  String son = values[1];
                  String current = values[1];

                  while (!current.equals("0"))
                  {                  
                     masterFile.seek((Integer.parseInt(current)-1)*FileManager.Length);
                     String line = masterFile.readLine();
                     son = line.split(Pattern.quote(FileManager.SEPARADOR))[0];
                     current = line.split(Pattern.quote(FileManager.SEPARADOR))[2];
                  }
                  //Ya tenemos el nodo más a la derecha (son) del nodo izquierdo del nodo borrado
                  First = Integer.parseInt(son);
                  //Movemos primero el punto del padre del nodo que se va a mover para apuntar al hijo derecho de tal nodo

                  masterFile.seek((Integer.parseInt(son)-1)*FileManager.Length);
                  String[] sonValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));

                  masterFile.seek((Integer.parseInt(sonValues[3])-1)*FileManager.Length);
                  String[] sonFatherValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                  sonFatherValues[2] = sonValues[1];

                  masterFile.seek((Integer.parseInt(sonValues[3])-1)*FileManager.Length);
                  masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonFatherValues), FileManager.Length));
                  if (!sonValues[1].equals(values[1]))
                  {
                     sonValues[1] = values[1];
                  }
                  sonValues[2] = values[2];
                  sonValues[3] = values[3];

                  masterFile.seek((Integer.parseInt(son)-1)*FileManager.Length);
                  masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonValues), FileManager.Length));
                  
                  //Cambiamos la referencia del padre de los hijos
                  if(!sonValues[1].equals("0"))
                  {
                     masterFile.seek((Integer.parseInt(sonValues[1])-1)*FileManager.Length);
                     String[] sonsValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                     sonsValues[3] = son;
                     masterFile.seek((Integer.parseInt(sonValues[1])-1)*FileManager.Length);
                     masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonsValues), FileManager.Length));
                  }
                  if(!sonValues[2].equals("0"))
                  {
                     masterFile.seek((Integer.parseInt(sonValues[2])-1)*FileManager.Length);
                     String[] sonsValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                     sonsValues[3] = son;
                     masterFile.seek((Integer.parseInt(sonValues[2])-1)*FileManager.Length);
                     masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonsValues), FileManager.Length));
                  }
               }
               else //Solo existe un hijo, se quita la referencia al padre y se cambia First
               {
                  int son = !values[1].equals("0") ?  1 : 2;
                  First = Integer.parseInt(values[son]);
                  masterFile.seek(son * FileManager.Length);
                  String[] sonValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                  sonValues[3] = "0";
                  masterFile.seek(son * FileManager.Length);
                  masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonValues), FileManager.Length));
                  
               }
            }
         }
         else if (values[1].equals("0") && values[2].equals("0"))
         {
            //Es nodo hoja -> Solo se elimina la referencia del padre al hijo
            masterFile.seek((Integer.parseInt(values[3])-1)*FileManager.Length);
            String[] fatherValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
            int son = fatherValues[1].equals(values[0]) ? 1 : 2;
            fatherValues[son] = "0";
            masterFile.seek((Integer.parseInt(values[3])-1)*FileManager.Length);
            masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, fatherValues), FileManager.Length));
         }
         else
         {
            //Es un nodo intermedio.. vemos cuantos hijos hay
            if (!values[1].equals("0") && !values[2].equals("0"))
            {
               // Tiene dos hijos
               // Buscamos el mas grande a la izquierda
               String son = values[1];
               String current = values[1];
               
               while (!current.equals("0"))
               {                  
                  masterFile.seek((Integer.parseInt(current)-1)*FileManager.Length);
                  String line = masterFile.readLine();
                  son = line.split(Pattern.quote(FileManager.SEPARADOR))[0];
                  current = line.split(Pattern.quote(FileManager.SEPARADOR))[2];
               }
               //Ya tenemos el nodo más a la derecha (son) del nodo izquierdo del nodo borrado
               
               //Movemos primero el puntero del padre del nodo que se va a mover para apuntar al hijo derecho de tal nodo
               
               masterFile.seek((Integer.parseInt(son)-1)*FileManager.Length);
               String[] sonValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
               
               masterFile.seek((Integer.parseInt(sonValues[3])-1)*FileManager.Length);
               String[] sonFatherValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
               sonFatherValues[2] = sonValues[1];
               
               masterFile.seek((Integer.parseInt(sonValues[3])-1)*FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonFatherValues), FileManager.Length));
               if (!sonValues[1].equals(values[1]))
               {
                  sonValues[1] = values[1];
               }
               sonValues[2] = values[2];
               sonValues[3] = values[3];
               
               masterFile.seek((Integer.parseInt(son)-1)*FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonValues), FileManager.Length));
               
               //actualizamos el padre del nodo eliminado para que apunte al nodo que se movio
               masterFile.seek((Integer.parseInt(values[3])-1)*FileManager.Length);
               String[] fatherValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
               fatherValues[fatherValues[1].equals(values[0]) ? 1 : 0] = sonValues[0];
               masterFile.seek((Integer.parseInt(values[3])-1)*FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, fatherValues), FileManager.Length));

               
               //Cambiamos la referencia del padre de los hijos
               if(!sonValues[1].equals("0"))
               {
                  masterFile.seek((Integer.parseInt(sonValues[1])-1)*FileManager.Length);
                  String[] sonsValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                  sonsValues[3] = son;
                  masterFile.seek((Integer.parseInt(sonValues[1])-1)*FileManager.Length);
                  masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonsValues), FileManager.Length));
               }
               if(!sonValues[2].equals("0"))
               {
                  masterFile.seek((Integer.parseInt(sonValues[2])-1)*FileManager.Length);
                  String[] sonsValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
                  sonsValues[3] = son;
                  masterFile.seek((Integer.parseInt(sonValues[2])-1)*FileManager.Length);
                  masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonsValues), FileManager.Length));
               }
               
            }
            else //Solo existe un hijo, el padre pasa a apuntar al hijo del nodo borrado
            {
               int son = !values[1].equals("0") ?  1 : 2;
               
               masterFile.seek((Integer.parseInt(values[3])-1)*FileManager.Length);
               String[] fatherValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
               fatherValues[fatherValues[1].equals(values[0]) ? 1 : 2] = values[son];
               masterFile.seek((Integer.parseInt(values[3])-1)*FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, fatherValues), FileManager.Length));
               
               //Actualizamos el padre del hijo
               masterFile.seek((Integer.parseInt(values[son]) -1)* FileManager.Length);
               String[] sonsValues = masterFile.readLine().split(Pattern.quote(FileManager.SEPARADOR));
               sonsValues[3] = fatherValues[0];
               masterFile.seek((Integer.parseInt(values[son])-1)*FileManager.Length);
               masterFile.writeBytes(FileManager.FixSize(String.join(FileManager.SEPARADOR, sonsValues), FileManager.Length));
            }
         }
         masterFile.close();
         UpdateDescription(path, First, Count, Active -1, Inactive + 1);
         return true;
      }
      catch (IOException | NumberFormatException ex)
      {
         return false;
      }
   }
   
   protected static boolean CreateFile(String path, String author)
   {
      if (FileManager.CreateFile(FileManager.DIRECTORY + FileManager.DESCRIPTION + path)) //Creates file description
      {
         if (FileManager.CreateFile(FileManager.DIRECTORY + path)) // Creates file itself.
         {
            try
            {

               try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileManager.DIRECTORY + FileManager.DESCRIPTION + path), FileManager.ENCODING)))
               {
                  writer.write("ARCHIVO" + FileManager.pSEPARADOR + FileManager.DIRECTORY + path + "\r\n");
                  writer.write("DESCRIPCION" + FileManager.pSEPARADOR + "Índice de " + path.split(Pattern.quote("."))[0] +"\r\n");
                  writer.write("TIPO" + FileManager.pSEPARADOR + "ARCHIVO DE DATOS\r\n");
                  writer.write("ORGANIZACION" + FileManager.pSEPARADOR + "Indizado\r\n");
                  writer.write("AUTOR" + FileManager.pSEPARADOR + author  +"\r\n");
                  writer.write("CREADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("MODIFICADO" + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date()) + "\r\n");
                  writer.write("SEPARADOR" + FileManager.pSEPARADOR + "|\r\n");
                  writer.write("REGISTROS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("ACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INACTIVOS" + FileManager.pSEPARADOR + "0\r\n");
                  writer.write("INICIAL" + FileManager.pSEPARADOR + "0");
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
   
   protected static boolean UpdateDescription(String path, int first, int count, int active, int inactive) // needs complete file name: binnacle_example.txt or master_example.txt to get the right desc_xxx_example.txt file
   {
      try
      {
         FileManager.CreateFile(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + path);
         RandomAccessFile fileDescription = FileManager.OpenFile(FileManager.DESCRIPTION + path);
         RandomAccessFile fileTempDescription = FileManager.OpenFile(FileManager.TEMP + FileManager.DESCRIPTION  + path);
         
         while(fileDescription.getFilePointer() != fileDescription.length())
         {
            String line = fileDescription.readLine();            
            switch (line.split(Pattern.quote(FileManager.pSEPARADOR))[0])
            {
               case "MODIFICADO":
                  line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + new SimpleDateFormat("yyyyMMdd'.'hh:mm").format(new Date());
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "INICIAL":
                  if (first >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + first;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "ACTIVOS":
                  if (active >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + active;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "INACTIVOS":
                  if (inactive >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + inactive;
                  }
                  fileTempDescription.writeBytes(line + "\r\n");
                  break;
               case "REGISTROS":
                  if (count >= 0)
                  {
                     line = line.split(Pattern.quote(FileManager.pSEPARADOR))[0] + FileManager.pSEPARADOR + count;
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
         File oldDescription = new File(FileManager.DIRECTORY + FileManager.DESCRIPTION  + path);
         oldDescription.delete();
         File newDescription = new File(FileManager.DIRECTORY + FileManager.TEMP + FileManager.DESCRIPTION + path);
         newDescription.renameTo(new File(FileManager.DIRECTORY + FileManager.DESCRIPTION + path));
         return true;
      }
      catch (IOException e)
      {
         return false;
      }
   }
}