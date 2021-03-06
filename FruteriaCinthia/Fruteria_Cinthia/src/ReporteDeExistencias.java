
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aaron
 */
public class ReporteDeExistencias extends javax.swing.JFrame {

    /**
     * Creates new form ReporteDeExistencias
     */
    Conexion mConexion = new Conexion();
    Producto mProducto = new Producto();
    DefaultTableModel Tabla = new DefaultTableModel();
    int ContadorColumna = 1;
    public ReporteDeExistencias() {
        initComponents();
        DefaultTableModel TablaLimpiar = (DefaultTableModel) TableReporteDeExistencias.getModel();
        int a = TableReporteDeExistencias.getRowCount()-1;
        for(int i = a; i>=0;i--) {
            TablaLimpiar.removeRow(TablaLimpiar.getRowCount()-1);
        }
        
        if (mConexion.con()) {
            ArrayList mArrayList = new ArrayList();
            mArrayList = mConexion.ConsultaTodoProducto();
            String[] Datos = null;
            if (mArrayList != null) {
                if (ContadorColumna == 1) {
                    Tabla.addColumn("ID");
                    Tabla.addColumn("Nombre");
                    Tabla.addColumn("Precio");
                    Tabla.addColumn("Fecha Caducidad");
                    Tabla.addColumn("ID Proveedor");
                    Tabla.addColumn("Cantidad");
                    ContadorColumna = 2;
                }
                for (int i = 0; i < mArrayList.size(); i++) {
                    mProducto = (Producto) mArrayList.get(i);
                    Datos = new String[6];
                    Datos[0] = "" + mProducto.getIDProducto();
                    Datos[1] = mProducto.getNombreProducto();
                    Datos[2] = "" + mProducto.getPrecioProducto();
                    Datos[3] = mProducto.getFechaCaducidad();
                    Datos[4] = "" + mProducto.getProveedor_idProveedor();
                    Datos[5] = "" + mProducto.getCantidadProducto();
                    Tabla.addRow(Datos);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Producto...");
            }
            this.TableReporteDeExistencias = new javax.swing.JTable();
            this.TableReporteDeExistencias.setModel(Tabla);
            this.TableReporteDeExistencias.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TableReporteDeExistencias.getColumnModel().getColumn(1).setPreferredWidth(100);
            this.TableReporteDeExistencias.getColumnModel().getColumn(2).setPreferredWidth(400);
            this.TableReporteDeExistencias.getColumnModel().getColumn(3).setPreferredWidth(600);
            this.TableReporteDeExistencias.getColumnModel().getColumn(4).setPreferredWidth(400);
            this.TableReporteDeExistencias.getColumnModel().getColumn(5).setPreferredWidth(100);
            if (this.TableReporteDeExistencias.getRowCount() > 0) {
                this.TableReporteDeExistencias.setRowSelectionInterval(0, 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }
        mConexion.desconectar();
    }
    
    private void guardaTabla(){
        try {

            String sucursalesCSVFile = "TablaReporteExistencia.csv";
            BufferedWriter mBufferedWriter = new BufferedWriter(new FileWriter(sucursalesCSVFile ));
            
            mBufferedWriter.write("idProducto,Nombre,Precio,Fecha,ID Proveedor,Cantidad");
            mBufferedWriter.newLine(); //inserta nueva linea.
            for (int i = 0 ; i < TableReporteDeExistencias.getRowCount(); i++) //realiza un barrido por filas.
            {
                for(int j = 0 ; j < TableReporteDeExistencias.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    mBufferedWriter.write((String)(TableReporteDeExistencias.getValueAt(i,j)));
                    if (j < TableReporteDeExistencias.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
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
        TableReporteDeExistencias = new javax.swing.JTable();
        BTNSalir = new javax.swing.JButton();
        BTNGuardarReporteExistencia = new javax.swing.JButton();
        BTNReporteProductos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableReporteDeExistencias.setModel(Tabla);
        jScrollPane1.setViewportView(TableReporteDeExistencias);

        BTNSalir.setText("Salir");
        BTNSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalirActionPerformed(evt);
            }
        });

        BTNGuardarReporteExistencia.setText("Guardar Reporte");
        BTNGuardarReporteExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGuardarReporteExistenciaActionPerformed(evt);
            }
        });

        BTNReporteProductos.setText("Ver Reporte Detallado");
        BTNReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNReporteProductosActionPerformed(evt);
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
                    .addComponent(BTNGuardarReporteExistencia)
                    .addComponent(BTNReporteProductos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNGuardarReporteExistencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNSalir)
                .addGap(31, 31, 31)
                .addComponent(BTNReporteProductos)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNSalirActionPerformed

    private void BTNGuardarReporteExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGuardarReporteExistenciaActionPerformed
        // TODO add your handling code here:
        ReporteDeExistencias mReporte = new ReporteDeExistencias();
        mReporte.guardaTabla();
    }//GEN-LAST:event_BTNGuardarReporteExistenciaActionPerformed

    private void BTNReporteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNReporteProductosActionPerformed
        // TODO add your handling code here:
        String path = "/Users/macbookair13/Documents/RepositorioTengoLaMenteEnBlanco/FruteriaCinthia/Fruteria_Cinthia/src/Existencias.jasper";
        JasperReport jr = null;
        
        try {
            //jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, mConexion.conectare());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle(path);
            //this.dispose();
        } catch (JRException ex) {
            Logger.getLogger(ReporteDeExistencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTNReporteProductosActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteDeExistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteDeExistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteDeExistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteDeExistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteDeExistencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNGuardarReporteExistencia;
    private javax.swing.JButton BTNReporteProductos;
    private javax.swing.JButton BTNSalir;
    private javax.swing.JTable TableReporteDeExistencias;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
