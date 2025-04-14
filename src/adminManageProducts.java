
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class adminManageProducts extends javax.swing.JFrame {

    Vector<String> vl;
    ArrayList<products> al;
    File selectedFile;
    mytablemodel tm;
    int count;

    public adminManageProducts() {

        al = new ArrayList<>();
        vl = new Vector<>();
        tm = new mytablemodel();

        initComponents();

        adminShowDropDown();
        alreadyAddedItems();

        cb1.setModel(new DefaultComboBoxModel<>(vl));
        tb1.setModel(tm);
        cb1.setSelectedIndex(-1);

        setVisible(true);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tpane.add("Add New Product", jPanel1);
        tpane.add("Existing Products", jPanel2);
    }

    void adminShowDropDown() {
        try {
            ResultSet rs = DBLoader.executeQuery("select catName from categories", "pos2024");

            while (rs.next()) {
                String catName = rs.getString("catName");
                vl.add(catName);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static BufferedImage scale(BufferedImage src, int w, int h) {
        BufferedImage img
                = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++) {
            ys[y] = y * hh / h;
        }
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        tpane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf2 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cb1 = new javax.swing.JComboBox<>();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE PRODUCTS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 0, 800, 100);

        tpane.setBackground(new java.awt.Color(204, 204, 204));
        tpane.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N

        jPanel2.setLayout(null);

        tb1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        tb1.setModel(tm);
        tb1.setRowHeight(25);
        tb1.setShowHorizontalLines(true);
        tb1.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tb1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(290, 30, 700, 420);

        jButton3.setBackground(new java.awt.Color(153, 255, 102));
        jButton3.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jButton3.setText("Delete");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(520, 490, 260, 50);

        tpane.addTab("Existing Products", jPanel2);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel2.setText("Product Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 50, 170, 40);

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel3.setText("Description:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 170, 170, 40);

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel4.setText("Photo:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 290, 150, 40);

        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel5.setText("Category:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(760, 50, 130, 40);

        jLabel6.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel6.setText("Price:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(760, 140, 110, 40);

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel7.setText("Offer Price:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(760, 230, 140, 40);

        tf1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jPanel1.add(tf1);
        tf1.setBounds(390, 50, 230, 40);

        tf2.setColumns(20);
        tf2.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        tf2.setRows(5);
        jScrollPane1.setViewportView(tf2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(390, 150, 294, 120);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(390, 300, 240, 150);

        jButton1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton1.setText("Choose");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 420, 110, 30);

        cb1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(vl));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        jPanel1.add(cb1);
        cb1.setBounds(930, 50, 210, 40);

        tf3.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });
        jPanel1.add(tf3);
        tf3.setBounds(930, 140, 210, 40);

        tf4.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jPanel1.add(tf4);
        tf4.setBounds(930, 230, 210, 40);

        jButton2.setBackground(new java.awt.Color(153, 255, 102));
        jButton2.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jButton2.setText("Add");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(520, 490, 260, 50);

        jLabel9.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel9.setText("Quality:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(760, 320, 130, 40);

        tf5.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jPanel1.add(tf5);
        tf5.setBounds(930, 320, 210, 40);

        tpane.addTab("Add New Product", jPanel1);

        getContentPane().add(tpane);
        tpane.setBounds(100, 120, 1270, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed

    }//GEN-LAST:event_cb1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String prodName = tf1.getText();
        String desc = tf2.getText();
        String photo = SaveFile.saveFile(selectedFile);
        String catName = (String) cb1.getSelectedItem();
        int price = Integer.parseInt(tf3.getText());
        int offerPrice = Integer.parseInt(tf4.getText());
        int quantity = Integer.parseInt(tf5.getText());

        try {
            ResultSet rs = DBLoader.executeQuery("select * from products where prodName='" + prodName + "'", "pos2024");
            if (rs.next()) {
                JOptionPane.showInternalMessageDialog(null, "Product already exists");
            } else {
                //if(prodName.equals(null)||desc.equals(null)||catName.equals(null)||tf3.getText().equals(null)||tf4.getText().equals(null)||cb1.getSelectedIndex()==-1||tf5.getText().equals(null)||photo.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Any section cannot be empty");
            }
               // else
                {
                rs.moveToInsertRow();

                rs.updateString("prodName", prodName);
                rs.updateString("desc", desc);
                rs.updateString("photo", photo);
                rs.updateString("catName", catName);
                rs.updateInt("price", price);
                rs.updateInt("offerPrice", offerPrice);
                rs.updateInt("quantity", quantity);

                rs.insertRow();

                JOptionPane.showInternalMessageDialog(null, "Product added successfully");
                alreadyAddedItems();
                }

            }

            tf1.setText(null);
            tf2.setText(null);
            jLabel8.setIcon(null);
            tf3.setText(null);
            tf4.setText(null);
            tf5.setText(null);
            cb1.setSelectedIndex(-1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ans = jFileChooser1.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {

            selectedFile = jFileChooser1.getSelectedFile();
            try {
                BufferedImage bi = ImageIO.read(selectedFile);
                bi = scale(bi, jLabel8.getWidth(), jLabel8.getHeight());

                jLabel8.setIcon(new ImageIcon(bi));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int col = 0;
        int row = tb1.getSelectedRow();
        String prodName = (String) tb1.getModel().getValueAt(row, col);

        try {
            ResultSet rs = DBLoader.executeQuery("select * from products where prodName='" + prodName + "'", "pos2024");
            if (rs.next()) {
                rs.deleteRow();
                alreadyAddedItems();

                JOptionPane.showInternalMessageDialog(null, "Deleted Successfully");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextArea tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTabbedPane tpane;
    // End of variables declaration//GEN-END:variables

    void alreadyAddedItems() {
        al.clear();
        count = 0;
        try {
            ResultSet rs = DBLoader.executeQuery("select * from products", "pos2024");
            while (rs.next()) {

                count++;
                String prodName = rs.getString("prodName");
                String desc = rs.getString("desc");

                String catName = rs.getString("catName");
                int price = rs.getInt("price");
                int offerPrice = rs.getInt("offerPrice");
                int quantity = rs.getInt("quantity");
                al.add(new products(prodName, desc, catName, price, offerPrice, quantity));
                tm.fireTableDataChanged();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return count;
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Product Name", "Description", "Category Name", "Price", "Offer Price", "Quantity"};
            return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            products obj = al.get(i);
            return switch (j) {
                case (0) ->
                    obj.prodName;
                case (1) ->
                    obj.desc;
                case (2) ->
                    obj.catName;
                case (3) ->
                    obj.price;
                case (4) ->
                    obj.offerPrice;
                default ->
                    obj.quantity;
            };
        }
    }

}
