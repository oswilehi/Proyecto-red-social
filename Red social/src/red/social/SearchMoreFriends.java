/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import static red.social.FileManager.FRIENDS_FILE;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.USER_FILE;
import static red.social.FileManager.pSEPARADOR;
import red.social.Icons.Renderer;
import red.social.Icons.ListIcon;
import static red.social.RedSocial.ACTUALUSER;

/**
 *
 * @author Krle__000
 */
public class SearchMoreFriends extends javax.swing.JFrame
{

   /**
    * Creates new form SearchMoreFriends
    */
   DefaultListModel friendList = new DefaultListModel();
   Renderer renderer = new Renderer();
   Profile myProfile;
   public SearchMoreFriends()
   {
      initComponents();
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_lastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_friendList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        btn_searchFriend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 160, 166));

        btn_Cancel.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        btn_Cancel.setText("Cancelar");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/lynx2Pequeño.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 74, 117));
        jLabel2.setText("¡Encuentra más amigos y aumenta la diversión!");

        tf_name.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido");

        tf_lastName.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Resultados de búsqueda");

        jl_friendList.setBackground(new java.awt.Color(253, 211, 92));
        jl_friendList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_friendListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jl_friendList);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario");

        tf_user.setBackground(new java.awt.Color(204, 204, 255));

        btn_searchFriend.setText("Buscar");
        btn_searchFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchFriendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(43, 193, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_lastName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_user, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                                .addComponent(btn_searchFriend)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_searchFriend)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(142, 142, 142)
                        .addComponent(btn_Cancel)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_CancelActionPerformed
   {//GEN-HEADEREND:event_btn_CancelActionPerformed
      // TODO add your handling code here:
      myProfile.setVisible(true);
      this.dispose();
   }//GEN-LAST:event_btn_CancelActionPerformed

    private void btn_searchFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchFriendActionPerformed
        // TODO add your handling code here:
        ImageIcon icon;
        String pathIcon;
        jl_friendList.setModel(friendList);

        // Busqueda por nombre y apellido
        if (!tf_name.getText().trim().isEmpty() && !tf_lastName.getText().trim().isEmpty() && tf_user.getText().trim().isEmpty()){
           String foundUsers = FileManager.SearchByKey(USER_FILE, "1,2", tf_name.getText()+","+tf_lastName.getText());
            if (foundUsers != null){
                jl_friendList.setCellRenderer(renderer);
                String foundUsersArray[] = foundUsers.split(Pattern.quote(pSEPARADOR));
                for (int i = 0; i < foundUsersArray.length; i++){
                    String individualUser[] = foundUsersArray[i].split(Pattern.quote(SEPARADOR));
                    pathIcon = individualUser[8];
                    icon = new ImageIcon((new ImageIcon(pathIcon)).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
                    friendList.addElement(new ListIcon(individualUser[1]+" "+individualUser[2]+" "+individualUser[0], icon));
                }
                
            }
            else
                friendList.addElement("Sin resultados de búsqueda.");
        }
        // Busqueda por nombre o apellido
        else if (!tf_name.getText().trim().isEmpty() || !tf_lastName.getText().trim().isEmpty()){
            String foundUser;
            if (tf_name.getText().trim().isEmpty())
                foundUser = FileManager.SearchByKey(USER_FILE, "2", tf_lastName.getText());           
            else
                foundUser = FileManager.SearchByKey(USER_FILE, "1", tf_name.getText());           
            
            if (foundUser != null){
                jl_friendList.setCellRenderer(renderer);
                String foundUsersArray[] = foundUser.split(Pattern.quote(pSEPARADOR));
                for (int i = 0; i < foundUsersArray.length; i++){
                    String individualUser[] = foundUsersArray[i].split(Pattern.quote(SEPARADOR));
                    pathIcon = individualUser[8];
                    icon = new ImageIcon((new ImageIcon(pathIcon)).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
                    friendList.addElement(new ListIcon(individualUser[1]+" "+individualUser[2]+" "+individualUser[0], icon));
                }              
            }
            else
                friendList.addElement("Sin resultados de búsqueda.");            
        }
        
        // Busqueda por usuario
        else if (!tf_user.getText().trim().isEmpty()){
            String foundUser = FileManager.SearchUser(tf_user.getText());
            if (foundUser != null){
                jl_friendList.setCellRenderer(renderer);
                String foundUserArray[] = foundUser.split(Pattern.quote(SEPARADOR));
                pathIcon = foundUserArray[8];
                icon = new ImageIcon((new ImageIcon(pathIcon)).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
                friendList.addElement(new ListIcon(foundUserArray[1]+" "+foundUserArray[2]+" "+foundUserArray[0], icon));
            }
            else
                friendList.addElement("Sin resultados de búsqueda.");
        }
    }//GEN-LAST:event_btn_searchFriendActionPerformed

    private void jl_friendListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_friendListMouseClicked
        // TODO add your handling code here:
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
             this.setVisible(false);
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
                    this.setVisible(false);
                }
                // Si ya se ha enviado una solicitud y no ha sido aceptada y el que va a ingresar al perfil fue el que la recibio
                // Se le presenta la posibilidad de poder aceptar o declinar la solicitud
                else{
                    SeeFriendProfile seeFriendProfile = new SeeFriendProfile(userOfFriend, 2);
                    seeFriendProfile.setVisible(true);
                    this.setVisible(false);
                }
            }
            // si ambos son nulos quiere decir que no ha habido ninguna solicitud enviada anteriormente por lo que se le permitira
            // enviar una.
            else{
                SeeFriendProfile seeFriendProfile = new SeeFriendProfile(userOfFriend, 1);
                seeFriendProfile.setVisible(true);
                this.setVisible(false);
            }
            
            
           
        }
           
        
    }//GEN-LAST:event_jl_friendListMouseClicked

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
         java.util.logging.Logger.getLogger(SearchMoreFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(SearchMoreFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(SearchMoreFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(SearchMoreFriends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new SearchMoreFriends().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_searchFriend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jl_friendList;
    private javax.swing.JTextField tf_lastName;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}
