
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class adminGetDetails extends javax.swing.JFrame {
   
    ArrayList<cart> al;
    int billId;
    
    public adminGetDetails(ArrayList<cart> al) {
        
        
        initComponents();
       
        
        this.al= al;
        
        setVisible(true);
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payment");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 0, 280, 60);

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel2.setLabelFor(jTextField1);
        jLabel2.setText("User Contact:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 100, 190, 50);

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel3.setText("Payment Mode:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 190, 190, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(280, 110, 200, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Cash", "Online" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(280, 200, 200, 30);

        jButton1.setBackground(new java.awt.Color(153, 255, 102));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jButton1.setText("Make Payment");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 300, 200, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String paymentType= (String) jComboBox1.getSelectedItem();
        String phoneNo= jTextField1.getText();
        String adminEmail= global.adminEmail;
        int gtotal= global.gtotal;
        try{
            ResultSet rs=DBLoader.executeQuery("select * from bill","pos2024");
           
                rs.moveToInsertRow();
                rs.updateInt("gtotal", gtotal);
                rs.updateString("adminEmail", adminEmail);
                rs.updateString("phoneNo", phoneNo);
                rs.updateString("paymentType", paymentType);
                rs.insertRow();
                // get the max value of billid
            ResultSet rs2= DBLoader.executeQuery("select MAX(billId) as billId from bill", "pos2024");
            {
                rs2.next();
                {
                    billId= rs2.getInt("billId");
                }
            }
//            put entry in billdetail table
            ResultSet rs3=DBLoader.executeQuery("select * from billdetail", "pos2024");
//             this loop go ahead untill the products item in the bill
            for(int i=0;i<al.size();i++)
            {
            rs3.moveToInsertRow();
            rs3.updateInt("billId", billId);
            rs3.updateString("prodName",al.get(i).prodName);
            rs3.updateInt("offerPrice", al.get(i).offerPrice);
            rs3.updateInt("quantity", al.get(i).quantity);
            rs3.insertRow();
            
            ResultSet rs4= DBLoader.executeQuery("select * from products where prodName='"+al.get(i).prodName+"'", "pos2024");
            
            if(rs4.next())
            {
                rs4.updateInt("quantity", al.get(i).removedStock);
                rs4.updateRow();
            }
            }
            
            
            JOptionPane.showMessageDialog(this, "Bill Added Successfully");
            dispose();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
