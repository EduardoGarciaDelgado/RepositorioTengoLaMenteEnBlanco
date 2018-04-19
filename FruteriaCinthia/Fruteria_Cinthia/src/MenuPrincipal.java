/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookair
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Principal
     */
    public MenuPrincipal() {
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

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCatalogoProductos = new javax.swing.JMenu();
        MenuAltaProductos = new javax.swing.JMenuItem();
        MenuBajaProductos = new javax.swing.JMenuItem();
        MenuCambiosProductos = new javax.swing.JMenuItem();
        MenuConsultasProductos = new javax.swing.JMenuItem();
        MenuCatalogoProveedores = new javax.swing.JMenu();
        MenuAltaProveedor = new javax.swing.JMenuItem();
        MenuBajaProveedor = new javax.swing.JMenuItem();
        MenuCambiosProveedor = new javax.swing.JMenuItem();
        MenuConsultasProveedor = new javax.swing.JMenuItem();
        MenuReportes = new javax.swing.JMenu();
        ReporteExistencia = new javax.swing.JMenuItem();
        ReporteVenta = new javax.swing.JMenuItem();
        MenuCompras = new javax.swing.JMenu();
        MenuVentas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logofruteria.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel2.setMinimumSize(new java.awt.Dimension(500, 500));

        MenuCatalogoProductos.setText("CATALOGO PRODUCTOS");

        MenuAltaProductos.setText("ALTA PRODUCTOS");
        MenuAltaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAltaProductosActionPerformed(evt);
            }
        });
        MenuCatalogoProductos.add(MenuAltaProductos);

        MenuBajaProductos.setText("BAJA PRODUCTOS");
        MenuBajaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBajaProductosActionPerformed(evt);
            }
        });
        MenuCatalogoProductos.add(MenuBajaProductos);

        MenuCambiosProductos.setText("CAMBIOS PRODUCTOS");
        MenuCambiosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCambiosProductosActionPerformed(evt);
            }
        });
        MenuCatalogoProductos.add(MenuCambiosProductos);

        MenuConsultasProductos.setText("CONSULTAS PRODUCTOS");
        MenuConsultasProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultasProductosActionPerformed(evt);
            }
        });
        MenuCatalogoProductos.add(MenuConsultasProductos);

        jMenuBar1.add(MenuCatalogoProductos);

        MenuCatalogoProveedores.setText("CATALOGO PROVEEDORES");

        MenuAltaProveedor.setText("ALTA PROVEEDOR");
        MenuAltaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAltaProveedorActionPerformed(evt);
            }
        });
        MenuCatalogoProveedores.add(MenuAltaProveedor);

        MenuBajaProveedor.setText("BAJA PROVEEDOR");
        MenuBajaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBajaProveedorActionPerformed(evt);
            }
        });
        MenuCatalogoProveedores.add(MenuBajaProveedor);

        MenuCambiosProveedor.setText("CAMBIOS PROVEEDOR");
        MenuCambiosProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCambiosProveedorActionPerformed(evt);
            }
        });
        MenuCatalogoProveedores.add(MenuCambiosProveedor);

        MenuConsultasProveedor.setText("CONSULTAS PROVEEDOR");
        MenuConsultasProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultasProveedorActionPerformed(evt);
            }
        });
        MenuCatalogoProveedores.add(MenuConsultasProveedor);

        jMenuBar1.add(MenuCatalogoProveedores);

        MenuReportes.setText("REPORTES");

        ReporteExistencia.setText("REPORTE EXISTENCIA");
        ReporteExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteExistenciaActionPerformed(evt);
            }
        });
        MenuReportes.add(ReporteExistencia);

        ReporteVenta.setText("REPORTE VENTA");
        ReporteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteVentaActionPerformed(evt);
            }
        });
        MenuReportes.add(ReporteVenta);

        jMenuBar1.add(MenuReportes);

        MenuCompras.setText("COMPRAS");
        jMenuBar1.add(MenuCompras);

        MenuVentas.setText("VENTAS");
        jMenuBar1.add(MenuVentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAltaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAltaProductosActionPerformed
        // TODO add your handling code here:
        AltaProductos mAltaProductos = new AltaProductos();
        mAltaProductos.show();
    }//GEN-LAST:event_MenuAltaProductosActionPerformed

    private void MenuBajaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBajaProductosActionPerformed
        // TODO add your handling code here:
        BajaProductos mBajaProductos = new BajaProductos();
        mBajaProductos.show();
    }//GEN-LAST:event_MenuBajaProductosActionPerformed

    private void MenuCambiosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCambiosProductosActionPerformed
        // TODO add your handling code here:
        CambiosProductos FRMCambiosProductos = new CambiosProductos();
        FRMCambiosProductos.setVisible(true);
    }//GEN-LAST:event_MenuCambiosProductosActionPerformed

    private void MenuBajaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBajaProveedorActionPerformed
        // TODO add your handling code here:
        BajaProveedor FRMBajaProveedor = new BajaProveedor();
        FRMBajaProveedor.setVisible(true);
    }//GEN-LAST:event_MenuBajaProveedorActionPerformed

    private void MenuCambiosProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCambiosProveedorActionPerformed
        // TODO add your handling code here:
        CambiosProveedor FRMCambiosProveedor = new CambiosProveedor();
        FRMCambiosProveedor.setVisible(true);
    }//GEN-LAST:event_MenuCambiosProveedorActionPerformed

    private void MenuConsultasProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultasProveedorActionPerformed
        // TODO add your handling code here:
        ConsultaProveedor FRMConsultaProveedor = new ConsultaProveedor();
        FRMConsultaProveedor.setVisible(true);
    }//GEN-LAST:event_MenuConsultasProveedorActionPerformed

    private void MenuAltaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAltaProveedorActionPerformed
        // TODO add your handling code here:
        AltaProveedores FRMAltaProveedores = new AltaProveedores();
        FRMAltaProveedores.setVisible(true);
    }//GEN-LAST:event_MenuAltaProveedorActionPerformed

    private void ReporteExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteExistenciaActionPerformed
        // TODO add your handling code here:
       ReporteDeExistencias FRMReporteDeExistencias = new ReporteDeExistencias();
       FRMReporteDeExistencias.setVisible(true);
    }//GEN-LAST:event_ReporteExistenciaActionPerformed

    private void ReporteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteVentaActionPerformed
        // TODO add your handling code here:
        ReporteDeVentas FRMReporteDeVentas = new ReporteDeVentas();
        FRMReporteDeVentas.setVisible(true);
    }//GEN-LAST:event_ReporteVentaActionPerformed

    private void MenuConsultasProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultasProductosActionPerformed
        // TODO add your handling code here:
        ConsultaProductos mConsultaProductos = new ConsultaProductos();
        mConsultaProductos.show();
    }//GEN-LAST:event_MenuConsultasProductosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAltaProductos;
    private javax.swing.JMenuItem MenuAltaProveedor;
    private javax.swing.JMenuItem MenuBajaProductos;
    private javax.swing.JMenuItem MenuBajaProveedor;
    private javax.swing.JMenuItem MenuCambiosProductos;
    private javax.swing.JMenuItem MenuCambiosProveedor;
    private javax.swing.JMenu MenuCatalogoProductos;
    private javax.swing.JMenu MenuCatalogoProveedores;
    private javax.swing.JMenu MenuCompras;
    private javax.swing.JMenuItem MenuConsultasProductos;
    private javax.swing.JMenuItem MenuConsultasProveedor;
    private javax.swing.JMenu MenuReportes;
    private javax.swing.JMenu MenuVentas;
    private javax.swing.JMenuItem ReporteExistencia;
    private javax.swing.JMenuItem ReporteVenta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
