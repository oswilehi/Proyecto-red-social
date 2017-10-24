/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.social;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import static red.social.FileManager.BINNACLE;
import static red.social.FileManager.GROUPS_FILE;
import static red.social.FileManager.GROUPS_FRIENDS_FILE;
import static red.social.FileManager.SEPARADOR;
import static red.social.FileManager.pSEPARADOR;
import static red.social.FileManager.GroupLength;
import static red.social.FileManager.SEPARADOR;
import static red.social.FriendsGroups.DescriptionLength;
import static red.social.FriendsGroups.groupFieldLength;
import static red.social.RedSocial.Fill;
import red.social.Icons.ListIcon;
import red.social.Icons.Renderer;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author Krle__000
 */
public class SeeGroupsAdministrator extends javax.swing.JFrame
{
   public String thisGroup;
   public String myUser;
   public Profile myProfile;
   DefaultListModel friendList = new DefaultListModel();
   DefaultListModel groupList = new DefaultListModel();
   Renderer renderer = new Renderer();
   /**
    * Creates new form SeeGroups
    */
   public SeeGroupsAdministrator()
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
      jPanel2 = new javax.swing.JPanel();
      jLabel5 = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      txt_GroupName = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();
      jScrollPane3 = new javax.swing.JScrollPane();
      txt_Description = new javax.swing.JTextArea();
      jLabel3 = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      list_Members = new javax.swing.JList<>();
      jLabel2 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      list_Friends = new javax.swing.JList<>();
      lbl_SaveChanges = new javax.swing.JLabel();
      btn_Return = new javax.swing.JButton();
      lbl_DeleteGroup = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      jLabel9 = new javax.swing.JLabel();
      jLabel10 = new javax.swing.JLabel();
      jLabel11 = new javax.swing.JLabel();
      lbl_NameError = new javax.swing.JLabel();
      lbl_DescriptionError = new javax.swing.JLabel();
      jLabel13 = new javax.swing.JLabel();
      lbl_MembersNumber = new javax.swing.JLabel();

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 100, Short.MAX_VALUE)
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 100, Short.MAX_VALUE)
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
      setUndecorated(true);

      jPanel2.setBackground(new java.awt.Color(71, 79, 89));

      jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
      jLabel5.setForeground(new java.awt.Color(234, 104, 0));
      jLabel5.setText("Grupos Lynx");

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

      jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(255, 255, 255));
      jLabel3.setText("Integrantes");

      list_Members.setBackground(new java.awt.Color(55, 160, 166));
      list_Members.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
      list_Members.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            list_MembersMouseClicked(evt);
         }
      });
      jScrollPane2.setViewportView(list_Members);

      jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(255, 255, 255));
      jLabel2.setText(" Agregar más integrantes");

      list_Friends.setBackground(new java.awt.Color(253, 211, 92));
      list_Friends.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
      list_Friends.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            list_FriendsMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(list_Friends);

      lbl_SaveChanges.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
      lbl_SaveChanges.setForeground(new java.awt.Color(255, 255, 255));
      lbl_SaveChanges.setText("Guardar cambios");
      lbl_SaveChanges.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            lbl_SaveChangesMouseClicked(evt);
         }
      });

      btn_Return.setText("Regresar");
      btn_Return.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            btn_ReturnActionPerformed(evt);
         }
      });

      lbl_DeleteGroup.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
      lbl_DeleteGroup.setForeground(new java.awt.Color(255, 255, 255));
      lbl_DeleteGroup.setText("Eliminar grupo");
      lbl_DeleteGroup.addMouseListener(new java.awt.event.MouseAdapter()
      {
         public void mouseClicked(java.awt.event.MouseEvent evt)
         {
            lbl_DeleteGroupMouseClicked(evt);
         }
      });

      jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printLeft.png"))); // NOI18N

      jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printRight.png"))); // NOI18N

      jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printLeft.png"))); // NOI18N

      jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red/social/Icons/printRight.png"))); // NOI18N

      lbl_NameError.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
      lbl_NameError.setForeground(new java.awt.Color(255, 51, 51));
      lbl_NameError.setText("Ya existe");

      lbl_DescriptionError.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
      lbl_DescriptionError.setForeground(new java.awt.Color(255, 51, 51));
      lbl_DescriptionError.setText("Agregue una descripción");

      jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      jLabel13.setForeground(new java.awt.Color(255, 255, 255));
      jLabel13.setText("Miembros:");

      lbl_MembersNumber.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
      lbl_MembersNumber.setForeground(new java.awt.Color(255, 255, 255));
      lbl_MembersNumber.setText("0");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(txt_GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addGap(18, 18, 18)
                  .addComponent(lbl_NameError))
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel3)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel13)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(lbl_MembersNumber))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jLabel4)
                  .addGap(18, 18, 18)
                  .addComponent(lbl_DescriptionError))
               .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(8, 8, 8))
               .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lbl_SaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                     .addComponent(jLabel11)
                     .addGap(1, 1, 1))
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel9)
                     .addComponent(jLabel10)
                     .addComponent(jLabel8)))))
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lbl_DeleteGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Return, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(22, 22, 22))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(lbl_SaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(16, 16, 16)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                     .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel1)
                           .addComponent(lbl_NameError))
                        .addGap(18, 18, 18)
                        .addComponent(txt_GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(jLabel4)
                           .addComponent(lbl_DescriptionError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(jLabel3)
                           .addComponent(lbl_MembersNumber)
                           .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addComponent(jLabel8)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabel9)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel10)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel11)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btn_Return)
               .addComponent(lbl_DeleteGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btn_ReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btn_ReturnActionPerformed
   {//GEN-HEADEREND:event_btn_ReturnActionPerformed
      // TODO add your handling code here:
      myProfile.setVisible(true);
      this.dispose();
   }//GEN-LAST:event_btn_ReturnActionPerformed

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

   private void lbl_SaveChangesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbl_SaveChangesMouseClicked
   {//GEN-HEADEREND:event_lbl_SaveChangesMouseClicked
      // TODO add your handling code here:
      InvisibleComponents();
      if(IsValid()){
         ReplaceFriendsofGroup();
         if(txt_GroupName.getText().equals(thisGroup)){
            //Overwrite
            FileManager.Update(GROUPS_FILE, Fill(NewGroup(), GroupLength) ); 
         }else{
            //Delete logicaly and add new gruop
            FileManager.WriteFile(GROUPS_FILE, Fill(NewGroup(), GroupLength));
            FileManager.Update(GROUPS_FILE, Fill(OldGroupForDelete(), GroupLength));
         }
         myProfile.ShowGroups();
         myProfile.setVisible(true);
         this.dispose();
      }
   }//GEN-LAST:event_lbl_SaveChangesMouseClicked

   private void lbl_DeleteGroupMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lbl_DeleteGroupMouseClicked
   {//GEN-HEADEREND:event_lbl_DeleteGroupMouseClicked
      // TODO add your handling code here:
      DesasociateMembersToGroup(thisGroup);
      FileManager.Update(GROUPS_FILE, OldGroupForDelete());
      myProfile.ShowGroups();
         myProfile.setVisible(true);
         this.dispose();
   }//GEN-LAST:event_lbl_DeleteGroupMouseClicked

   private void DesasociateMembersToGroup(String GroupName){
      String[] members = FileManager.SearchByKey(GROUPS_FRIENDS_FILE, "1", GroupName).split(Pattern.quote(pSEPARADOR));
      for (int i = 0; i < members.length; i++)
      {
          String ChangeStatus = members[i].substring(0, members[i].length()-1) +"0";
         FileManager.Update(GROUPS_FRIENDS_FILE, ChangeStatus);
      }
   }
   
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
   
   private String NewGroup(){
      String[] old = FileManager.SearchGroup(myUser, thisGroup).split(Pattern.quote(SEPARADOR));
      return myUser+SEPARADOR+txt_GroupName.getText()+SEPARADOR+txt_Description.getText()+SEPARADOR+lbl_MembersNumber.getText()+SEPARADOR+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+SEPARADOR+"1";
   }
   
   private String OldGroupForDelete(){
      String[] old = FileManager.SearchGroup(myUser, thisGroup).split(Pattern.quote(SEPARADOR));
      return old[0]+SEPARADOR+old[1]+SEPARADOR+old[2]+SEPARADOR+old[3]+SEPARADOR+old[4]+SEPARADOR+"0";
   }

   private void ReplaceFriendsofGroup(){
      try{
         String[] oldMembers = FileManager.SearchByKey(GROUPS_FRIENDS_FILE, "0,1", myUser+","+thisGroup).split(Pattern.quote(pSEPARADOR));
         for (int i = 0; i < oldMembers.length; i++)
         {
            FileManager.Update(GROUPS_FRIENDS_FILE, oldMembers[i].substring(0, oldMembers[i].length()-1)+"0");
         }
         
         for (int i = 0; i < groupList.size(); i++)
         {
            CreateAsociationToGroup(((ListIcon)groupList.elementAt(i)).name);
            FileManager.WriteFile(GROUPS_FRIENDS_FILE, CreateAsociationToGroup(((ListIcon)groupList.elementAt(i)).name));
         }
      }catch(Exception e){
         
      }
   }
   
   private String CreateAsociationToGroup(String friend){
      return myUser+SEPARADOR+txt_GroupName.getText()+SEPARADOR+friend+SEPARADOR+new SimpleDateFormat("dd/MM/yyyy").format(new Date())+SEPARADOR+"1";
   }
   
  
   public void FillComponents(String user, String group, Profile form){
      thisGroup = group;
      myUser = user;
      myProfile = form;
      
      txt_GroupName.setText(thisGroup);
      txt_Description.setText(FileManager.SearchGroup(myUser, thisGroup).split(Pattern.quote(SEPARADOR))[2]);
      lbl_MembersNumber.setText(FileManager.SearchGroup(myUser, thisGroup).split(Pattern.quote(SEPARADOR))[3]);
      ShowMembers();
      //inicializar miembros....
         try{
            ImageIcon icon;
            String[] allMyFriends = FileManager.GetFriendsOfUser(myUser).split(Pattern.quote(pSEPARADOR));
            String[] friend;
            for (int i = 0; i < allMyFriends.length; i++)
            {
               list_Friends.setCellRenderer(renderer);
               list_Friends.setModel(friendList);
               friend = FileManager.SearchUser(allMyFriends[i].split(Pattern.quote(SEPARADOR))[1]).split(Pattern.quote(SEPARADOR));
               icon = new ImageIcon((new ImageIcon(friend[8])).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
            
               //revisar esta condición-------------------------------------------
               if(!isInGroupList(friend[0])){
                  friendList.addElement(new ListIcon(friend[0], icon));
               }
            }
         }catch(Exception e){
            
         }
   }
   
   public boolean isInGroupList(String name){
      for (int i = 0; i < groupList.size(); i++)
      {
         if(((ListIcon)groupList.getElementAt(i)).name.equals(name)){
            return true;
         };
      }
      return false;
   }
    private void ShowMembers(){
       groupList.clear();
       try{
          String[] members = FileManager.SearchByKey(GROUPS_FRIENDS_FILE, "0,1", myUser+","+thisGroup).split(Pattern.quote(pSEPARADOR));
          String[] friend;
          ImageIcon icon;
         for (int i = 0; i < members.length; i++)
         {
            list_Members.setCellRenderer(renderer);
            list_Members.setModel(groupList);
            friend = FileManager.SearchUser(members[i].split(Pattern.quote(SEPARADOR))[2]).split(Pattern.quote(SEPARADOR));
            icon = new ImageIcon((new ImageIcon(friend[8])).getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
            groupList.addElement(new ListIcon(friend[0], icon));
         }
       }catch(Exception e){
          
       }
    }
    
   private void InvisibleComponents(){
      lbl_DescriptionError.setVisible(false);
      lbl_NameError.setVisible(false);
   }
   private boolean IsValid(){
      
      //Revisar este método
      if(!txt_GroupName.getText().equals(thisGroup) && FileManager.SearchGroup(myUser, txt_GroupName.getText())!=null){
         lbl_NameError.setText("Ya existe");
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
         java.util.logging.Logger.getLogger(SeeGroupsAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(SeeGroupsAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(SeeGroupsAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(SeeGroupsAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new SeeGroupsAdministrator().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btn_Return;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel11;
   private javax.swing.JLabel jLabel13;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JLabel lbl_DeleteGroup;
   private javax.swing.JLabel lbl_DescriptionError;
   private javax.swing.JLabel lbl_MembersNumber;
   private javax.swing.JLabel lbl_NameError;
   private javax.swing.JLabel lbl_SaveChanges;
   private javax.swing.JList<String> list_Friends;
   private javax.swing.JList<String> list_Members;
   private javax.swing.JTextArea txt_Description;
   private javax.swing.JTextField txt_GroupName;
   // End of variables declaration//GEN-END:variables
}
