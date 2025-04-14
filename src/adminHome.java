import java.sql.*;
import javax.swing.JOptionPane;


public class adminHome extends javax.swing.JFrame {

    
    public adminHome() {
        initComponents();
        
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        bt1.setBackground(new java.awt.Color(153, 255, 153));
        bt1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        bt1.setText("Manage Categories");
        bt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(160, 290, 350, 120);

        bt2.setBackground(new java.awt.Color(153, 255, 153));
        bt2.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        bt2.setText("Manage Products");
        bt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(555, 290, 350, 120);

        bt3.setBackground(new java.awt.Color(153, 255, 153));
        bt3.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        bt3.setText("Change Password");
        bt3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(950, 290, 350, 120);

        bt4.setBackground(new java.awt.Color(153, 255, 153));
        bt4.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        bt4.setText("Generate New Bill");
        bt4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(160, 480, 350, 120);

        bt5.setBackground(new java.awt.Color(153, 255, 153));
        bt5.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        bt5.setText("Bill History");
        bt5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });
        getContentPane().add(bt5);
        bt5.setBounds(555, 480, 350, 120);

        bt6.setBackground(new java.awt.Color(255, 102, 102));
        bt6.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        bt6.setText("Logout");
        bt6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });
        getContentPane().add(bt6);
        bt6.setBounds(950, 480, 350, 120);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN HOME");
        jLabel1.setAutoscrolls(true);
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 0, 620, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        adminManageProducts objpr= new adminManageProducts();
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        
        int input=JOptionPane.showInternalConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if(input==0)
        {
            global.adminEmail= "";
            global.gtotal=0;
            adminLogin obj= new adminLogin();
            dispose();
        }
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        adminChangePassword objpw= new adminChangePassword();
        dispose();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        adminManageCategories objcat= new adminManageCategories();
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        adminBillHistory objhis= new adminBillHistory();
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        adminGenerateBill objbill= new adminGenerateBill();
    }//GEN-LAST:event_bt4ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
