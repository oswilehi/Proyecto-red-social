/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import java.io.*;
import java.security.MessageDigest;
import java.util.regex.Pattern;

public class RedSocial {

    //const
    public static final String DIRECTORY = "C:" + File.separator + "MEIA" + File.separator; 
    public static final String USER_FILE = "Usuario.txt";
    public static final String BINNACLE = "bitacora_";
    public static final String MASTER = "";
    public static final String TEMP = "data.temp";
    public static final String DESCRIPTION ="Desc_";
    public static final String IMAGES = "fotografia";
    public static final String ENCODING = "utf-8";
    public static final String SEPARADOR = "|";
    public static final String pSEPARADOR = "::";
    public static final int Length = 260;
    public static String ACTUALUSER;
    
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
    
    public static void ProfileController(String userData){
        Profile profile = new Profile();
        profile.ShowInfo(userData);
        profile.setVisible(true);  
    }
    
    
    public static void SettingsAdminController(){
        SettingsAdmin settings = new SettingsAdmin();
        settings.setVisible(true);
    }
    
    public static void SettingsNotAdminController(){
        SettingsNotAdmin settings = new SettingsNotAdmin();
        settings.setVisible(true);
    }
    public static void RegisterController(){
        Registrarse Register = new Registrarse();
        Register.setVisible(true);
    }
    
    // Este metodo es para cuando el usuario necesite el registrar para agregar usuarios
    public static void RegisterController(boolean AdminIsAddingUsers){
        Registrarse Register = new Registrarse(AdminIsAddingUsers);
        Register.setVisible(true);
    }
    
    public static String MD5(String Password) throws Exception{
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] b = md.digest(Password.getBytes());

      int size = b.length;
      StringBuffer h = new StringBuffer(size);
      for (int i = 0; i < size; i++) {
      int u = b[i] & 255;
      if (u < 16) {
      h.append("0" + Integer.toHexString(u));
      } else {
      h.append(Integer.toHexString(u));
      }
      }
      return h.toString();
    }
    
    public static String Fill(String Text){
       Text+="|";
       for(int i=Text.length(); i<Length; i++){
          Text+="¬";
       }
       int n = Text.length();
       return Text;
    }
    
    // Cambia el status de 1 a 0
    public static void Delete(String userToDelete){
        String actualUser = FileManager.Search(userToDelete);
        String actualUserArray[] = actualUser.split(Pattern.quote(SEPARADOR));
        actualUser = actualUserArray[0]+ SEPARADOR
                     + actualUserArray[1]+ SEPARADOR
                     + actualUserArray[2]+ SEPARADOR
                     + actualUserArray[3]+ SEPARADOR
                     + actualUserArray[4]+ SEPARADOR
                     + actualUserArray[5]+ SEPARADOR
                     + actualUserArray[6]+ SEPARADOR
                     + actualUserArray[7]+ SEPARADOR
                     + actualUserArray[8]+ SEPARADOR
                     + actualUserArray[9]+ SEPARADOR
                     + "0";
        actualUser = RedSocial.Fill(actualUser);
        FileManager.Update(actualUser);
    }
}
