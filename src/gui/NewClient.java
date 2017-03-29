/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import glbank.Client;
import glbank.database.ConnectionProvider;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Client
 */
public class NewClient extends javax.swing.JDialog {

    /**
     * Creates new form NewClient
     */
    public NewClient(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lblerrormesusername.setText("");
        lblerrorMessage.setText("");
        lblerrorNumber.setText("");
        lblconfirmPass.setText("");
        lblnewPass.setText("");
        lblerrorMessage1.setText("");
        String newPassword = generatePassword();
        txtpassword.setText(newPassword);
        txtpasswordconfirm.setText(newPassword);
        dateChooserCombo1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtstreet = new javax.swing.JTextField();
        txthousenumber = new javax.swing.JTextField();
        txtpostcode = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        txtpasswordconfirm = new javax.swing.JPasswordField();
        lblerrormesusername = new javax.swing.JLabel();
        lblerrorMessage = new javax.swing.JLabel();
        lblerrorNumber = new javax.swing.JLabel();
        lblnewPass = new javax.swing.JLabel();
        lblconfirmPass = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        lblerrorMessage1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("New Client");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("First name: ");

        jLabel3.setText("Last name: ");

        jLabel4.setText("Date of birth:");

        jLabel5.setText("Email: ");

        jLabel6.setText("Street:");

        jLabel7.setText("House number:");

        jLabel8.setText("Post code:");

        jLabel9.setText("Username: ");

        jLabel10.setText("Password:");

        jLabel11.setText("City:");

        txthousenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthousenumberActionPerformed(evt);
            }
        });

        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        jLabel12.setText("Confirm Password:");

        txtpasswordconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordconfirmActionPerformed(evt);
            }
        });

        lblerrormesusername.setForeground(new java.awt.Color(255, 0, 0));
        lblerrormesusername.setText("ERROR");

        lblerrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorMessage.setText("ERROR");

        lblerrorNumber.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorNumber.setText("ERROR");

        lblnewPass.setForeground(new java.awt.Color(255, 0, 0));
        lblnewPass.setText("ERROR");

        lblconfirmPass.setForeground(new java.awt.Color(255, 0, 0));
        lblconfirmPass.setText("ERROR");

        lblerrorMessage1.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorMessage1.setText("ERROR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtpostcode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(txthousenumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstreet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblerrorNumber))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addGap(52, 52, 52))
                            .addComponent(txtlastname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfirstname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblerrorMessage1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(62, 62, 62)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(263, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblerrormesusername)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtusername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtpasswordconfirm, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblnewPass)
                            .addComponent(lblconfirmPass))
                        .addContainerGap(62, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(lblerrorMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(lblerrormesusername)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnewPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtpasswordconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconfirmPass)
                    .addComponent(lblerrorMessage1))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtstreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthousenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblerrorNumber))
                        .addGap(18, 18, 18)
                        .addComponent(txtpostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblerrorMessage)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtpasswordconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordconfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordconfirmActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         boolean seq1= false;
         boolean seq2= false;
         boolean seq3= false;
         boolean seq4= false;
         boolean seq5= false;
         boolean seq6 = false;
         String email="";
         String street="";
         int housenumber=0;
         String postcode = "";
         String city = "";
         String username = "";
         Date dob = new Date() ;
         String password = "";
         
//FIRSTNAME AND LASTNAME         
      String firstname =  txtfirstname.getText();
       String lastname = txtlastname.getText();
       if( firstname.equals("") || lastname.equals("")){
           lblerrorMessage1.setText("Please fill First name and last name");
           seq1 = false;
       }else{
           seq1 = true;
           lblerrorMessage1.setText("");
            email = txtemail.getText();
            street = txtstreet.getText();
//HOUSE NUMBER          
           if(!txthousenumber.getText().equals("")){
               try{
             housenumber = Integer.parseInt(txthousenumber.getText());
             lblerrorNumber.setText("");
             seq1 = true;
               }catch(Exception ex){
               lblerrorNumber.setText("Please fill number");
               seq1 = false;
               }
               
           }
//HOUSE NUMBER               
           postcode =  txtpostcode.getText();
           city = txtcity.getText();
//DATE
           dob = dateChooserCombo1.getSelectedDate().getTime();
           String date = new SimpleDateFormat("yyyy").format(dob);
           int date1= Integer.parseInt(date);
           int date2= Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));           
           if(date2-date1<15){
           lblerrorMessage1.setText("Client must be older than 15 years to create");
           seq6=false;
           }else{
               lblerrorMessage1.setText("");
               seq6=true;
           }
//DATE
           
           if(email.equals("") ||email.length()<9 || street.equals("") || 
                   (housenumber < 1)  || postcode.equals("") || city.equals("")){
               lblerrorMessage.setText("Please fill or edit contact details of client");
           seq2 = false;
           }
           else{
               seq2 = true;
               lblerrorMessage.setText("");
           }
      
       }
           
        String login =    txtusername.getText();       
         ConnectionProvider connection = new ConnectionProvider();
        try {
            if(connection.existClientLogin(login)){
                lblerrormesusername.setText("Username already exists");
            seq3=false;
            }
            else{
                lblerrormesusername.setText("");
                username=login;
                seq3=true;
            }
                } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(login.equals("")){
            seq3 = false;
            lblerrormesusername.setText("Please fill username");
        }
        
        else{ lblerrormesusername.setText("");
        username=login;
        seq3=true;
        }
         char[] inputNewPassword = txtpassword.getPassword();
        String newPassword = new String(inputNewPassword);
        
        char[] inputConfirmPassword = txtpasswordconfirm.getPassword();
        String confirmPassword = new String(inputConfirmPassword);
        
        if(newPassword.equals("")||newPassword.length()<5){
            lblnewPass.setText("Please fill right password");
            seq4= false;
        }
        else  {
            seq4=true;
            lblnewPass.setText("");
            if(newPassword.equals(confirmPassword)){
                password = newPassword;
                seq5=true;
                lblconfirmPass.setText("");
                
        }
        else {lblconfirmPass.setText("Passwords are not same!");
            seq5=false;}
        }
           
          
      if(seq1&&seq2&&seq3&&seq4&&seq5&&seq6){
            
            Client client = new Client(0, firstname,lastname, email, street, housenumber, postcode, city, username,false, false,dob);
             try {
                 connection.insertClientToDatabase(client, password);
                 this.dispose();
                 
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
             } catch (InstantiationException ex) {
                 Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IllegalAccessException ex) {
                 Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
             }
             
            
        }    
 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txthousenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthousenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthousenumberActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // gui.MainForm.initForm();
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    private String generatePassword() {
        String password = "";
        Random rand = new Random();

        for (char i = 0; i <= 3; i++) {
            password += (char) (rand.nextInt(( 122 -97) + 1) + 97);
            
        }
         for (char i = 0; i <= 3; i++) {
            password += (char) (rand.nextInt((90-65) + 1) + 65);
             
        }
          for (char i = 0; i <= 3; i++) {
            password += (char) (rand.nextInt(( 57 -48) + 1) + 48);
             
        }
           
        return password;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblconfirmPass;
    private javax.swing.JLabel lblerrorMessage;
    private javax.swing.JLabel lblerrorMessage1;
    private javax.swing.JLabel lblerrorNumber;
    private javax.swing.JLabel lblerrormesusername;
    private javax.swing.JLabel lblnewPass;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txthousenumber;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JPasswordField txtpasswordconfirm;
    private javax.swing.JTextField txtpostcode;
    private javax.swing.JTextField txtstreet;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
