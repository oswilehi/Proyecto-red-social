/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import static red.social.FileManager.FRIENDS_FILE;
import static red.social.FileManager.FriendLength;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.pSEPARADOR;
import static red.social.FileManager.GROUPS_FRIENDS_FILE;
import red.social.Icons.ListIcon;
import red.social.Icons.Renderer;
import static red.social.RedSocial.ACTUALUSER;

/**
 *
 * @author Krle__000
 */
public class SeeFriendProfile extends javax.swing.JFrame
{

   /**
    * Creates new form SeeFriendProfile
    */
   String friendToShow; 
   boolean requestWasSend;
   // Si typeOfForm es 1 significa que se viene a enviar una solicitud, si es 2 significa que se viene a aceptar una solicitud y si es 3
   /// significa que ya son amigos y puede eliminar al amigo
   int typeOfForm;
   DefaultListModel friendList = new DefaultListModel();
   Renderer renderer = new Renderer();
   static Profile myProfile;
   public SeeFriendProfile(String friendToShow, int typeOfForm)
   {
      initComponents();
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
      this.friendToShow = friendToShow;
      this.typeOfForm = typeOfForm;
      String request = FileManager.SearchFriend(ACTUALUSER, friendToShow);
      requestWasSend = request != null;
      showProfile();
      //Show friends
      RedSocial.showFriends(renderer, friendList, jl_friendList, friendToShow);   
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmi_cancelRequest = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txt_userInfo = new javax.swing.JTextField();
        txt_rolInfo = new javax.swing.JTextField();
        lbl_descripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_descripcionInfo = new javax.swing.JTextArea();
        lbl_sendRequest = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_profilePic = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_friendList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_Return = new javax.swing.JButton();
        lbl_acceptRequest = new javax.swing.JLabel();

        jmi_cancelRequest.setText("Cancelar Solicitud");
        jmi_cancelRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_cancelRequestActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmi_cancelRequest);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 160, 166));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        txt_userInfo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        txt_rolInfo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        lbl_descripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_descripcion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_descripcion.setText("Descripción");

        txt_descripcionInfo.setColumns(20);
        txt_descripcionInfo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txt_descripcionInfo.setRows(5);
        jScrollPane2.setViewportView(txt_descripcionInfo);

        lbl_sendRequest.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        lbl_sendRequest.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sendRequest.setText("Enviar solicitud de amistad");
        lbl_sendRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_sendRequestMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_sendRequestMouseReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(234, 104, 0));

        lbl_profilePic.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_profilePic, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_profilePic, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        jl_friendList.setBackground(new java.awt.Color(253, 211, 92));
        jl_friendList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_friendListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jl_friendList);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("         Sus amigos");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printRight.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printLeft.png"))); // NOI18N

        btn_Return.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btn_Return.setText("Regresar");
        btn_Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReturnActionPerformed(evt);
            }
        });

        lbl_acceptRequest.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        lbl_acceptRequest.setForeground(new java.awt.Color(255, 255, 255));
        lbl_acceptRequest.setToolTipText("");
        lbl_acceptRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_acceptRequestMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rolInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_userInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_descripcion))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 515, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Return, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_acceptRequest)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_sendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_acceptRequest))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btn_Return))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_userInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_rolInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_descripcion)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void lbl_sendRequestMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbl_sendRequestMouseClicked
   {//GEN-HEADEREND:event_lbl_sendRequestMouseClicked

       if (evt.getModifiers() == MouseEvent.BUTTON1_MASK){
           // Se debe verificar si ya se habia enviado una solicitud a ese amigo.      
       // Si no se ha enviado una solicitud, se envia la linea y se cambia el label
       if (typeOfForm == 1){
           if (!requestWasSend && evt.getModifiers() == MouseEvent.BUTTON1_MASK){
               requestWasSend = true;
               lbl_sendRequest.setText("Solicitud enviada");
               DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
               Date date = new Date(); 
               String dataOfRequest = ACTUALUSER + SEPARADOR + friendToShow + SEPARADOR + "0" + SEPARADOR + dateFormat.format(date) + SEPARADOR + ACTUALUSER + "|" + "1";
               FileManager.WriteFile(FRIENDS_FILE, RedSocial.Fill(dataOfRequest, FriendLength));
           }
       }
       else if (typeOfForm == 2){
           String requestDate = FileManager.SearchFriend(ACTUALUSER, friendToShow).split(Pattern.quote(SEPARADOR)) [3];
           String dataOfRequest = ACTUALUSER + SEPARADOR + friendToShow + SEPARADOR + "0" + SEPARADOR + requestDate + SEPARADOR + ACTUALUSER + "|" + "0";
           FileManager.Update(FRIENDS_FILE, RedSocial.Fill(dataOfRequest, FriendLength));
       }
       else if (typeOfForm == 3){
           TurnOffItsGroups(ACTUALUSER, friendToShow);
           updateInfo("0","0");
           typeOfForm = 1;
           requestWasSend = false;
           showProfile();         
       } 
       }         
   }//GEN-LAST:event_lbl_sendRequestMouseClicked


   
    private void btn_ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReturnActionPerformed
        // TODO add your handling code here:
        myProfile.setVisible(true);
        //myProfile.showFriends();
        this.dispose();
    }//GEN-LAST:event_btn_ReturnActionPerformed

    private void lbl_sendRequestMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sendRequestMouseReleased
        // TODO add your handling code here:
        
        if (evt.getModifiers() == MouseEvent.BUTTON3_MASK){
            if (typeOfForm == 1){
            String request = FileManager.SearchFriend(ACTUALUSER, friendToShow);
            requestWasSend = request != null;
            if (requestWasSend){
                if (evt.isPopupTrigger()){
                        jPopupMenu1.show(lbl_sendRequest,evt.getX(),evt.getY());
                }
            }
        }
        }      
    }//GEN-LAST:event_lbl_sendRequestMouseReleased

    private void jmi_cancelRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_cancelRequestActionPerformed
        // TODO add your handling code here:
        updateInfo("0", "0");
        typeOfForm = 1;
        requestWasSend = false;
        //showFriends();
        showProfile(); 
    }//GEN-LAST:event_jmi_cancelRequestActionPerformed

    private void lbl_acceptRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_acceptRequestMouseClicked
        // TODO add your handling code here:
        updateInfo("1","1");
        typeOfForm = 3;
        showProfile();  
        //showFriends();
    }//GEN-LAST:event_lbl_acceptRequestMouseClicked

    private void jl_friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_friendListMouseClicked
        // TODO add your handling code here:
        ListIcon friend = (ListIcon)friendList.getElementAt(jl_friendList.getSelectedIndex());
        if (!friend.name.split(" ")[2].equals(ACTUALUSER))
            RedSocial.goToFriendProfile(this, jl_friendList, friendList); 
        else{
            myProfile.setVisible(true);
            this.dispose();
        }        
    }//GEN-LAST:event_jl_friendListMouseClicked

   private void updateInfo(String accepted, String status){
      
        String requestDate;
        String requester;
        String receiver; 
        if (FileManager.SearchFriend(ACTUALUSER,friendToShow) != null){
            requestDate = FileManager.SearchFriend(ACTUALUSER,friendToShow).split(Pattern.quote(SEPARADOR)) [3];
            requester = FileManager.SearchFriend(ACTUALUSER,friendToShow).split(Pattern.quote(SEPARADOR)) [0];
            receiver = FileManager.SearchFriend(ACTUALUSER,friendToShow).split(Pattern.quote(SEPARADOR)) [1];
        }
        else {
            requestDate = FileManager.SearchFriend(friendToShow, ACTUALUSER).split(Pattern.quote(SEPARADOR)) [3];
            requester = FileManager.SearchFriend(friendToShow, ACTUALUSER).split(Pattern.quote(SEPARADOR)) [0];
            receiver = FileManager.SearchFriend(friendToShow, ACTUALUSER).split(Pattern.quote(SEPARADOR)) [1];
        }
        
        String dataOfRequest = requester + SEPARADOR + receiver + SEPARADOR + accepted + SEPARADOR + requestDate + SEPARADOR + requester + SEPARADOR + status;
        FileManager.Update(FRIENDS_FILE, RedSocial.Fill(dataOfRequest, FriendLength));
   }
    
   private void showProfile(){
       
       if (typeOfForm == 1){
           if (requestWasSend)
               lbl_sendRequest.setText("Solicitud enviada");
           else
               lbl_sendRequest.setText("Enviar solicitud de amistad"); 
           lbl_acceptRequest.setVisible(false);

       }
       
       else if (typeOfForm == 2){
            lbl_acceptRequest.setVisible(true);
            lbl_acceptRequest.setText("Aceptar");
            lbl_sendRequest.setText("Denegar");
       }
                
       
       else if (typeOfForm == 3){
           lbl_sendRequest.setText("Eliminar amigo");
           lbl_acceptRequest.setVisible(false);
       }
        String userProfileInfo[] = FileManager.SearchUser(friendToShow).split(Pattern.quote(SEPARADOR));
        txt_userInfo.setText(userProfileInfo[0]);
        lbl_profilePic.setIcon(new ImageIcon((new ImageIcon(userProfileInfo[8])).getImage().getScaledInstance(165, 137,  java.awt.Image.SCALE_SMOOTH)));
        if (userProfileInfo[4].equals("1"))
            txt_rolInfo.setText("Administrador");
        else
            txt_rolInfo.setText("No Administrador");
        txt_descripcionInfo.setText(userProfileInfo[9]);
        
       
   }
   

   public void TurnOffItsGroups(String friendA, String friendB){
      try{
         String[] groupsOfA = FileManager.SearchByKey(GROUPS_FRIENDS_FILE, "0,2", friendA+","+friendB).split(Pattern.quote(pSEPARADOR));
         for (int i = 0; i < groupsOfA.length; i++)
         {
            FileManager.Update(GROUPS_FRIENDS_FILE, groupsOfA[i].substring(0,groupsOfA[i].length()-1)+"0");
         }
      }catch(Exception e){
         
      }
      
      try{
         String[] groupsOfB = FileManager.SearchByKey(GROUPS_FRIENDS_FILE, "0,2", friendA+","+friendB).split(Pattern.quote(pSEPARADOR));
         for (int i = 0; i < groupsOfB.length; i++)
         {
            FileManager.Update(GROUPS_FRIENDS_FILE, groupsOfB[i].substring(0,groupsOfB[i].length()-1)+"0");
         }
      }catch(Exception e){
         
      }
      
      

   public void showFriends(){
       friendList.clear();
       RedSocial.showFriends(renderer, friendList, jl_friendList, friendToShow);

   }
   /**
    * @param args the command line arguments
    */
   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      }
      catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(SeeFriendProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(SeeFriendProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(SeeFriendProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(SeeFriendProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      /*java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new SeeFriendProfile().setVisible(true);
         }
      });*/
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jl_friendList;
    private javax.swing.JMenuItem jmi_cancelRequest;
    private javax.swing.JLabel lbl_acceptRequest;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_profilePic;
    private javax.swing.JLabel lbl_sendRequest;
    private javax.swing.JTextArea txt_descripcionInfo;
    private javax.swing.JTextField txt_rolInfo;
    private javax.swing.JTextField txt_userInfo;
    // End of variables declaration//GEN-END:variables
}
