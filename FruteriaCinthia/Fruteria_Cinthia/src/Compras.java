
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marti
 */
public class Compras extends javax.swing.JFrame {

    /**
     * Creates new form Compras
     */
    float TotalCompleto = 0;
    float TotalTemporal = 0;
    int RegistroCompra = 0;
    float ResultadoCompraTotal = 0;
    float CantidadNueva = 0;
    Conexion mConexion = new Conexion();
    Compra mCompra = new Compra();
    DetalleCompra mDetalleCompra = new DetalleCompra();
    Producto mProducto = new Producto();
    Proveedor mProveedor = new Proveedor();
    DefaultTableModel Tabla = new DefaultTableModel();
    DefaultTableModel TablaProveedores = new DefaultTableModel();
    Calendar fecha = new GregorianCalendar();
    int ContadorColumna = 1; int ContadorColumnaProveedor = 1;
    
    public Compras() {
        initComponents();
        DefaultTableModel TablaLimpiar2 = (DefaultTableModel) TBLProveedores.getModel();
        int a = TBLProveedores.getRowCount()-1;
        for(int i = a; i>=0;i--) {
            TablaLimpiar2.removeRow(TablaLimpiar2.getRowCount()-1);
        }
        
        if (mConexion.con()) {
            ArrayList mArrayListProveedores = new ArrayList();
            mArrayListProveedores = mConexion.ConsultaTodoProveedor();
            String[] Datos = null;
            if (mArrayListProveedores != null) {
                if (ContadorColumnaProveedor == 1) {
                    TablaProveedores.addColumn("IdProveedor");
                    TablaProveedores.addColumn("NombreProveedor");
                    ContadorColumnaProveedor = 2;
                }
                for (int i = 0; i < mArrayListProveedores.size(); i++) {
                    mProveedor = (Proveedor) mArrayListProveedores.get(i);
                    Datos = new String[2];
                    Datos[0] = "" + mProveedor.getIdProveedor();
                    Datos[1] = mProveedor.getNombre();
                    TablaProveedores.addRow(Datos);
                }
    
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Proveedor...");
            }
            this.TBLProveedores = new javax.swing.JTable();
            this.TBLProveedores.setModel(TablaProveedores);
            this.TBLProveedores.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLProveedores.getColumnModel().getColumn(1).setPreferredWidth(100);
            if (this.TBLProveedores.getRowCount() > 0) {
                this.TBLProveedores.setRowSelectionInterval(0, 0);
            }
            
        } 
        //AQUI AGREGO COMPRA
                String FechaActual = "" + fecha.get(Calendar.YEAR) +"-"+ fecha.get(Calendar.MONTH) +"-"+ fecha.get(Calendar.DAY_OF_MONTH);
                System.out.println();
                mCompra.setFechaCompra(FechaActual);
                mCompra.setPrecioTotalCompra(ResultadoCompraTotal);
                
                
                
                if(mConexion.con()) {
                    if (mConexion.AltaCompra(mCompra))
                    {
                        JOptionPane.showMessageDialog(null,"LISTO PARA GENERAR COMPRA");
                        
                        RegistroCompra = (mConexion.ConsultaIDCompra());
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Error al guardar Compra");
                    }
                }
        //------------------
        
        else {
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }
       
        mConexion.desconectar();
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
        TBLCompras = new javax.swing.JTable();
        BTNSalir = new javax.swing.JButton();
        TXTProductoBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BTNBuscarID = new javax.swing.JButton();
        BTNBuscarTodo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTCantidadNueva = new javax.swing.JTextField();
        TXTGuardarCompra = new javax.swing.JButton();
        TXTFinalizarCompra = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBLProveedores = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        LBLNombreProducto1 = new javax.swing.JLabel();
        LBLTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LBLProveedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LBLPrecio = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LBLFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        TBLCompras.setModel(Tabla);
        jScrollPane1.setViewportView(TBLCompras);

        BTNSalir.setText("Salir");
        BTNSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Producto");

        BTNBuscarID.setText("Seleccionar por ID");
        BTNBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarIDActionPerformed(evt);
            }
        });

        BTNBuscarTodo.setText("Buscar Todo");
        BTNBuscarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarTodoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Cantidad a Añadir");

        TXTCantidadNueva.setText("0.0");
        TXTCantidadNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCantidadNuevaActionPerformed(evt);
            }
        });

        TXTGuardarCompra.setText("Guardar Compra");
        TXTGuardarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTGuardarCompraActionPerformed(evt);
            }
        });

        TXTFinalizarCompra.setText("Finalizar Compra");
        TXTFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTFinalizarCompraActionPerformed(evt);
            }
        });

        TBLProveedores.setModel(TablaProveedores);
        jScrollPane2.setViewportView(TBLProveedores);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setText("TOTAL:");

        LBLNombreProducto1.setText("******************************");

        LBLTotal.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        LBLTotal.setText("0.0");

        jLabel4.setText("Proveedor:");

        LBLProveedor.setText("******************************");

        jLabel6.setText("Precio");

        LBLPrecio.setText("******************************");

        jLabel7.setText("Fecha");

        LBLFecha.setText("******************************");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNBuscarTodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNBuscarID)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LBLPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(LBLFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44)
                                .addComponent(TXTProductoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TXTGuardarCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBLNombreProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTCantidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBLProveedor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26)
                        .addComponent(LBLTotal)
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTFinalizarCompra)
                            .addComponent(BTNSalir))))
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNBuscarTodo)
                    .addComponent(BTNBuscarID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TXTProductoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(LBLPrecio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(LBLFecha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(LBLNombreProducto1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TXTCantidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(LBLProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LBLTotal)
                    .addComponent(TXTFinalizarCompra)
                    .addComponent(TXTGuardarCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalirActionPerformed
        dispose();
    }//GEN-LAST:event_BTNSalirActionPerformed

    private void BTNBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarIDActionPerformed
        // TODO add your handling code here:
        DefaultTableModel TablaLimpiar = (DefaultTableModel) TBLCompras.getModel();
        int a = TBLCompras.getRowCount()-1;
        for(int i = a; i>=0;i--) {
            TablaLimpiar.removeRow(TablaLimpiar.getRowCount()-1);
        }
            
        if(mConexion.con()){
            Producto mProducto = mConexion.consultarProducto(Integer.parseInt(this.TXTProductoBuscar.getText()));
            String [] Datos;
            
        
            if (mProducto != null) {
                if(ContadorColumna == 1) {
                Tabla.addColumn("ID");
                Tabla.addColumn("Nombre");
                Tabla.addColumn("Precio");
                Tabla.addColumn("Fecha Caducidad");
                Tabla.addColumn("ID Proveedor");
                Tabla.addColumn("Cantidad");
                ContadorColumna=2;
                }
                       
                Datos = new String[6];
                
                Datos[0] = ""+ mProducto.getIDProducto();
                Datos[1] = mProducto.getNombreProducto();
                Datos[2] = "" + mProducto.getPrecioProducto();
                Datos[3] = mProducto.getFechaCaducidad();
                Datos[4] = "" + mProducto.getProveedor_idProveedor();
                Datos[5] = "" + mProducto.getCantidadProducto();
                
                LBLNombreProducto1.setText(mProducto.getNombreProducto());
                LBLProveedor.setText(""+mProducto.getProveedor_idProveedor());
                LBLPrecio.setText(""+mProducto.getPrecioProducto());
                LBLFecha.setText(""+mProducto.getFechaCaducidad());
                                         
                Tabla.addRow(Datos);
            } else {
                // No hay datos
                JOptionPane.showMessageDialog(null,"No existe ese Producto...");
            }
            this.TBLCompras = new javax.swing.JTable();
            this.TBLCompras.setModel(Tabla);
            this.TBLCompras.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLCompras.getColumnModel().getColumn(1).setPreferredWidth(100);
            this.TBLCompras.getColumnModel().getColumn(2).setPreferredWidth(400);
            this.TBLCompras.getColumnModel().getColumn(3).setPreferredWidth(600);
            this.TBLCompras.getColumnModel().getColumn(4).setPreferredWidth(400);
            this.TBLCompras.getColumnModel().getColumn(5).setPreferredWidth(100);
            if (this.TBLCompras.getRowCount() > 0) {
                this.TBLCompras.setRowSelectionInterval(0, 0);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Error al consultar");
                }
           mConexion.desconectar();
    }//GEN-LAST:event_BTNBuscarIDActionPerformed

    private void BTNBuscarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarTodoActionPerformed
        // TODO add your handling code here:

        DefaultTableModel TablaLimpiar = (DefaultTableModel) TBLCompras.getModel();
        int a = TBLCompras.getRowCount()-1;
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
                    
                    LBLNombreProducto1.setText("******************************");
                    LBLProveedor.setText("******************************");
                    LBLPrecio.setText("******************************");
                    LBLFecha.setText("******************************");
                    
                    Tabla.addRow(Datos);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Producto...");
            }
            this.TBLCompras = new javax.swing.JTable();
            this.TBLCompras.setModel(Tabla);
            this.TBLCompras.getColumnModel().getColumn(0).setPreferredWidth(50);
            this.TBLCompras.getColumnModel().getColumn(1).setPreferredWidth(100);
            this.TBLCompras.getColumnModel().getColumn(2).setPreferredWidth(400);
            this.TBLCompras.getColumnModel().getColumn(3).setPreferredWidth(600);
            this.TBLCompras.getColumnModel().getColumn(4).setPreferredWidth(400);
            this.TBLCompras.getColumnModel().getColumn(5).setPreferredWidth(100);
            if (this.TBLCompras.getRowCount() > 0) {
                this.TBLCompras.setRowSelectionInterval(0, 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al consultar");
        }
        mConexion.desconectar();
    }//GEN-LAST:event_BTNBuscarTodoActionPerformed

    private void TXTCantidadNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCantidadNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCantidadNuevaActionPerformed

    private void TXTGuardarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTGuardarCompraActionPerformed
        // TODO add your handling code here:
        Producto nProducto = new Producto();
        mProducto.setIDProducto(Integer.parseInt(this.TXTProductoBuscar.getText()));
        mProveedor.setIdProveedor(Integer.parseInt(this.LBLProveedor.getText()));
        mConexion.con();
        Producto mProductoViejo = mConexion.consultarProducto(Integer.parseInt(this.TXTProductoBuscar.getText()));
        mConexion.desconectar();
        
        CantidadNueva = Float.parseFloat(TXTCantidadNueva.getText()) + mProductoViejo.getCantidadProducto();
        nProducto.setNombreProducto(LBLNombreProducto1.getText());
        nProducto.setPrecioProducto(Float.parseFloat(LBLPrecio.getText()));
        nProducto.setFechaCaducidad(LBLFecha.getText());
        nProducto.setProveedor_idProveedor(LBLProveedor.getText());
        nProducto.setCantidadProducto(CantidadNueva);
        CantidadNueva=0;
        
        if (mConexion.con())
            {

                if (mConexion.modificarProducto(mProducto, nProducto))
                {
                    JOptionPane.showMessageDialog(null,"PRODUCTOS AÑADIDOS");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"ERROR EN AÑADIR, VUELVE A INTENTARLO");
                }

                Compra mCompraConsultada = mConexion.ConsultaTodaCompra(mCompra.getIdCompra());
                
                mDetalleCompra.setCantidad(Float.parseFloat(TXTCantidadNueva.getText()));              
                mDetalleCompra.setPrecio(Float.parseFloat(LBLPrecio.getText()));
                mDetalleCompra.setProducto_idProducto(mProducto.getIDProducto());
                mDetalleCompra.setProveedor_idProveedor(mProveedor.getIdProveedor());
                mDetalleCompra.setCompra_idCompra(RegistroCompra);
                
                TotalTemporal = Float.parseFloat(LBLPrecio.getText()) * Float.parseFloat(TXTCantidadNueva.getText());
                TotalCompleto = TotalTemporal + TotalCompleto;
                LBLTotal.setText(String.valueOf(TotalCompleto));
                
                if (mConexion.AltaDetalleCompra(mDetalleCompra))
                {
                    JOptionPane.showMessageDialog(null,"DETALLE DE COMPRA GUARDADO");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error detalle compra");
                }                
            }
            TXTCantidadNueva.setText("");
            TXTProductoBuscar.setText("");
            
            mConexion.desconectar();
    }//GEN-LAST:event_TXTGuardarCompraActionPerformed

    private void TXTFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTFinalizarCompraActionPerformed
        // TODO add your handling code here:
            Compra mCompraAlterada = new Compra();
            mCompra.setIdCompra(RegistroCompra);
            mCompraAlterada.setPrecioTotalCompra(Float.parseFloat(LBLTotal.getText()));
            if(mConexion.con()) 
            {
                if (mConexion.CambiosCompra(mCompra, mCompraAlterada))
                {
                    JOptionPane.showMessageDialog(null,"NUEVO PRECIO EN LA COMPRA");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"ERROR EN NUEVO PRECIO");
                }
            }
            mConexion.desconectar();
    }//GEN-LAST:event_TXTFinalizarCompraActionPerformed

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
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBuscarID;
    private javax.swing.JButton BTNBuscarTodo;
    private javax.swing.JButton BTNSalir;
    private javax.swing.JLabel LBLFecha;
    private javax.swing.JLabel LBLNombreProducto1;
    private javax.swing.JLabel LBLPrecio;
    private javax.swing.JLabel LBLProveedor;
    private javax.swing.JLabel LBLTotal;
    private javax.swing.JTable TBLCompras;
    private javax.swing.JTable TBLProveedores;
    private javax.swing.JTextField TXTCantidadNueva;
    private javax.swing.JButton TXTFinalizarCompra;
    private javax.swing.JButton TXTGuardarCompra;
    private javax.swing.JTextField TXTProductoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
