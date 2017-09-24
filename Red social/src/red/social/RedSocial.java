/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import java.io.*;

public class RedSocial {

    //const
    public static final String DIRECTORY = "C:\\MEIA"; 
    public static final String USER_FILE = "Usuario.txt";
    public static final String ENCODING = "utf-8";
    public static void main(String[] args) {
       try
      {
         File directory = new File(DIRECTORY); 
         if(!directory.exists())
         {
           directory.getAbsoluteFile().mkdirs();
         }
         LoginController();
      }
      catch(Exception e)
      {
         System.out.println(e.getMessage());
      }
    }
    
    public static void LoginController(){
        Login log = new Login();
        log.setVisible(true);
    }
    
    public static void RegisterController(){
        Registrarse Register = new Registrarse();
        Register.setVisible(true);
    }
    
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
   
   public static BufferedWriter WriteFile(String path)
   {
      try
      {
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), ENCODING));
         return writer;
      }
      catch (FileNotFoundException | UnsupportedEncodingException e)
      {
         return null;
      }
   }
   
   public static boolean CreateFile(String path)
   {
      try
      {
         File directory = new File(path); 
         if(!directory.getAbsoluteFile().exists())
         {
            return directory.createNewFile();
         }
         return false;
      }
      catch(IOException e)
      {
         return false;
      }
   }
    
}
