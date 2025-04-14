
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

public class adminGenerateBill extends javax.swing.JFrame implements ActionListener {

    int grandTotal = 0;
    JButton bt1;
    ArrayList<cart> al;
    mytablemodel tm;

    public adminGenerateBill() {

        al = new ArrayList<>();
        tm = new mytablemodel();

        initComponents();

        jTable1.setModel(tm);
        showCategories();
        jLabel6.setText(String.valueOf(grandTotal));

        setVisible(true);
        setSize(750, 500);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    void showCategories() {
        int count = 0;
        try {
            ResultSet rs = DBLoader.executeQuery("select * from categories", "pos2024");
            while (rs.next()) {
                String catName = rs.getString("catName");
                String photo = rs.getString("photo");

                bt1 = new JButton();
                bt1.setText(catName);
                bt1.setFont(jTable1.getFont());
                bt1.setBackground(jLabel8.getBackground());
                bt1.setBorder(jButton1.getBorder());
                bt1.setCursor(jButton1.getCursor());

                try {
                    BufferedImage bi = ImageIO.read(new File(photo));
                    bi = scale(bi, 195, 108);
                    bt1.setIcon(new ImageIcon(bi));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                bt1.setHorizontalTextPosition(SwingConstants.CENTER);
                bt1.setVerticalTextPosition(SwingConstants.BOTTOM);

                bt1.setBounds(50, 150 * count + 20, 200, 140);

                jPanel1.add(bt1);
                jPanel1.repaint();

                bt1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        showProducts(catName);
                    }
                });

                count++;

            }

            jPanel1.setPreferredSize(new Dimension(250, 150 * count + 20));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void showProducts(String catName) {
        jPanel2.removeAll();
        int count = 0;
        try {

            ResultSet rs = DBLoader.executeQuery("select * from products where catName ='" + catName + "'", "pos2024");
            while (rs.next()) {

                String prodName = rs.getString("prodName");
                String photo = rs.getString("photo");
                int stock = rs.getInt("quantity");

                bt1 = new JButton();
                bt1.setText(prodName+" ("+stock+")");
                bt1.setFont(jTable1.getFont());
                bt1.setBackground(jLabel8.getBackground());
                bt1.setBorder(jButton1.getBorder());
                bt1.setCursor(jButton1.getCursor());

                try {

                    BufferedImage bi = ImageIO.read(new File(photo));
                    bi = scale(bi, 195, 108);
                    bt1.setIcon(new ImageIcon(bi));

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                bt1.setHorizontalTextPosition(SwingConstants.CENTER);
                bt1.setVerticalTextPosition(SwingConstants.BOTTOM);

                bt1.setBounds(50, 150 * count + 20, 200, 140);

                jPanel2.add(bt1);
                jPanel2.repaint();

                bt1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (stock <= 0) {
                                JOptionPane.showMessageDialog(null, "Out of Stock");
                            } else {
                                showCart(prodName);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                count++;
            }

            jPanel2.setPreferredSize(new Dimension(250, 150 * count + 20));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showCart(String prodName) {
        int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter quantity"));
        try {
            ResultSet rs = DBLoader.executeQuery("select * from products where prodName='" + prodName + "' and quantity>='" + quantity + "'", "pos2024");
            if (rs.next()) {
                String catName = rs.getString("catName");
                int stock = rs.getInt("quantity");
                int offerPrice = rs.getInt("offerPrice");
                int totalPrice = quantity * offerPrice;
                
                int removedStock= stock - quantity;

                al.add(new cart(prodName, catName, quantity, offerPrice, totalPrice,removedStock));
                grandTotal += totalPrice;

                tm.fireTableDataChanged();
                jLabel6.setText(String.valueOf(grandTotal));
                

            } else {
                JOptionPane.showMessageDialog(this, "The quantity is more than the available stock");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILLING FORM");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 4, 800, 100);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 180, 310, 490);

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choose Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 120, 310, 60);

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Choose Products");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(510, 120, 310, 60);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(510, 180, 310, 490);

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(930, 120, 450, 60);

        jTable1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(25);
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(930, 180, 452, 402);

        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel5.setText("Grand Total:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1000, 580, 150, 30);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1150, 580, 150, 30);

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        jButton1.setText("Gererate Bill");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1030, 630, 260, 50);

        jLabel8.setBackground(new java.awt.Color(153, 255, 153));
        jLabel8.setText("jLabel8");
        jLabel8.setVisible(false);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(430, 210, 115, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        global.gtotal = grandTotal;
        
        adminGetDetails objdet = new adminGetDetails(al);
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Product Name", "Category Name", "Quantity", "Offer Price", "Total Price"};
            return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            cart obj = al.get(i);
            return switch (j) {
                case (0) ->
                    obj.prodName;
                case (1) ->
                    obj.catName;
                case (2) ->
                    obj.quantity;
                case (3) ->
                    obj.offerPrice;
                default ->
                    obj.totalPrice;
            };
        }

    }

}
