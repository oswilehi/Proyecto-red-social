/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import java.io.*;

public class RedSocial {

    //const
    public static final String DIRECTORY = "C:" + File.separator + "MEIA" + File.separator; 
    public static final String USER_FILE = "Usuario.txt";
    public static final String BINNACLE = "bitacora_";
    public static final String MASTER = "";
    public static final String DESCRIPTION ="Desc_";
    public static final String ENCODING = "utf-8";
    public static final String SEPARADOR = "|";
    public static final String pSEPARADOR = "::";
    
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
    
}
