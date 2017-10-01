package red.social;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.regex.Pattern;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static red.social.RedSocial.IMAGES;
import static red.social.RedSocial.DIRECTORY;
import static red.social.RedSocial.USER_FILE;
import static red.social.RedSocial.BINNACLE;



public class Registrarse extends javax.swing.JFrame {
int UserLength = 10;
int NameLength = 10;
int LastNameLength = 20;
int PasswordLength = 20;
int EmailLength = 50;
int PhoneNumberLength = 8;
int DescriptionLength = 100;
int PictureCount = 0;
boolean isAdminAddingUsers;


String PicturePath="";
    
    public Registrarse() {
        initComponents();
        InvisibleComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        btn_regresar.setVisible(false);
    }
    public Registrarse(boolean AdminIsAddingUsers) {
        initComponents();
        InvisibleComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        jButton1.setText("Agregar");
        btn_regresar.setVisible(true);
        isAdminAddingUsers = AdminIsAddingUsers;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_User = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_LastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        txt_CheckPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_PhoneNumber = new javax.swing.JTextField();
        txt_Mail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbl_PicturePath = new javax.swing.JLabel();
        btn_FindPicture = new javax.swing.JButton();
        lbl_Level = new javax.swing.JLabel();
        lbl_UserError = new javax.swing.JLabel();
        lbl_NameError = new javax.swing.JLabel();
        lbl_LastNameError = new javax.swing.JLabel();
        lbl_PasswordCheckedError = new javax.swing.JLabel();
        lbl_MailError = new javax.swing.JLabel();
        lbl_NumberPhoneError = new javax.swing.JLabel();
        lbl_PictureError = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Sp_Birthday = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Description = new javax.swing.JTextArea();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Usuario");

        txt_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_UserKeyTyped(evt);
            }
        });

        jLabel2.setText("Apellido");

        txt_LastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_LastNameKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre");

        txt_Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NameKeyTyped(evt);
            }
        });

        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyTyped(evt);
            }
        });

        txt_CheckPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CheckPasswordKeyTyped(evt);
            }
        });

        jLabel4.setText("Confirmar contraseña");

        jLabel5.setText("Contraseña");

        jLabel6.setText("Teléfono");

        txt_PhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PhoneNumberKeyTyped(evt);
            }
        });

        txt_Mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MailKeyTyped(evt);
            }
        });

        jLabel7.setText("Correo");

        jButton1.setText("Registrarse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Seleccionar foto");

        lbl_PicturePath.setBackground(new java.awt.Color(255, 255, 255));
        lbl_PicturePath.setText("Foto");

        btn_FindPicture.setText("Buscar");
        btn_FindPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FindPictureActionPerformed(evt);
            }
        });

        lbl_Level.setForeground(new java.awt.Color(204, 0, 0));
        lbl_Level.setText("jLabel9");

        lbl_UserError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_UserError.setText("El usuario ya existe");

        lbl_NameError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_NameError.setText("Es necesario un nombre");

        lbl_LastNameError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_LastNameError.setText("Es necesario un apellido");

        lbl_PasswordCheckedError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_PasswordCheckedError.setText("Inválida");

        lbl_MailError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_MailError.setText("Es necesario un correo");

        lbl_NumberPhoneError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_NumberPhoneError.setText("Es necesario un teléfono correcto");

        lbl_PictureError.setForeground(new java.awt.Color(204, 0, 0));
        lbl_PictureError.setText("Es necesaria una imagen de perfil");

        jLabel9.setText("Fecha de nacimiento");

        Sp_Birthday.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1199234280000L), new java.util.Date(-315526920000L), new java.util.Date(1199236080000L), java.util.Calendar.DAY_OF_WEEK_IN_MONTH));

        jLabel10.setText("Descripción");

        txt_Description.setColumns(20);
        txt_Description.setRows(5);
        txt_Description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_DescriptionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_Description);

        btn_regresar.setText("Regresar");
        btn_regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_regresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_User, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(txt_Name)
                                    .addComponent(txt_LastName)
                                    .addComponent(txt_Password)
                                    .addComponent(txt_Mail)
                                    .addComponent(txt_CheckPassword)
                                    .addComponent(txt_PhoneNumber)
                                    .addComponent(Sp_Birthday))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Level, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_UserError)
                                            .addComponent(lbl_NameError)
                                            .addComponent(lbl_LastNameError)
                                            .addComponent(lbl_PasswordCheckedError)
                                            .addComponent(lbl_MailError)
                                            .addComponent(lbl_NumberPhoneError))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(29, 29, 29)
                                        .addComponent(btn_FindPicture)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_PictureError))
                                    .addComponent(lbl_PicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_regresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 116, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_UserError))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_NameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_LastNameError))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_Level))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_CheckPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_PasswordCheckedError))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_MailError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_NumberPhoneError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Sp_Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btn_FindPicture)
                    .addComponent(lbl_PictureError))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_PicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       InvisibleComponents();
       if(IsDataValid()){
             String Data = CreateUser();
             
             // No escribe en el archivo hasta que el usuario sea nuevo 
            while (FileManager.Search(txt_User.getText()) != null) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, pruebe con otro");
                
            }
            
            FileManager.WriteFile(USER_FILE, RedSocial.Fill(Data));
            
                
            // Si un administrador no esta agregando usuarios esto quiere decir
            // que es un registrar normal
            if (!isAdminAddingUsers)
            {
                 RedSocial.ProfileController(Data);
                 RedSocial.ACTUALUSER = txt_User.getText();
                 this.setVisible(false);
                 this.dispose();
            }
            // Si es un admin agregando usuarios se limpian los txt
            else
                CleanTxt();       
        }
    }   
    
    private void CleanTxt()
    {
        txt_User.setText("");
        txt_Password.setText("");
        txt_CheckPassword.setText("");
        txt_Name.setText("");
        txt_LastName.setText("");
        txt_Mail.setText("");
        txt_PhoneNumber.setText("");
        txt_Description.setText("");
        lbl_PicturePath.setText("");
    }

    private void txt_UserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserKeyTyped
        // TODO add your handling code here:
        if(txt_User.getText().length()>= UserLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_UserKeyTyped

    private void txt_NameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NameKeyTyped
        // TODO add your handling code here:
         if(txt_Name.getText().length()>= NameLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_NameKeyTyped

    private void txt_PasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyTyped
        // TODO add your handling code here:
         if(txt_Password.getText().length()>= PasswordLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_PasswordKeyTyped

    private void txt_CheckPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CheckPasswordKeyTyped
        // TODO add your handling code here:
         if(txt_CheckPassword.getText().length()>= PasswordLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_CheckPasswordKeyTyped

    private void txt_MailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MailKeyTyped
        // TODO add your handling code here:
        if(txt_Mail.getText().length()>= EmailLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_MailKeyTyped

    private void txt_PhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PhoneNumberKeyTyped
        // TODO add your handling code here:
        if(txt_PhoneNumber.getText().length()>= PhoneNumberLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_PhoneNumberKeyTyped

    private void btn_FindPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FindPictureActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser Images = new JFileChooser();
            Images.setFileFilter(new FileNameExtensionFilter("Image Files", "gif","jpg","jpeg","png"));
            Images.setAcceptAllFileFilterUsed(false);
            Images.showOpenDialog(Images);
                String Path = Images.getSelectedFile().getAbsolutePath();
                String Name = Path.split(Pattern.quote("\\"))[Path.split(Pattern.quote("\\")).length-1];
                ImageExistInMEIA(Name); //It returns a booleean about If exist a image with the same name
                CopyImagesToMEIA(Path, DIRECTORY+IMAGES+"\\"+Name);
                lbl_PicturePath.setText("");
                lbl_PicturePath.setIcon(new ImageIcon((new ImageIcon(PicturePath)).getImage().getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH)));
       
        }catch(Exception e){
        }
    }//GEN-LAST:event_btn_FindPictureActionPerformed

    private void txt_PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyReleased
        // TODO add your handling code here:
        if(txt_Password.getText().isEmpty()){
            lbl_Level.setVisible(false);
            
        }
        
        if(txt_Password.getText().length()>0 && txt_Password.getText().length()<6){
            lbl_Level.setForeground(Color.ORANGE);
            lbl_Level.setText("Tiene que ser mayor de 6 caracteres");
            lbl_Level.setVisible(true);
        }else{
           // txt_Password.setEnabled(false);
            int puntuation=0;
            int Letters = Letters(txt_Password.getText());
            int Numbers = Numbers(txt_Password.getText());
            
            if(txt_Password.getText().length() == Letters){
                puntuation=6;
            }else{
                if(txt_Password.getText().length() == Numbers){
                    puntuation=3;
                }else{
                    puntuation = 3*txt_Password.getText().length();
                    puntuation+=2*PowerLetters(txt_Password.getText());
                    puntuation+= 1+ Letters;
                    puntuation+= Numbers + 2;
                    puntuation+=(txt_Password.getText().length()-Letters-Numbers)+ 4;
                }
            }
           PasswordLevel(puntuation); 
        txt_Password.setEnabled(true);
        }
    }//GEN-LAST:event_txt_PasswordKeyReleased

    private void txt_LastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LastNameKeyTyped
        // TODO add your handling code here:
         if(txt_LastName.getText().length()>= LastNameLength){
            evt.consume();
        }
    }//GEN-LAST:event_txt_LastNameKeyTyped

   private void txt_DescriptionKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_DescriptionKeyPressed
   {//GEN-HEADEREND:event_txt_DescriptionKeyPressed
      // TODO add your handling code here:
         if(evt.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER ){
            evt.consume();
         }
   }//GEN-LAST:event_txt_DescriptionKeyPressed

   private void txt_DescriptionKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txt_DescriptionKeyTyped
   {//GEN-HEADEREND:event_txt_DescriptionKeyTyped
      // TODO add your handling code here:
      if(txt_Description.getText().length()>=100){
               evt.consume();
     }
   }//GEN-LAST:event_txt_DescriptionKeyTyped

    private void btn_regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_regresarMouseClicked
        // TODO add your handling code here:
        
        RedSocial.SettingsAdminController();
        this.dispose();
    }//GEN-LAST:event_btn_regresarMouseClicked
    
    private boolean ImageExistInMEIA(String Name){
        File ImageDir = new File(DIRECTORY+IMAGES);
        if(!ImageDir.exists()){
            ImageDir.getAbsoluteFile().mkdir();
            return false;
        }else{
            File Image = new File(DIRECTORY+""+IMAGES+"\\"+Name);
            if(Image.exists()){
                return true;
            }
            return false;
        }
    }
    
    private void CopyImagesToMEIA (String Origin, String Destiny)    {
        try {
                Path origenPath = Paths.get(Origin);
                Path destinoPath = Paths.get(Destiny);
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                //This rename the picture
                File Picture = new File(Destiny);
                File NewName = NewPictureName(Destiny.split(Pattern.quote("."))[Destiny.split(Pattern.quote(".")).length-1]);
                Picture.renameTo(NewName);
                PicturePath = NewName.getAbsolutePath();
        } catch(Exception e){
                
            }
    }
    
    private File NewPictureName(String ext){
        File newName;
        do{
             PictureCount++;
            newName = new File(DIRECTORY + IMAGES+"\\"+ PictureCount+"."+ext);
        }while(newName.exists());
        return newName;
    }
    
    private int PowerLetters(String sequence){
        int count=0;
        for (int i = 0; i < sequence.length(); i++) {
            if("QWERTYUIOPASDFGHJKLÑZXCVBNM".indexOf(sequence.charAt(i))!=-1){
                count++;
            }
        }
        return count;
    }
    
    private int Letters(String sequence){
        int count =0;
         for (int i = 0; i < sequence.length(); i++) {
            if("QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnm".indexOf(sequence.charAt(i))!=-1){
                count++;
            }
        }
        return count;
    }
    
    private int Numbers(String sequence){
        int count =0;
         for (int i = 0; i < sequence.length(); i++) {
            if("1234567890".indexOf(sequence.charAt(i))!=-1){
                count++;
            }
        }
        return count;
    }
    
    private void PasswordLevel(int puntuation){
        if(puntuation<=25){
            //insegura
            lbl_Level.setForeground(Color.RED);
            lbl_Level.setText("Contraseña insegura");
        }else{
            if(puntuation<=35){
                //poco segura
                lbl_Level.setForeground(Color.ORANGE);
                lbl_Level.setText("Contraseña poco segura");
            }else{
                if(puntuation<=50){
                    //segura
                    lbl_Level.setForeground(Color.BLUE);
                    lbl_Level.setText("Contraseña segura");
                }else{
                    if(puntuation<=100){
                        //muy segura
                        lbl_Level.setForeground(Color.GREEN);
                        lbl_Level.setText("Contraseña muy segura");
                    }
                }
            }
        }
    }
   
    private String IsManager(){
       return FileManager.FileExists(USER_FILE) ? "0": "1";
    }
    
    private boolean IsDataValid(){
       //if(txt_User.Existe){return false} //MOSTRAR LABEL
       if(FileManager.FileExists(BINNACLE +USER_FILE)){
          if(FileManager.Search(txt_User.getText())!=null){
            lbl_UserError.setVisible(true);
            return false; 
          }
       }
        if(lbl_Level.getText().equals("Contraseña insegura") || lbl_Level.getText().equals("Tiene que ser mayor de 6 caracteres")){
            txt_Password.setBackground(Color.RED);
            return false;}
        if(txt_Name.getText().isEmpty()){
            lbl_NameError.setVisible(true);
            return false;}
        if(txt_LastName.getText().isEmpty()){
            lbl_LastNameError.setVisible(true);
            return false;}
        if(!(txt_CheckPassword.getText().equals(txt_Password.getText()))){
            lbl_PasswordCheckedError.setVisible(true);
            return false;
        }
        if(txt_Mail.getText().isEmpty()){
            lbl_MailError.setVisible(true);
            return false;
        }else{
           try{
              if(txt_Mail.getText().split(Pattern.quote("@")).length !=2 || txt_Mail.getText().split(Pattern.quote("@"))[0].isEmpty() || txt_Mail.getText().split(Pattern.quote("@"))[1].isEmpty()){
                 lbl_MailError.setText("Es necesario un correo válido");
                 lbl_MailError.setVisible(true);
                 return false;
              }
           }catch(Exception e){
              
           }
        }
        if(txt_PhoneNumber.getText().isEmpty()){
            lbl_NumberPhoneError.setVisible(true);
            lbl_NumberPhoneError.setText("Es necesario un número telefónico");
            return false;
        }
        try{
            if(txt_PhoneNumber.getText().length()<8){
                lbl_NumberPhoneError.setVisible(true);
                return false;
            }
            Integer.parseInt(txt_PhoneNumber.getText());
        }catch(Exception e){
            lbl_NumberPhoneError.setVisible(true);
            return false;
        }
        
        if(PicturePath.equals("")){
            lbl_PictureError.setVisible(true);
            return false;
        }
        return true;
    }
    
    private String CreateUser(){
       try{
        return (txt_User.getText()+"|"+ txt_Name.getText()+"|"+ txt_LastName.getText()+"|"+ RedSocial.MD5(txt_Password.getText())+"|"+ IsManager()+"|"+Sp_Birthday.getValue().toString()+"|" + txt_Mail.getText()+"|" + txt_PhoneNumber.getText()+"|" + PicturePath+"|" + txt_Description.getText() + "|1");   
       }catch(Exception e){
          return "";
       }
      }
    private void InvisibleComponents(){
        lbl_Level.setVisible(false);
        lbl_UserError.setVisible(false);
        lbl_NameError.setVisible(false);
        lbl_LastNameError.setVisible(false);
        lbl_PasswordCheckedError.setVisible(false);
        lbl_MailError.setVisible(false);
        lbl_NumberPhoneError.setVisible(false);
        lbl_PictureError.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Sp_Birthday;
    private javax.swing.JButton btn_FindPicture;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_LastNameError;
    private javax.swing.JLabel lbl_Level;
    private javax.swing.JLabel lbl_MailError;
    private javax.swing.JLabel lbl_NameError;
    private javax.swing.JLabel lbl_NumberPhoneError;
    private javax.swing.JLabel lbl_PasswordCheckedError;
    private javax.swing.JLabel lbl_PictureError;
    private javax.swing.JLabel lbl_PicturePath;
    private javax.swing.JLabel lbl_UserError;
    private javax.swing.JPasswordField txt_CheckPassword;
    private javax.swing.JTextArea txt_Description;
    private javax.swing.JTextField txt_LastName;
    private javax.swing.JTextField txt_Mail;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_PhoneNumber;
    private javax.swing.JTextField txt_User;
    // End of variables declaration//GEN-END:variables
}
