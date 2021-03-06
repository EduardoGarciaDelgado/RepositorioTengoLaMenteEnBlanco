
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Cinthia
 */
public class BajaProveedor extends javax.swing.JFrame {

    /**
     * Creates new form FRM_BajaProveedor
     */
    Conexion mConexion = new Conexion();
    Proveedor mProveedor = new Proveedor();
    DefaultTableModel Tabla = new DefaultTableModel(); int ContadorColumna = 1;
    public BajaProveedor() {
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
        TXTIdProveedor = new javax.swing.JTextField();
        BTNBuscar = new javax.swing.JButton();
        BTNeliminar = new javax.swing.JButton();
        BTNsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLDetallesProveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese el ID del Proveedor:");

        BTNBuscar.setText("Buscar");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

        BTNeliminar.setText("Eliminar");
        BTNeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNeliminarActionPerformed(evt);
            }
        });

        BTNsalir.setText("Salir");
        BTNsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNsalirActionPerformed(evt);
            }
        });

        TBLDetallesProveedor.setModel(Tabla);
        jScrollPane1.setViewportView(TBLDetallesProveedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TXTIdProveedor))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BTNBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTNeliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNeliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNsalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNsalirActionPerformed

    private void BTNeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNeliminarActionPerformed
        // TODO add your handling code here:
        try {
        if (mConexion.con())
        {
            mProveedor = new Proveedor();
            mProveedor.setIdProveedor(Integer.parseInt(this.TXTIdProveedor.getText()));
            if (mConexion.BajaProveedor(mProveedor))
            {
                JOptionPane.showMessageDialog(null,"Proveedor eliminado con éxito");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al eliminar Proveedor");
            }
            mConexion.desconectar();
        }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"POR FAVOR, LLENE EL CAMPO");
        }
    }//GEN-LAST:event_BTNeliminarActionPerformed

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        // TODO add your handling code here:
        try {
        if(mConexion.con()){
            Proveedor mProveedor = mConexion.ConsultaProveedor(Integer.parseInt(this.TXTIdProveedor.getText()));
            String [] Datos;
            
        
            if (mProveedor != null) {
                if(ContadorColumna == 1) {
                Tabla.addColumn("IdProveedor");
                Tabla.addColumn("NombreProveedor");
                ContadorColumna=2;
                }
                       
                Datos = new String[2];
                
                Datos[0] = ""+ mProveedor.getIdProveedor();
                Datos[1] = mProveedor.getNombre();
            
                Tabla.addRow(Datos);
            } else {
                // No hay datos
                JOptionPane.showMessageDialog(null,"No existe ese Proveedor...");
            }
            this.TBLDetallesProveedor = new javax.swing.JTable();
            this.TBLDetallesProveedor.setModel(Tabla);
            this.TBLDetallesProveedor.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLDetallesProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            if (this.TBLDetallesProveedor.getRowCount() > 0) {
                this.TBLDetallesProveedor.setRowSelectionInterval(0, 0);
            }
            } else {
                JOptionPane.showMessageDialog(null,"Error al consultar");
                }
            mConexion.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"POR FAVOR, LLENE EL CAMPO");
        }
    }//GEN-LAST:event_BTNBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(BajaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNeliminar;
    private javax.swing.JButton BTNsalir;
    private javax.swing.JTable TBLDetallesProveedor;
    private javax.swing.JTextField TXTIdProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
