
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
 * @author Aaron
 */
public class ReporteDeVentas extends javax.swing.JFrame {

    /**
     * Creates new form ReporteDeVentas
     */
    Conexion mConexion = new Conexion();
    Venta mVenta = new Venta();
    DefaultTableModel Tabla = new DefaultTableModel();
    int ContadorColumna = 1;
    public ReporteDeVentas() {
        initComponents();
        DefaultTableModel TablaLimpiar = (DefaultTableModel) TableReporteDeVentas.getModel();
        int a = TableReporteDeVentas.getRowCount()-1;
        for(int i = a; i>=0;i--) {
            TablaLimpiar.removeRow(TablaLimpiar.getRowCount()-1);
        }
        
        if (mConexion.con()) {
            ArrayList mArrayList = new ArrayList();
            mArrayList = mConexion.ConsultaTodosIdVenta();
            String[] Datos = null;
            if (mArrayList != null) {
                if (ContadorColumna == 1) {
                    Tabla.addColumn("ID");
                    Tabla.addColumn("Fecha");
                    Tabla.addColumn("Total");
                    ContadorColumna = 2;
                }
                for (int i = 0; i < mArrayList.size(); i++) {
                    mVenta = (Venta) mArrayList.get(i);
                    Datos = new String[3];
                    Datos[0] = "" + mVenta.getIdVenta();
                    Datos[1] = mVenta.getFechaVenta();
                    Datos[2] = "" + mVenta.getPrecioTotalVenta();
                    Tabla.addRow(Datos);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe esa Venta...");
            }
            this.TableReporteDeVentas = new javax.swing.JTable();
            this.TableReporteDeVentas.setModel(Tabla);
            this.TableReporteDeVentas.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TableReporteDeVentas.getColumnModel().getColumn(1).setPreferredWidth(100);
            this.TableReporteDeVentas.getColumnModel().getColumn(2).setPreferredWidth(400);
            if (this.TableReporteDeVentas.getRowCount() > 0) {
                this.TableReporteDeVentas.setRowSelectionInterval(0, 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }
        mConexion.desconectar();
    }
    
    private void guardaTabla(){
        try {

            String sucursalesCSVFile = "TablaReporteVentas.csv";
            BufferedWriter mBufferedWriter = new BufferedWriter(new FileWriter(sucursalesCSVFile ));
            
            mBufferedWriter.write("idventa,FechaVenta,PrecioTotalVenta");
            mBufferedWriter.newLine(); //inserta nueva linea.
            for (int i = 0 ; i < TableReporteDeVentas.getRowCount(); i++) //realiza un barrido por filas.
            {
                for(int j = 0 ; j < TableReporteDeVentas.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    mBufferedWriter.write((String)(TableReporteDeVentas.getValueAt(i,j)));
                    if (j < TableReporteDeVentas.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        mBufferedWriter.write(",");
                    }
                }
                mBufferedWriter.newLine(); //inserta nueva linea.
            }

            mBufferedWriter.close(); //cierra archivo!
            JOptionPane.showMessageDialog(null, "Reporte guardado correctamente");
        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al guardar el reporte" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableReporteDeVentas = new javax.swing.JTable();
        BTNSalir = new javax.swing.JButton();
        BTNGuardarReporteVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableReporteDeVentas.setModel(Tabla);
        jScrollPane1.setViewportView(TableReporteDeVentas);

        BTNSalir.setText("Salir");
        BTNSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalirActionPerformed(evt);
            }
        });

        BTNGuardarReporteVentas.setText("Guardar Reporte");
        BTNGuardarReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGuardarReporteVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNSalir)
                    .addComponent(BTNGuardarReporteVentas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNGuardarReporteVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNSalir)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSalirActionPerformed

    private void BTNGuardarReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGuardarReporteVentasActionPerformed
        // TODO add your handling code here:
        ReporteDeVentas mReporte = new ReporteDeVentas();
        mReporte.guardaTabla();
    }//GEN-LAST:event_BTNGuardarReporteVentasActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteDeVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteDeVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNGuardarReporteVentas;
    private javax.swing.JButton BTNSalir;
    private javax.swing.JTable TableReporteDeVentas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
