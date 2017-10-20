/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import java.io.*;
import java.security.MessageDigest;
import java.util.regex.Pattern;
import java.awt.Color;

public class RedSocial {

    //CONSTANTES
    public static String ACTUALUSER;
    
    //colors for decoration.
    //public static Color Background = new Color(242,132,35);
    public static Color Background = new Color(55,160,166);
    
    
    
    public static void main(String[] args) {
       try
      {
         File directory = new File(FileManager.DIRECTORY); 
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
        //log.setLocationRelativeTo(null);
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
    
    public static  Register RegisterController(){
        Register register = new Register();
        register.setVisible(true);
        return register;
    }
    
    // Este metodo es para cuando el usuario necesite el registrar para agregar usuarios
    public static  Register RegisterController(boolean AdminIsAddingUsers){
        Register register = new Register();
        register.setVisible(true);
        return register;
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
    
    public static String Fill(String Text, int LengthToFill){
       Text+="|";
       for(int i=Text.length(); i<LengthToFill; i++){
          Text+="¬";
       }
       return Text;
    }
    
    // Cambia el status de 1 a 0
    public static void Delete(String userToDelete){
        String actualUser = FileManager.SearchUser(userToDelete);
        String actualUserArray[] = actualUser.split(Pattern.quote(FileManager.SEPARADOR));
        actualUser = actualUserArray[0]+ FileManager.SEPARADOR
                     + actualUserArray[1]+ FileManager.SEPARADOR
                     + actualUserArray[2]+ FileManager.SEPARADOR
                     + actualUserArray[3]+ FileManager.SEPARADOR
                     + actualUserArray[4]+ FileManager.SEPARADOR
                     + actualUserArray[5]+ FileManager.SEPARADOR
                     + actualUserArray[6]+ FileManager.SEPARADOR
                     + actualUserArray[7]+ FileManager.SEPARADOR
                     + actualUserArray[8]+ FileManager.SEPARADOR
                     + actualUserArray[9]+ FileManager.SEPARADOR
                     + "0";
        actualUser = RedSocial.Fill(actualUser, FileManager.Length);
        FileManager.Update(FileManager.USER_FILE,actualUser);
    }
}
