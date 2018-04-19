
import java.util.ArrayList;
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
public class ConsultaProveedor extends javax.swing.JFrame {

    /**
     * Creates new form FRM_ConsultarProveedor
     */
    DefaultTableModel Tabla = new DefaultTableModel();
    Conexion mConexion = new Conexion();
    Proveedor mProveedor = new Proveedor();
    int ContadorColumna = 1;
    public ConsultaProveedor() {
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

        TXTIdProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BTNSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLDetalleProveedor = new javax.swing.JTable();
        BTNBuscarUno = new javax.swing.JButton();
        BTNBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese el ID del proveedor:");

        BTNSalir.setText("Salir");
        BTNSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalirActionPerformed(evt);
            }
        });

        TBLDetalleProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID_Proveedor", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TBLDetalleProveedor);

        BTNBuscarUno.setText("Buscar por ID");
        BTNBuscarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarUnoActionPerformed(evt);
            }
        });

        BTNBuscar.setText("Buscar Todo");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TXTIdProveedor)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNSalir)
                    .addComponent(BTNBuscarUno)
                    .addComponent(BTNBuscar))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXTIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNBuscarUno))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(BTNSalir)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSalirActionPerformed

    private void BTNBuscarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarUnoActionPerformed
        // TODO add your handling code here:
        DefaultTableModel TablaLimpiar = (DefaultTableModel) TBLDetalleProveedor.getModel();
        int a = TBLDetalleProveedor.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            TablaLimpiar.removeRow(TablaLimpiar.getRowCount() - 1);
        }
        if (mConexion.con()) {
            Proveedor mProveedor = mConexion.ConsultaProveedor(Integer.parseInt(this.TXTIdProveedor.getText()));
            String[] Datos;

            if (mProveedor != null) {
                Tabla.addColumn("IdProveedor");
                Tabla.addColumn("NombreProveedor");

                Datos = new String[2];

                Datos[0] = "" + mProveedor.getIdProveedor();
                Datos[1] = mProveedor.getNombre();

                Tabla.addRow(Datos);
            } else {
                // No hay datos
                JOptionPane.showMessageDialog(null, "No existe ese Proveedor...");
            }
            this.TBLDetalleProveedor = new javax.swing.JTable();
            this.TBLDetalleProveedor.setModel(Tabla);
            this.TBLDetalleProveedor.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLDetalleProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            if (this.TBLDetalleProveedor.getRowCount() > 0) {
                this.TBLDetalleProveedor.setRowSelectionInterval(0, 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }
        mConexion.desconectar();
    }//GEN-LAST:event_BTNBuscarUnoActionPerformed

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel TablaLimpiar = (DefaultTableModel) TBLDetalleProveedor.getModel();
        int a = TBLDetalleProveedor.getRowCount()-1;
        for(int i = a; i>=0;i--) {
            TablaLimpiar.removeRow(TablaLimpiar.getRowCount()-1);
        }
        
        if (mConexion.con()) {
            ArrayList mArrayList = new ArrayList();
            mArrayList = mConexion.ConsultaTodoProveedor();
            String[] Datos = null;
            if (mArrayList != null) {
                if (ContadorColumna == 1) {
                    Tabla.addColumn("IdProveedor");
                    Tabla.addColumn("NombreProveedor");
                    ContadorColumna = 2;
                }
                for (int i = 0; i < mArrayList.size(); i++) {
                    mProveedor = (Proveedor) mArrayList.get(i);
                    Datos = new String[2];
                    Datos[0] = "" + mProveedor.getIdProveedor();
                    Datos[1] = mProveedor.getNombre();
                    Tabla.addRow(Datos);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Proveedor...");
            }
            this.TBLDetalleProveedor = new javax.swing.JTable();
            this.TBLDetalleProveedor.setModel(Tabla);
            this.TBLDetalleProveedor.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLDetalleProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            if (this.TBLDetalleProveedor.getRowCount() > 0) {
                this.TBLDetalleProveedor.setRowSelectionInterval(0, 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }
        mConexion.desconectar();
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
            java.util.logging.Logger.getLogger(ConsultaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscar;
    private javax.swing.JButton BTNBuscarUno;
    private javax.swing.JButton BTNSalir;
    private javax.swing.JTable TBLDetalleProveedor;
    private javax.swing.JTextField TXTIdProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
