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
import static red.social.FileManager.FriendLength;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.pSEPARADOR;
import red.social.Icons.ListIcon;
import red.social.Icons.Renderer;

// AÑADIDO PARA LA DB
import java.io.PrintWriter;
import java.sql.*;
import static red.social.FileManager.MESSAGE_FILE;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.pSEPARADOR;

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
         //Singleton.getInstancia().conexion();
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
        deleteFriends(userToDelete);
    }
    
    // Cancela las amistades de un usuario que se ha dado de baja
    private static void deleteFriends(String user){
        int friendToSearch;
        // Busco en dos variables porque yo puedo estar como Usuario o usuario_amigo
        String myFriends = FileManager.SearchByKey(FRIENDS_FILE, "0,2,5", user+",1,1");
        String myFriends2 = FileManager.SearchByKey(FRIENDS_FILE, "1,2,5", user+",1,1");
        String realFriends = "";
       
        if (myFriends!=null && myFriends2!=null)
            realFriends = myFriends + "::" + myFriends2;
        else if (myFriends!=null || myFriends2!=null){
            if (myFriends!=null)
                realFriends = myFriends;
                    
            else
                realFriends = myFriends2;                     
        }
        
        String realFriendsArray[] = realFriends.split(Pattern.quote(pSEPARADOR));
        for (int i = 0; i < realFriendsArray.length; i++) {
            String friendShip[] = realFriendsArray[i].split(Pattern.quote(SEPARADOR));
            FileManager.Update(FRIENDS_FILE, RedSocial.Fill(friendShip[0]+SEPARADOR+friendShip[1]+SEPARADOR+friendShip[2]+SEPARADOR+friendShip[3]+SEPARADOR+friendShip[4]+SEPARADOR+"0",FriendLength));            
        }      
    }
    
     public static void showFriends(Renderer renderer, DefaultListModel friendList, JList jl_friendList, String user){
               
        int friendToSearch; 
        ImageIcon icon;
        String pathIcon;
        jl_friendList.setModel(friendList);
        // Busco en dos variables porque yo puedo estar como Usuario o usuario_amigo
        String myFriends = FileManager.SearchByKey(FRIENDS_FILE, "0,2,5", user+",1,1");
        String myFriends2 = FileManager.SearchByKey(FRIENDS_FILE, "1,2,5", user+",1,1");
        String realFriends = "";
        jl_friendList.setCellRenderer(renderer);
        if (myFriends==null && myFriends2==null)
            friendList.addElement(new ListIcon("No hay amigos para mostrar",null));  
            
        else{
            if (myFriends!=null && myFriends2!=null)
                realFriends = myFriends + "::" + myFriends2;
            else if (myFriends!=null || myFriends2!=null){
                if (myFriends!=null)
                    realFriends = myFriends;
                    
                else
                    realFriends = myFriends2;                     
            }
        
            //jl_friendList.setCellRenderer(renderer);
            String realFriendsArray[] = realFriends.split(Pattern.quote(pSEPARADOR));
            for (int i = 0; i < realFriendsArray.length; i++) {
                String friendShip[] = realFriendsArray[i].split(Pattern.quote(SEPARADOR));
                if (user.equals(friendShip[0]))
                    friendToSearch = 1;
                else
                    friendToSearch = 0;
                String individualUser[] = FileManager.SearchUser(friendShip[friendToSearch]).split(Pattern.quote(SEPARADOR));
                pathIcon = individualUser[8];
                icon = new ImageIcon((new ImageIcon(pathIcon)).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
                friendList.addElement(new ListIcon(individualUser[1]+" "+individualUser[2]+" "+individualUser[0], icon));
            }
        }    
    }
     
    public static void goToFriendProfile(JFrame actualFrame, JList jl_friendList, DefaultListModel friendList){
        
        String userToCompare;
        ListIcon friend = (ListIcon)friendList.getElementAt(jl_friendList.getSelectedIndex());
        String userOfFriend = friend.name.split(" ")[2];
        String statusOfFriendship = FileManager.SearchByKey(FRIENDS_FILE, "0,1,2,5", userOfFriend + "," + ACTUALUSER + "," + "1" + "," + "1");
        String statusOfFriendship2 = FileManager.SearchByKey(FRIENDS_FILE, "0,1,2,5", ACTUALUSER + "," + userOfFriend + "," + "1" + "," + "1");
        // Si ya se ha enviado una solicitud y ha sido aceptada
        // Se le presenta la posibilidad de poder deshacer la amistad
        if (statusOfFriendship != null || statusOfFriendship2 != null){
             SeeFriendProfile seeFriendProfile = new SeeFriendProfile(userOfFriend, 3);
             seeFriendProfile.setVisible(true);
             actualFrame.setVisible(false);
        }
        else{
            statusOfFriendship = FileManager.SearchByKey(FRIENDS_FILE, "0,1,2,5", userOfFriend + "," + ACTUALUSER + "," + "0" + "," + "1");
            statusOfFriendship2 = FileManager.SearchByKey(FRIENDS_FILE, "0,1,2,5", ACTUALUSER + "," + userOfFriend + "," + "0" + "," + "1");
            if (statusOfFriendship != null || statusOfFriendship2 != null){
                if (statusOfFriendship == null)
                    userToCompare = statusOfFriendship2;
                else
                    userToCompare = statusOfFriendship;
                
                 // Si ya se ha enviado una solicitud y no ha sido aceptada y el que va a ingresar al perfil fue el que la envio
                 // Se le presenta la posibilidad de poder deshacer la solicitud
                if (ACTUALUSER.equals(userToCompare.split(Pattern.quote(SEPARADOR))[4])){
                    SeeFriendProfile seeFriendProfile = new SeeFriendProfile(userOfFriend, 1);
                    seeFriendProfile.setVisible(true);
                    actualFrame.setVisible(false);
                }
                // Si ya se ha enviado una solicitud y no ha sido aceptada y el que va a ingresar al perfil fue el que la recibio
                // Se le presenta la posibilidad de poder aceptar o declinar la solicitud
                else{
                    SeeFriendProfile seeFriendProfile = new SeeFriendProfile(userOfFriend, 2);
                    seeFriendProfile.setVisible(true);
                    actualFrame.setVisible(false);
                }
            }
            // si ambos son nulos quiere decir que no ha habido ninguna solicitud enviada anteriormente por lo que se le permitira
            // enviar una.
            else{
                SeeFriendProfile seeFriendProfile = new SeeFriendProfile(userOfFriend, 1);
                seeFriendProfile.setVisible(true);
                actualFrame.setVisible(false);
            }        
        }
        
    }
    
    public static void showMessages(DefaultListModel messagesList, JList jl_messagesList, String userToSearch, Boolean privateMessage, Boolean publicMessage){
        
        jl_messagesList.setModel(messagesList);
       
        // Si quiero mensajes publicos y privados
        if (privateMessage && publicMessage){
               addPublicMessagesToList(messagesList, userToSearch);
               addPrivateMessagesToList(messagesList, userToSearch);              
        }
        // Alguno de los dos, publicos o privados
        else if(privateMessage || publicMessage){
            //Solo agregar privados
            if (privateMessage)
                addPrivateMessagesToList(messagesList, userToSearch);
            //Solo agregar privados
            else
                addPublicMessagesToList(messagesList, userToSearch);   
        }
   }
   
   public static void addPublicMessagesToList(DefaultListModel messagesList, String userToSearch){
       String publicMessages = FileManager.SearchByKey(MESSAGE_FILE, "1,4", userToSearch+",0"); 
       if (publicMessages != null){
            // Obtener los registros
            String publicMessages2[] = publicMessages.split(Pattern.quote(pSEPARADOR));
            // Agregar mensaje a la lista
            for (int i = 0; i < publicMessages2.length; i++){
                String messageReceived[] = publicMessages2[i].split(Pattern.quote(SEPARADOR));                
                messagesList.addElement(messageReceived[0] + ":" + messageReceived[3] + "  Enviado:" + messageReceived[2]);
            } 
       } 
   }
   
   public static void addPrivateMessagesToList(DefaultListModel messagesList, String userToSearch){
       String privateMessages = FileManager.SearchByKey(MESSAGE_FILE, "1,4", userToSearch+",1");         
       if (privateMessages != null){
           // Obtener los registros
           String privateMessages2[] = privateMessages.split(Pattern.quote(pSEPARADOR));
            // Agregar mensaje a la lista
            for (int i = 0; i < privateMessages2.length; i++){
                String messageReceived[] = privateMessages2[i].split(Pattern.quote(SEPARADOR));                
                messagesList.addElement(messageReceived[0] + ": " + messageReceived[3] + "  Enviado:" + messageReceived[2]);
            }  
       }       
   }
}
