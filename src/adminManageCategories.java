
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;



public class adminManageCategories extends javax.swing.JFrame {
     
    ArrayList<categories> al;
    int count;
    mytablemodel tm;
    File selectedFile;
    
    public adminManageCategories() {
        
        al=new ArrayList<>();
        tm=new mytablemodel();
        alreadyAddedCategories();
        
        initComponents();
   
        tb.setModel(tm);
        
        setVisible(true);
        setSize(750,500);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("ManageCategories");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        tp1.add("Create Category",p1);
        tp1.add("Existing Categories",p2);
        
    }
    
    public static BufferedImage scale(BufferedImage src, int w, int h)
    {
    BufferedImage img = 
            new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    int x, y;
    int ww = src.getWidth();
    int hh = src.getHeight();
    int[] ys = new int[h];
    for (y = 0; y < h; y++)
        ys[y] = y * hh / h;
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
        tp1 = new javax.swing.JTabbedPane();
        p2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        p1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE CATEGORIES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 0, 800, 100);

        tp1.setBackground(new java.awt.Color(204, 204, 204));
        tp1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tp1.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N

        p2.setLayout(null);

        jButton4.setBackground(new java.awt.Color(153, 255, 102));
        jButton4.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jButton4.setText("Delete");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        p2.add(jButton4);
        jButton4.setBounds(510, 470, 260, 50);

        tb.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        tb.setModel(tm);
        tb.setRowHeight(25);
        tb.setShowHorizontalLines(true);
        tb.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tb);

        p2.add(jScrollPane2);
        jScrollPane2.setBounds(390, 10, 490, 420);

        tp1.addTab("Existing Categories", p2);

        p1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel3.setText("Category Name:");
        p1.add(jLabel3);
        jLabel3.setBounds(350, 80, 170, 60);

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel4.setText("Description:");
        p1.add(jLabel4);
        jLabel4.setBounds(350, 190, 170, 60);

        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel5.setText("Photo:");
        p1.add(jLabel5);
        jLabel5.setBounds(350, 340, 170, 60);
        p1.add(jLabel6);
        jLabel6.setBounds(610, 310, 240, 150);

        tf1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        p1.add(tf1);
        tf1.setBounds(610, 80, 250, 50);

        ta1.setColumns(20);
        ta1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        ta1.setRows(5);
        jScrollPane1.setViewportView(ta1);

        p1.add(jScrollPane1);
        jScrollPane1.setBounds(610, 170, 250, 130);

        jButton1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton1.setText("Choose");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        p1.add(jButton1);
        jButton1.setBounds(860, 320, 100, 30);

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
        p1.add(jButton2);
        jButton2.setBounds(510, 470, 260, 50);

        tp1.addTab("Add New Category", p1);

        getContentPane().add(tp1);
        tp1.setBounds(100, 120, 1250, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ans=jFileChooser1.showOpenDialog(this);
        if(ans== JFileChooser.APPROVE_OPTION)
        {
            
            selectedFile= jFileChooser1.getSelectedFile();
            
            try{
                
                BufferedImage bi= ImageIO.read(selectedFile);
                bi= scale(bi,240, 150);
                
                jLabel6.setIcon(new ImageIcon(bi));
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String catName=tf1.getText();
        String desc= ta1.getText();
        String photo=SaveFile.saveFile(selectedFile);
        
        try
        {
            ResultSet rs= DBLoader.executeQuery("Select * from categories where catName ='"+catName+"'", "pos2024");
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "This category is already added");
                
            }
            else
            {
            
            if(catName.isBlank()||desc.isBlank()||photo.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Any section cannot be empty");
            }
            
            else{
            rs.moveToInsertRow();
            
            rs.updateString("catName", catName);
            rs.updateString("desc", desc);
            rs.updateString("photo", photo);
            
            rs.insertRow();
            
           
            JOptionPane.showInternalMessageDialog(null, "Category added successfully");
            alreadyAddedCategories();
            
            }
            }
            tf1.setText(null);
            ta1.setText(null);
            jLabel6.setIcon(null);
            selectedFile=null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int col=0;
        int row=tb.getSelectedRow();
        
        String catName=(String) tb.getModel().getValueAt(row, col);
        
        try{
            ResultSet rs= DBLoader.executeQuery("select * from categories where catName='"+catName+"'", "pos2024");
            
            if(rs.next())
            {
                rs.deleteRow();
                
                alreadyAddedCategories();
                JOptionPane.showInternalMessageDialog(null, "Category deleted successfully");
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed
 
    void alreadyAddedCategories()
    {
        al.clear();
        count=0;
        try
        {
        ResultSet rs=DBLoader.executeQuery("select * from categories", "pos2024");
            while(rs.next())
            {
                count++;
                
                String catName=rs.getString("catName");
                String desc=rs.getString("desc");
                al.add(new categories(catName,desc));
                tm.fireTableDataChanged();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public class mytablemodel extends AbstractTableModel {

        

        @Override
        public int getRowCount() {
        return count;
        }
        @Override
        public String getColumnName(int j)
        {
            String col[]={"Category Name","Description"};
            return col[j];
        }

        @Override
        public int getColumnCount() {
        return 2;
        }

        @Override
        public Object getValueAt(int i, int j) 
        {
            categories obj=al.get(i);
            return switch (j) {
                case 0 -> obj.catName;
                default -> obj.desc;
            };
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTable tb;
    private javax.swing.JTextField tf1;
    private javax.swing.JTabbedPane tp1;
    // End of variables declaration//GEN-END:variables
}
