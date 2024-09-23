
package patata;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioForm extends JFrame {

    
    
    
   

String bd = "javacrud";
String url = "jdbc:mysql://localhost:3306/";
String user = "root";
String password = "";
String driver = "com.mysql.cj.jdbc.Driver";
Connection con;
PreparedStatement pst;
ResultSet rs;
    public FormularioForm() {
        initComponents();
        connect();
        LoadProductNo();
        Fetch();
    }



public void connect(){
        try {
            Class.forName(driver);
       
         con = DriverManager.getConnection(url+bd, user, password);
            System.out.println("se conecto a la base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}

public void LoadProductNo(){
        try {
            pst = con.prepareStatement("SELECT id FROM  product_tbl");
            rs = pst.executeQuery();
            txtpid.removeAllItems();
            
            while(rs.next()){
            txtpid.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void Fetch(){
    
       
        try {
             int q;
            pst = con.prepareStatement("SELECT * FROM product_tbl ");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            while ( rs.next() ){
            
            Vector v2 = new Vector();
            for(int a = 1; a<=q; a++){
            v2.add(rs.getString("id"));
            v2.add(rs.getString("pname"));
            v2.add(rs.getString("price"));
            v2.add(rs.getString("qty"));
            
            }
            df.addRow(v2);
            
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        txtpid = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("nombre producto");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("pecrio Producto");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("cantidad");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Produc Id");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExport.setText("Export to CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto ID", "Nombre producto", "Precio", "cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("PRODUCTOS CADUCADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnExport)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtPrice)
                                                .addComponent(txtQty, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPname))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnExport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      
          if(txtPname.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Product name required!!!");
        }else if(txtPrice.getText().isEmpty()){
          JOptionPane.showMessageDialog(this,"Product price required!!!");
        }else if(txtQty.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Product qty required!!!");
        }else{

        
        try {
            // TODO add your handling code here:
            
            String pname  = txtPname.getText();
            String price  = txtPrice.getText();
            String qty  = txtQty.getText();
            String pid  = txtpid.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE product_tbl SET pname=?, price=?, qty=? WHERE id=?");
            pst.setString(1, pname);
            pst.setString(2, price);
            pst.setString(3, qty);
            pst.setString(4, pid);
            
            int k = pst.executeUpdate();
            if (k==1){
             JOptionPane.showMessageDialog(this,"Reccord has been successfully updated ");
             
                    txtPname.setText("");
                    txtPrice.setText("");
                    txtQty.setText("");
                    txtPname.requestFocus();
                   Fetch();
                LoadProductNo();
             
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if(txtPname.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Product name required!!!");
        }else if(txtPrice.getText().isEmpty()){
          JOptionPane.showMessageDialog(this,"Product price required!!!");
        }else if(txtQty.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Product qty required!!!");
        }else{


        try {
            // TODO add your handling code here:
            String pname = txtPname.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            
            pst = con.prepareStatement("INSERT INTO product_tbl (pname,price,qty) VALUES (?,?,?) ");
            pst.setString(1, pname);
            pst.setString(2, price);
            pst.setString(3, qty);
            
            int k = pst.executeUpdate();
            if (k == 1){
                JOptionPane.showMessageDialog(this,"Reccord added!! successfully");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                
                 Fetch();
                LoadProductNo();
                 
            }else {
            JOptionPane.showMessageDialog(this,"Reccord faild to saved");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            
            String pid = txtpid.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM product_tbl WHERE id=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
            
            if ( k==1 ){
             JOptionPane.showMessageDialog(this,"Recoord has been Succeessfully deleted!!!!");
                    txtPname.setText("");
                    txtPrice.setText("");
                    txtQty.setText("");
                    txtPname.requestFocus();
                   Fetch();
                LoadProductNo();
                     
            }else{
                         JOptionPane.showMessageDialog(this,"Recoord failed to deleted!!!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpidActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // TODO add your handling code here:
            
            String pid = txtpid.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM product_tbl WHERE id=?");
            pst.setString(1, pid);
            rs = pst.executeQuery();
            
            if (rs.next() ==true ){
                    txtPname.setText(rs.getString(2));
                    txtPrice.setText(rs.getString(3));
                    txtQty.setText(rs.getString(4));
                
            }else{
            JOptionPane.showMessageDialog(this,"No record found");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        
        try {
            // TODO add your handling code here:
            String fileName="C:\\Users\\ASUS\\Downloads\\huevos1.csv";
             FileWriter  fw = new FileWriter(fileName);
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            
            while(rs.next()){
            fw.append(rs.getString(1));
            fw.append(';');
            fw.append(rs.getString(2));
            fw.append(';');
            fw.append(rs.getString(3));
            fw.append(';');
            fw.append(rs.getString(4));
            fw.append('\n');
            }
               JOptionPane.showMessageDialog(this,"CSV FILE is exported successfully");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }//GEN-LAST:event_btnExportActionPerformed

    
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //new FormularioForm().setVisible(true);
               new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration//GEN-END:variables
}
