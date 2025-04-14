
import javax.swing.JOptionPane;
import java.sql.*;


public class adminChangePassword extends javax.swing.JFrame {

    public adminChangePassword() {
        
        
        initComponents();
        
        setVisible(true);
        setSize(600,420);
        setLocationRelativeTo(null);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        lb4 = new javax.swing.JLabel();
        pf1 = new javax.swing.JPasswordField();
        pf2 = new javax.swing.JPasswordField();
        pf3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        lb1.setForeground(new java.awt.Color(204, 0, 51));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("CHANGE PASSWORD");
        getContentPane().add(lb1);
        lb1.setBounds(100, 0, 400, 60);

        lb2.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        lb2.setText("Old Password:");
        getContentPane().add(lb2);
        lb2.setBounds(40, 140, 250, 40);

        lb3.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        lb3.setText("New Password:");
        getContentPane().add(lb3);
        lb3.setBounds(40, 200, 250, 40);

        bt1.setBackground(new java.awt.Color(153, 255, 102));
        bt1.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        bt1.setText("Change");
        bt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(235, 320, 130, 40);

        lb4.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        lb4.setText("Confirm New Password:");
        getContentPane().add(lb4);
        lb4.setBounds(40, 260, 260, 40);

        pf1.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        pf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf1ActionPerformed(evt);
            }
        });
        getContentPane().add(pf1);
        pf1.setBounds(330, 140, 160, 30);

        pf2.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        getContentPane().add(pf2);
        pf2.setBounds(330, 200, 160, 30);

        pf3.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        pf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf3ActionPerformed(evt);
            }
        });
        getContentPane().add(pf3);
        pf3.setBounds(330, 260, 160, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(125, 330, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf3ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
    
        String oldPswrd= pf1.getText();
        String newPswrd= pf2.getText();
        String confirmNewPswrd= pf3.getText();
        String email=global.adminEmail;
        
        if(newPswrd.equals(confirmNewPswrd))
        {
            try{
            ResultSet rs= DBLoader.executeQuery("select * from admin where email='"+email+"'"+"and password='"+oldPswrd+"'","pos2024");
            if(rs.next())
            {
                rs.updateString("password", newPswrd);
                rs.updateRow();
                JOptionPane.showInternalMessageDialog(null, "Password Changed");
                
                adminLogin objlg= new adminLogin();
                dispose();
                
            }
            else
            {
                JOptionPane.showInternalMessageDialog(null, "Old Password does not match");
            }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null, "New Password and Confirm New Password do not match");
        }
        
    }//GEN-LAST:event_bt1ActionPerformed

    private void pf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adminHome objlg= new adminHome();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JPasswordField pf1;
    private javax.swing.JPasswordField pf2;
    private javax.swing.JPasswordField pf3;
    // End of variables declaration//GEN-END:variables
}
