/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import java.io.*;
import java.security.MessageDigest;

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
}
