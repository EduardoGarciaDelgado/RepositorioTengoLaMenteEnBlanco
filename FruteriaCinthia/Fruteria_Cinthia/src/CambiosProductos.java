
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookair
 */
public class CambiosProductos extends javax.swing.JFrame {

    /**
     * Creates new form CambiosProductos
     */
    Conexion mConexion = new Conexion();
    Producto mProducto = new Producto();
    DefaultTableModel Tabla = new DefaultTableModel(); int ContadorColumna = 1;
    public CambiosProductos() {
        initComponents();
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
        TXTProductoModificar = new javax.swing.JTextField();
        BTNModificar = new javax.swing.JButton();
        BTNSalir = new javax.swing.JButton();
        BTNBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComBoxAnyo = new javax.swing.JComboBox<>();
        ComBoxMes = new javax.swing.JComboBox<>();
        ComBoxDia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TXTNombreProducto = new javax.swing.JTextField();
        TXTPrecioCompraProducto = new javax.swing.JTextField();
        TXTIDProveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TXTCantidadProducto = new javax.swing.JTextField();
        TXTPrecioProducto1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID Producto");

        BTNModificar.setText("Modificar");
        BTNModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNModificarActionPerformed(evt);
            }
        });

        BTNSalir.setText("Salir");
        BTNSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalirActionPerformed(evt);
            }
        });

        BTNBuscar.setText("Buscar");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

        TBLProductos.setModel(Tabla);
        jScrollPane1.setViewportView(TBLProductos);

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio Venta:");

        jLabel4.setText("Fecha Estimada de Caducidad");

        jLabel5.setText("Proveedor");

        ComBoxAnyo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032" }));
        ComBoxAnyo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBoxAnyoActionPerformed(evt);
            }
        });

        ComBoxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        ComBoxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel6.setText("Año");

        jLabel7.setText("Mes");

        jLabel8.setText("Dia");

        jLabel9.setText("Cantidad");

        TXTCantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCantidadProductoActionPerformed(evt);
            }
        });

        TXTPrecioProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTPrecioProducto1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Precio Compra:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TXTProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(TXTPrecioCompraProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNModificar)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComBoxAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8))
                            .addComponent(ComBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9)
                                .addComponent(TXTIDProveedor))))
                    .addComponent(jLabel10)
                    .addComponent(TXTPrecioProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(TXTPrecioProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTPrecioCompraProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComBoxAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComBoxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTIDProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNModificar))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalirActionPerformed
       // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSalirActionPerformed

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        // TODO add your handling code here:
        if(mConexion.con()){
            Producto mProducto = mConexion.consultarProducto(Integer.parseInt(this.TXTProductoModificar.getText()));
            String [] Datos;
            
        
            if (mProducto != null) {
                if(ContadorColumna == 1) {
                Tabla.addColumn("ID");
                Tabla.addColumn("Nombre");
                Tabla.addColumn("Precio Compra");
                Tabla.addColumn("Precio Venta");
                Tabla.addColumn("Fecha Caducidad");
                Tabla.addColumn("ID Proveedor");
                Tabla.addColumn("Cantidad");
                ContadorColumna=2;
                }
                       
                Datos = new String[7];
                
                Datos[0] = ""+ mProducto.getIDProducto();
                Datos[1] = mProducto.getNombreProducto();
                Datos[2] = "" + mProducto.getPrecioProducto();
                Datos[3] = "" + mProducto.getPrecioVentaProducto();
                Datos[4] = mProducto.getFechaCaducidad();
                Datos[5] = "" + mProducto.getProveedor_idProveedor();
                Datos[6] = "" + mProducto.getCantidadProducto();
                
                TXTNombreProducto.setText(mProducto.getNombreProducto());
                TXTPrecioCompraProducto.setText(""+mProducto.getPrecioProducto());
                TXTPrecioProducto1.setText(""+mProducto.getPrecioVentaProducto());
                TXTIDProveedor.setText(mProducto.getProveedor_idProveedor());
                TXTCantidadProducto.setText(""+mProducto.getCantidadProducto());
                Tabla.addRow(Datos);
            } else {
                // No hay datos
                JOptionPane.showMessageDialog(null,"No existe ese Producto...");
            }
            this.TBLProductos = new javax.swing.JTable();
            this.TBLProductos.setModel(Tabla);
            this.TBLProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            this.TBLProductos.getColumnModel().getColumn(2).setPreferredWidth(400);
            this.TBLProductos.getColumnModel().getColumn(3).setPreferredWidth(600);
            this.TBLProductos.getColumnModel().getColumn(4).setPreferredWidth(400);
            this.TBLProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            this.TBLProductos.getColumnModel().getColumn(6).setPreferredWidth(100);
            if (this.TBLProductos.getRowCount() > 0) {
                this.TBLProductos.setRowSelectionInterval(0, 0);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Error al consultar");
                }
            mConexion.desconectar();
            
    }//GEN-LAST:event_BTNBuscarActionPerformed

    private void ComBoxAnyoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBoxAnyoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComBoxAnyoActionPerformed

    private void TXTCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCantidadProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCantidadProductoActionPerformed

    private void BTNModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNModificarActionPerformed
        // TODO add your handling code here:
        Producto nProducto = new Producto();
        mProducto.setIDProducto(Integer.parseInt(this.TXTProductoModificar.getText()));
        
        String Anyo = (String) ComBoxAnyo.getSelectedItem();
        String Mes = (String) ComBoxMes.getSelectedItem();
        String Dia = (String) ComBoxDia.getSelectedItem();
        String Fecha = Anyo + "-" + Mes + "-" + Dia;
        
        nProducto.setNombreProducto(this.TXTNombreProducto.getText());
        nProducto.setPrecioVentaProducto(Float.parseFloat(this.TXTPrecioProducto1.getText()));
        nProducto.setPrecioProducto(Float.parseFloat(this.TXTPrecioCompraProducto.getText()));
        nProducto.setFechaCaducidad(Fecha);
        nProducto.setProveedor_idProveedor(this.TXTIDProveedor.getText());
        nProducto.setCantidadProducto(Float.parseFloat(this.TXTCantidadProducto.getText()));
        if( (Float.parseFloat(TXTPrecioCompraProducto.getText())) < (Float.parseFloat(TXTPrecioProducto1.getText())) ) {
        if (mConexion.con())
            {
                if (mConexion.modificarProducto(mProducto, nProducto))
                {
                    JOptionPane.showMessageDialog(null,"El PRODUCTO fue modificado con éxito");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error al modificar el PRODUCTO");
                }
                mConexion.desconectar();
            }
        TXTNombreProducto.setText("");
        TXTPrecioProducto1.setText("");
        TXTPrecioCompraProducto.setText("");
        TXTIDProveedor.setText("");
        TXTCantidadProducto.setText("");
        }
        else {
            JOptionPane.showMessageDialog(null,"EL PRECIO DE VENTA TIENE QUE SER MAYOR AL PRECIO DE COMPRA");
        }
    }//GEN-LAST:event_BTNModificarActionPerformed

    private void TXTPrecioProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTPrecioProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTPrecioProducto1ActionPerformed

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
            java.util.logging.Logger.getLogger(CambiosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiosProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNModificar;
    private javax.swing.JButton BTNSalir;
    private javax.swing.JComboBox<String> ComBoxAnyo;
    private javax.swing.JComboBox<String> ComBoxDia;
    private javax.swing.JComboBox<String> ComBoxMes;
    private javax.swing.JTable TBLProductos;
    private javax.swing.JTextField TXTCantidadProducto;
    private javax.swing.JTextField TXTIDProveedor;
    private javax.swing.JTextField TXTNombreProducto;
    private javax.swing.JTextField TXTPrecioCompraProducto;
    private javax.swing.JTextField TXTPrecioProducto1;
    private javax.swing.JTextField TXTProductoModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
