
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class adminBillHistory extends javax.swing.JFrame {

    ArrayList<bill> al1;
    ArrayList<billDetail> al2;
    mytablemodel1 tm1;
    mytablemodel2 tm2;
    
    public adminBillHistory() {
        
        al1= new ArrayList<>();
        al2= new ArrayList<>();
        tm1= new mytablemodel1();
        tm2= new mytablemodel2();
        
        initComponents();
        
        jTable1.setModel(tm1);
      jTable2.setModel(tm2);
        showExistingBills();
        
        jTabbedPane1.add("Bill Record", jPanel1);
        jTabbedPane1.add("Bill Details", jPanel2);
        
        setSize(750,500);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    void showExistingBills()
    {
        try{
            ResultSet rs= DBLoader.executeQuery("select * from bill", "pos2024");
            while(rs.next())
            {
                int billId= rs.getInt("billId");
                String date= rs.getString("dateTime");
                int gtotal= rs.getInt("gtotal");
                String adminEmail= rs.getString("adminEmail");
                String phoneNo= rs.getString("phoneNo");
                String paymentType= rs.getString("paymentType");
                al1.add(new bill(billId,date, gtotal, adminEmail, phoneNo, paymentType));
                tm1.fireTableDataChanged();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILL HISTORY");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 0, 800, 100);

        jTabbedPane1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N

        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTable1.setModel(tm1);
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(330, 40, 620, 402);

        jButton1.setBackground(new java.awt.Color(153, 255, 102));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jButton1.setText("Get Detail");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(510, 470, 260, 50);

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel2.setText("Search By Phone Number:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1030, 170, 290, 40);

        jTextField1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(1030, 230, 230, 40);

        jButton2.setBackground(new java.awt.Color(153, 255, 102));
        jButton2.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jButton2.setText("Search");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1030, 320, 150, 40);

        jButton3.setBackground(new java.awt.Color(153, 255, 102));
        jButton3.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jButton3.setText("Show All Bills");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1030, 400, 150, 40);

        jTabbedPane1.addTab("Bill Record", jPanel1);

        jPanel2.setLayout(null);

        jTable2.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTable2.setModel(tm2);
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(330, 40, 620, 402);

        jTabbedPane1.addTab("Bill Detail", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(100, 120, 1360, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            al1.clear();
            ResultSet rs= DBLoader.executeQuery("select * from bill", "pos2024");
            while(rs.next())
            {
                int billId= rs.getInt("billId");
                String date= rs.getString("dateTime");
                int gtotal= rs.getInt("gtotal");
                String adminEmail= rs.getString("adminEmail");
                String phoneNo= rs.getString("phoneNo");
                String paymentType= rs.getString("paymentType");
                al1.add(new bill(billId,date, gtotal, adminEmail, phoneNo, paymentType));
                tm1.fireTableDataChanged();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            al1.clear();
            ResultSet rs= DBLoader.executeQuery("select * from bill where phoneNo='"+jTextField1.getText()+"'", "pos2024");
            while(rs.next())
            {
                int billId= rs.getInt("billId");
                String date= rs.getString("dateTime");
                int gtotal= rs.getInt("gtotal");
                String adminEmail= rs.getString("adminEmail");
                String phoneNo= rs.getString("phoneNo");
                String paymentType= rs.getString("paymentType");
                al1.add(new bill(billId,date, gtotal, adminEmail, phoneNo, paymentType));
                tm1.fireTableDataChanged();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText(null);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        al2.clear();
        int col=0;
        int row= jTable1.getSelectedRow();
        int billId= (int) jTable1.getModel().getValueAt(row, col);

        try{
            ResultSet rs= DBLoader.executeQuery("select * from billDetail where billId='"+billId+"'", "pos2024");
            while(rs.next())
            {
                int billDetailId= rs.getInt("billDetailId");
                String prodName = rs.getString("prodName");
                int offerPrice = rs.getInt("offerPrice");
                int quantity = rs.getInt("quantity");
                al2.add(new billDetail(billDetailId, billId, prodName, offerPrice, quantity));
                tm2.fireTableDataChanged();
                jTabbedPane1.setSelectedIndex(1);

            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public class mytablemodel1 extends AbstractTableModel{


        @Override
        public int getRowCount() {
        return al1.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }
        
        @Override
        public String getColumnName(int j)
        {
            String col[]= {"Bill ID","Date","Total Bill","Admin Email","Contact","Payment Method"};
            return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            bill obj= al1.get(i);
            return switch(j){
                case 0 -> obj.billId;
                case 1-> obj.dateTime;
                case 2-> obj.gtotal;
                case 3-> obj.admnEmail;
                case 4-> obj.phoneNo;
                default-> obj.paymentType;
            
        };
        }
    }
    
    public class mytablemodel2 extends AbstractTableModel{


        @Override
        public int getRowCount() {
        return al2.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }
        
        @Override
        public String getColumnName(int j)
        {
            String col[]= {"Bill Detail ID","Bill ID","Product Name","Offer Price","Quantity"};
            return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            billDetail obj= al2.get(i);
            return switch(j){
                case 0 -> obj.billDetailId;
                case 1-> obj.billId;
                case 2-> obj.prodName;
                case 3-> obj.offerPrice;
                default-> obj.quantity;
            
        };
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
