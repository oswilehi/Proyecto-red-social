/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RedSocial {

    
    public static final String DIRECTORY = "C:\\MEIA"; //const
    public static final String USER_FILE = "Usuario.txt";
    /*
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
      
        LoginController();
         try{
             File MEIA = new File(DIRECTORY); 
            if(!MEIA.exists()){
                MEIA.mkdir();
            }
         }catch(Exception e){
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
    
   public static File LoadOrCreateFile(String Path){
     //PrintWriter writer = new PrintWriter(Path,"UTF-8");   
   }
    
}
