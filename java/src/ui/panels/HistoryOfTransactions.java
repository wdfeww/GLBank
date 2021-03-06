/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.panels;

import glbank.Account;
import glbank.TransactionHistory;
import glbank.database.ConnectionProvider;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Client
 */
public class HistoryOfTransactions extends javax.swing.JPanel {
    private int idc;
    private int index;
    private int a;
    private int tab ;
    private Object[][] object=new Object[20][3];
    private List<Account> list;
    List<TransactionHistory> data ;
    DefaultTableModel model = new DefaultTableModel();
   
    /**
     * Creates new form HistoryOfTransactions
     */
    public HistoryOfTransactions(int idc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        this.idc=idc;
        initComponents();
       initAccountList();
        jTable1.setVisible(false);    
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        choice1 = new java.awt.Choice();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Description", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        a+=20;
        tab++;
        checkSize();
        jTable1.removeRowSelectionInterval(0, 19);
        initTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
              tab=1;
              a=0;
        index = jComboBox1.getSelectedIndex();
               if (index > 0) {
                  try {
                     data = new ConnectionProvider().getTransactionHistory(list.get(index - 1).getIdacc());
                     
                      checkSize();
                        initTable();
                       
                        
                  } catch (ClassNotFoundException ex) {
                      Logger.getLogger(HistoryOfTransactions.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (InstantiationException ex) {
                      Logger.getLogger(HistoryOfTransactions.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IllegalAccessException ex) {
                      Logger.getLogger(HistoryOfTransactions.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (SQLException ex) {
                      Logger.getLogger(HistoryOfTransactions.class.getName()).log(Level.SEVERE, null, ex);
                  }
               
               }
              
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        a-=20;
        tab--;
        checkSize();
        initTable();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

  

    private void initTable() {
        jTable1.setVisible(true);
        for(int j =0;j<20;j++){
            object[j][0]=null;
            object[j][1]=null;
            object[j][2]=null;
        }
            
       if(data.size()-a>20){
        for(int i =0;i<20;i++){
        object[i][0]  = data.get(i+a).getDate();
        object[i][1]  = data.get(i+a).getDesc();
        object[i][2]  = data.get(i+a).getAmount();
                }}else{
           for(int i =0;i<data.size()-a;i++){
        object[i][0]  = data.get(i+a).getDate();
        object[i][1]  = data.get(i+a).getDesc();
        object[i][2]  = data.get(i+a).getAmount();
                }
       }
       
       
       jTable1.setModel(new javax.swing.table.DefaultTableModel(
                 object,
                new String[]{
                    "Date", "Description", "Amount"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
       
      
    }
    private void initAccountList() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        list = new ConnectionProvider().getAccounts(idc);
        
        if (list == null) {
            return;
        } else {
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Choose:");
            if (list != null && list.size() > 0) {
                for (Account account : list) {
                    String item = "" + account.getIdacc();
                    jComboBox1.addItem(item + " / 2701");
                }
            }
        }
    }
    private void checkSize(){
        
        if(data.size()-a>20){
            jButton1.setEnabled(true);
        }
        else{
             jButton1.setEnabled(false);
        }
        if(tab>1){
             jButton2.setEnabled(true);
        }
        else{
             jButton2.setEnabled(false);}
    }

    
}
