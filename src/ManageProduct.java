/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luzza
 */
import dao.ConnectionProvider;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.*;
public class ManageProduct extends javax.swing.JFrame {
    private int productPk=0;
    private int totalQuantity=0;

    /**
     * Creates new form ManageProduct
     */
    public ManageProduct() {
        initComponents();
        //setLocationRelativeTo(null);
        setLocation(540,200);
    }
    private void searchProduct(String productSearch){
        DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product WHERE name LIKE '" + productSearch+"%'" );
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("quantity"), rs.getString("price"), rs.getString("description"), rs.getString("category_fk")});

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void getAllCategory(){
        try {
            Connection con= ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from category");
            comboBoxCategory.removeAllItems ();
            while(rs.next()){
                comboBoxCategory.addItem(rs.getString("category_pk")+"-"+rs.getString("name"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private boolean validateFields(String formType){
        if(formType.equals("edit") && !txtName.getText().equals("") && !txtPrice.getText().equals("")&& !txtDescription.getText().equals(""))
        {
            return false;
        }
        else if (formType.equals("new") && !txtName.getText().equals("") && !txtPrice.getText().equals("")&& !txtQuantity.getText().equals(""))
        {
            return false;
        }
        else 
            return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCategory = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchProduct = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        jLabel1.setText("Manage Product");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "Category ID", "Category Name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 590, 377));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, -1, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 324, -1));

        lblQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuantity.setText("Quantity");
        getContentPane().add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, -1, 30));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 324, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Price");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 330, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Description");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, 20));

        txtDescription.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 330, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Category");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, 20));

        comboBoxCategory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 340, 20));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, -1, 20));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, -1, 20));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, -1, 20));

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 510, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Search:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        searchProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductKeyReleased(evt);
            }
        });
        getContentPane().add(searchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 500, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, -30, 1230, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        getAllCategory();
        DefaultTableModel model=(DefaultTableModel) tableProduct.getModel();
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery("Select * from product inner join category on product.category_fk=category.category_pk");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("product_pk"),rs.getString("name"),rs.getString("quantity"),rs.getString("price"),rs.getString("description"),rs.getString("category_fk"),rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void comboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoryActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageProduct().setVisible(true);
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String name=txtName.getText();
        String quantity =txtQuantity.getText();
        String price=txtPrice.getText();
        String description=txtDescription.getText();
        String category=(String) comboBoxCategory.getSelectedItem();
        String categoryId[]= category.split("-",0);
        if(validateFields("new")){
            JOptionPane.showMessageDialog(null,"All Fields are required");
            
        }
        else{
            try {
                Connection con=ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("insert into product(name,quantity,price,description,category_fk)values(?,?,?,?,?)");
                ps.setString(1,name);
                ps.setString(2,quantity);
                ps.setString(3,price);
                ps.setString(4,description);
                ps.setString(5,categoryId[0]);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Product Added Successfully");
                setVisible(false);
                new ManageProduct().setVisible(true);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index =tableProduct.getSelectedRow();
        TableModel model=tableProduct.getModel();
        String id=model.getValueAt(index, 0).toString();
        productPk=Integer.parseInt(id);
        
        String name=model.getValueAt(index, 1).toString();
        txtName.setText(name);
        String quantity=model.getValueAt(index, 2).toString();
        totalQuantity=0;
        lblQuantity.setText("Add Quantity");
        totalQuantity=Integer.parseInt(quantity);
        
        String price=model.getValueAt(index, 3).toString();
        txtPrice.setText(price);
        
        String description=model.getValueAt(index, 4).toString();
        txtDescription.setText(description);
         
        comboBoxCategory.removeAllItems();
        String categoryId=model.getValueAt(index, 5).toString();
        String categoryName=model.getValueAt(index, 6).toString();
        comboBoxCategory.addItem(categoryId +"-"+ categoryName);
          try {
            Connection con= ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from category");
            
            while(rs.next()){
                if(Integer.parseInt(categoryId) !=rs.getInt(1))
                comboBoxCategory.addItem(rs.getString("category_pk")+"-"+rs.getString("name"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
          btnSave.setEnabled(false);
          btnUpdate.setEnabled(true);
    }//GEN-LAST:event_tableProductMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String name=txtName.getText();
        String quantity =txtQuantity.getText();
        String price=txtPrice.getText();
        String description=txtDescription.getText();
        String category=(String) comboBoxCategory.getSelectedItem();
        String categoryId[]= category.split("-",0);
        if(validateFields("edit")){
            JOptionPane.showMessageDialog(null,"All Fields are required");
            
        }
        else{
            try {
                if(!quantity.equals("")){
                    totalQuantity=totalQuantity+Integer.parseInt(quantity);
                }
                Connection con=ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("update product set name=?,quantity=?,price=?,description=?,category_fk=? where product_pk=?");
                ps.setString(1,name);
                ps.setInt(2,totalQuantity);
                ps.setString(3,price);
                ps.setString(4,description);
                ps.setString(5,categoryId[0]);
                ps.setInt(6,productPk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Product Updated Successfully");
                setVisible(false);
                new ManageProduct().setVisible(true);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void searchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductKeyReleased
        // TODO add your handling code here:
        String product=searchProduct.getText();
         searchProduct(product);
    }//GEN-LAST:event_searchProductKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTextField searchProduct;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
