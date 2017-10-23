/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import static red.social.FileManager.FRIENDS_FILE;
import static red.social.FileManager.GROUPS_FILE;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.pSEPARADOR;
import static red.social.FileManager.BINNACLE;
import static red.social.FileManager.GROUPS_FRIENDS_FILE;
import static red.social.FileManager.GroupLength;
import static red.social.RedSocial.Fill;
import red.social.Icons.ListIcon;
import red.social.Icons.Renderer;


/**
 *
 * @author Krle__000
 */
public class FriendsGroups extends javax.swing.JFrame
{

   /**
    * Creates new form FriendsGroups
    */
   public static int groupFieldLength = 30;
   public static int DescriptionLength = 60;
   public Profile myProfile;
   public String myUser;
   DefaultListModel friendList = new DefaultListModel();
   DefaultListModel groupList = new DefaultListModel();
   Renderer renderer = new Renderer();
   public FriendsGroups()
   {
      initComponents();
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
      InvisibleComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      jPanel1 = new javax.swing.JPanel();
      btn_Cancel = new javax.swing.JButton();
      jLabel2 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      list_Friends = new javax.swing.JList<>();
      jLabel1 = new javax.swing.JLabel();
      txt_GroupName = new javax.swing.JTextField();
      jScrollPane2 = new javax.swing.JScrollPane();
      list_Members = new javax.swing.JList<>();
      jLabel3 = new javax.swing.JLabel();
      btn_CreateGroup = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jScrollPane3 = new javax.swing.JScrollPane();
      txt_Description = new javax.swing.JTextArea();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      jLabel9 = new javax.swing.JLabel();
      lbl_NameError = new javax.swing.JLabel();
      lbl_DescriptionError = new javax.swing.JLabel();
      jLabel10 = new javax.swing.JLabel();
      lbl_MembersNumber = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
      setUndecorated(true);

      jPanel1.setBackground(new java.awt.Color(71, 79, 89));
      jPanel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

      btn_Cancel.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
      btn_Cancel.setText("Cancelar");
      btn_Cancel.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btn_CancelActionPerformed(evt);
         }
      });

      jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(255, 255, 255));
      jLabel2.setText("         Mis amigos");

      list_Friends.setBackground(new java.awt.Color(253, 211, 92));
      list_Friends.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
      list_Friends.setForeground(new java.awt.Color(186, 100, 56));
      list_Friends.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            list_FriendsMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(list_Friends);

      jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(255, 255, 255));
      jLabel1.setText("Nombre del grupo");

      txt_GroupName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
      txt_GroupName.addKeyListener(new java.awt.event.KeyAdapter()
      {
         public void keyTyped(java.awt.event.KeyEvent evt)
         {
            txt_GroupNameKeyTyped(evt);
         }
      });

      list_Members.setBackground(new java.awt.Color(55, 160, 166));
      list_Members.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
      list_Members.setForeground(new java.awt.Color(255, 255, 255));
      list_Members.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            list_MembersMouseClicked(evt);
         }
      });
      jScrollPane2.setViewportView(list_Members);

      jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(255, 255, 255));
      jLabel3.setText("Integrantes");

      btn_CreateGroup.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
      btn_CreateGroup.setText("Crear Grupo");
      btn_CreateGroup.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btn_CreateGroupActionPerformed(evt);
         }
      });

      jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(255, 255, 255));
      jLabel4.setText("Descripción");

      txt_Description.setColumns(20);
      txt_Description.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
      txt_Description.setRows(5);
      txt_Description.addKeyListener(new java.awt.event.KeyAdapter()
      {
         public void keyTyped(java.awt.event.KeyEvent evt)
         {
            txt_DescriptionKeyTyped(evt);
         }
      });
      jScrollPane3.setViewportView(txt_Description);

      jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
      jLabel5.setForeground(new java.awt.Color(234, 104, 0));
      jLabel5.setText("¡Crea un nuevo grupo y sigue compartiendo en Lynx!");

      jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printRight.png"))); // NOI18N

      jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printLeft.png"))); // NOI18N

      jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printLeft.png"))); // NOI18N

      jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printRight.png"))); // NOI18N

      lbl_NameError.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
      lbl_NameError.setForeground(new java.awt.Color(255, 51, 51));
      lbl_NameError.setText("Ya existe");

      lbl_DescriptionError.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
      lbl_DescriptionError.setForeground(new java.awt.Color(255, 51, 51));
      lbl_DescriptionError.setText("Agregue una descripción");

      jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel10.setForeground(new java.awt.Color(255, 255, 255));
      jLabel10.setText("Miembros:");

      lbl_MembersNumber.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      lbl_MembersNumber.setForeground(new java.awt.Color(255, 255, 255));
      lbl_MembersNumber.setText("0");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5)
            .addGap(63, 63, 63))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel10)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(lbl_MembersNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jScrollPane2)
                           .addComponent(jLabel3)
                           .addComponent(jLabel4)
                           .addComponent(jScrollPane3)
                           .addComponent(txt_GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(lbl_NameError)
                           .addComponent(lbl_DescriptionError))))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                 .addComponent(jLabel9)
                                 .addGap(1, 1, 1))
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                 .addComponent(jLabel6)
                                 .addComponent(jLabel8)
                                 .addComponent(jLabel7)))
                           .addGap(27, 27, 27))
                        .addComponent(btn_CreateGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(24, 24, 24)
                  .addComponent(jLabel5)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CreateGroup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Cancel))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(jLabel3))
                           .addComponent(lbl_DescriptionError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addContainerGap(52, Short.MAX_VALUE)
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(txt_GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(lbl_NameError)))
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel10)
               .addComponent(lbl_MembersNumber))
            .addGap(25, 25, 25))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_CancelActionPerformed
   {//GEN-HEADEREND:event_btn_CancelActionPerformed
      // TODO add your handling code here:
      myProfile.setVisible(true);
      this.dispose();
   }//GEN-LAST:event_btn_CancelActionPerformed

   private void list_FriendsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_list_FriendsMouseClicked
   {//GEN-HEADEREND:event_list_FriendsMouseClicked
      // TODO add your handling code here:
        int index = list_Friends.locationToIndex(evt.getPoint());
        if(index!=-1){
           groupList.addElement(friendList.getElementAt(index));
           friendList.remove(index);
           list_Members.setCellRenderer(renderer);
           list_Members.setModel(groupList);
           list_Friends.setModel(friendList);
           lbl_MembersNumber.setText(groupList.getSize()+"");
        }
   }//GEN-LAST:event_list_FriendsMouseClicked

   private void list_MembersMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_list_MembersMouseClicked
   {//GEN-HEADEREND:event_list_MembersMouseClicked
      // TODO add your handling code here:
       int index = list_Members.locationToIndex(evt.getPoint());
        if(index!=-1){
           friendList.addElement(groupList.elementAt(index));
           groupList.remove(index);
           list_Members.setModel(groupList);
           list_Friends.setCellRenderer(renderer);
           list_Friends.setModel(friendList);
           lbl_MembersNumber.setText(groupList.getSize()+"");
        }
   }//GEN-LAST:event_list_MembersMouseClicked

   private void txt_GroupNameKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_GroupNameKeyTyped
   {//GEN-HEADEREND:event_txt_GroupNameKeyTyped
      // TODO add your handling code here:
       if(txt_GroupName.getText().length()>= groupFieldLength){
            evt.consume();
        }
   }//GEN-LAST:event_txt_GroupNameKeyTyped

   private void txt_DescriptionKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_DescriptionKeyTyped
   {//GEN-HEADEREND:event_txt_DescriptionKeyTyped
      // TODO add your handling code here:
      if(txt_Description.getText().length()>= DescriptionLength){
            evt.consume();
        }
   }//GEN-LAST:event_txt_DescriptionKeyTyped

   private void btn_CreateGroupActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_CreateGroupActionPerformed
   {//GEN-HEADEREND:event_btn_CreateGroupActionPerformed
      // TODO add your handling code here:
      InvisibleComponents();
      if(IsValid()){
         FileManager.WriteFile(GROUPS_FILE, Fill(ThisGroup(), GroupLength));
         myProfile.setVisible(true);
         myProfile.ShowGroups();
         AddFriendsToGroup();
         this.dispose();
      }
   }//GEN-LAST:event_btn_CreateGroupActionPerformed

   public void ShowFriends(){
      ImageIcon icon;
      
      try{
         String[] allMyFriends = FileManager.GetFriendsOfUser(myUser).split(Pattern.quote(pSEPARADOR));
         String[] friend;
         for (int i = 0; i < allMyFriends.length; i++)
         {
            list_Friends.setCellRenderer(renderer);
            list_Friends.setModel(friendList);
            friend = FileManager.SearchUser(allMyFriends[i].split(Pattern.quote(SEPARADOR))[1]).split(Pattern.quote(SEPARADOR));
            icon = new ImageIcon((new ImageIcon(friend[8])).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
            friendList.addElement(new ListIcon(friend[0], icon));
         }
      }catch(Exception e){

      }
   }
   
   private void InvisibleComponents(){
       lbl_DescriptionError.setVisible(false);
       lbl_NameError.setVisible(false);
    }
   
   private String ThisGroup(){
      return myUser+SEPARADOR+txt_GroupName.getText()+SEPARADOR+txt_Description.getText()+SEPARADOR+lbl_MembersNumber.getText()+SEPARADOR+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+SEPARADOR+"1";
   }
   
   private void AddFriendsToGroup(){
      for (int i = 0; i < groupList.size(); i++)
      {
         String name = ((ListIcon)groupList.elementAt(i)).name;
         FileManager.WriteFile(GROUPS_FRIENDS_FILE, CreateAsociationToGroup(((ListIcon)groupList.elementAt(i)).name));
      }
   }
   
   private String CreateAsociationToGroup(String friend){
      return myUser+SEPARADOR+txt_GroupName.getText()+SEPARADOR+friend+SEPARADOR+"1";
   }
   private boolean IsValid(){
      
      //Revisar este método
      if(FileManager.SearchGroup(myUser, txt_GroupName.getText())!=null){
         lbl_NameError.setVisible(true);
         return false;
      }
      if(txt_GroupName.getText().isEmpty()){
         lbl_NameError.setText("Ingrese un nombre");
         lbl_NameError.setVisible(true);
         return false;
      }
      
      if(txt_Description.getText().isEmpty()){
        lbl_DescriptionError.setVisible(true);
         return false; 
      }
      return true;
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
         java.util.logging.Logger.getLogger(FriendsGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(FriendsGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(FriendsGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(FriendsGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new FriendsGroups().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btn_Cancel;
   private javax.swing.JButton btn_CreateGroup;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JLabel lbl_DescriptionError;
   private javax.swing.JLabel lbl_MembersNumber;
   private javax.swing.JLabel lbl_NameError;
   private javax.swing.JList<String> list_Friends;
   private javax.swing.JList<String> list_Members;
   private javax.swing.JTextArea txt_Description;
   private javax.swing.JTextField txt_GroupName;
   // End of variables declaration//GEN-END:variables
}
