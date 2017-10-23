/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import java.io.*;
import java.security.MessageDigest;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import static red.social.FileManager.FRIENDS_FILE;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.pSEPARADOR;
import red.social.Icons.ListIcon;
import red.social.Icons.Renderer;

public class RedSocial {

    //CONSTANTES
    public static String ACTUALUSER;
    
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
        actualUser = RedSocial.Fill(actualUser, FileManager.UserLength);
        FileManager.Update(FileManager.USER_FILE,actualUser);
    }
    
     public static void showFriends(Renderer renderer, DefaultListModel friendList, JList jl_friendList, String user){
                
        ImageIcon icon;
        String pathIcon;
        jl_friendList.setModel(friendList);
        // Busco en dos variables porque yo puedo estar como Usuario o usuario_amigo
        String myFriends = FileManager.SearchByKey(FRIENDS_FILE, "0,2,5", user+",1,1");
        String myFriends2 = FileManager.SearchByKey(FRIENDS_FILE, "1,2,5", user+",1,1");
        String realFriends = "";
        
        if (myFriends==null && myFriends2==null)
            friendList.addElement("No hay amigos para mostrar");  
        else{
            if (myFriends!=null && myFriends2!=null)
                realFriends = myFriends + "::" + myFriends2;
            if (myFriends!=null || myFriends2!=null){
                if (myFriends!=null)
                    realFriends = myFriends;
                else
                    realFriends = myFriends2;                     
            }
        
            jl_friendList.setCellRenderer(renderer);
            String realFriendsArray[] = realFriends.split(Pattern.quote(pSEPARADOR));
            for (int i = 0; i < realFriendsArray.length; i++) {
                String friendShip[] = realFriendsArray[i].split(Pattern.quote(SEPARADOR));
                String individualUser[] = FileManager.SearchUser(friendShip[1]).split(Pattern.quote(SEPARADOR));
                pathIcon = individualUser[8];
                icon = new ImageIcon((new ImageIcon(pathIcon)).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
                friendList.addElement(new ListIcon(individualUser[1]+" "+individualUser[2]+" "+individualUser[0], icon));
            }
        }    
    }
}
