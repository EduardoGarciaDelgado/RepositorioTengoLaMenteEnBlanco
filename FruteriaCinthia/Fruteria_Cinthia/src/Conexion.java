
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookair
 */
public class Conexion {
    private Connection con;
    
    static String url = "jdbc:mysql://localhost:8889/mydb";
    static String pwd = "root";
    static String user = "root";
    
    public boolean con() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                con = (Connection) DriverManager.getConnection(url, user,pwd);
                //System.out.print("con exitosa");
                
                if (con != null) {
                    return true;                  
                } else {
                    return false;
                }              

            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;       
    }
    
    public void desconectar() {
        try {
            this.con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean guardarProducto(Producto mProducto) {
        Statement consulta;

        try {
            consulta = con.createStatement();
            consulta.execute("insert into Producto " +
                        "values (null,'" + mProducto.getNombreProducto() + "'," +
                        "'" + mProducto.getPrecioProducto() + "'," +
                        "'" + mProducto.getPrecioVentaProducto() + "'," +
                         "'" + mProducto.getFechaCaducidad() + "'," + "'" + mProducto.getProveedor_idProveedor() +
                         "','" + mProducto.getCantidadProducto() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modificarProducto(Producto mProductoViejo, Producto mProductoNuevo) {
        Statement consulta;

        try {
            consulta = con.createStatement();
            consulta.execute("update Producto set " + 
                        "Nombre = '" + mProductoNuevo.getNombreProducto() + "'," +
                        "Precio = '" + mProductoNuevo.getPrecioProducto() + "'," +
                        "PrecioVenta = '" + mProductoNuevo.getPrecioVentaProducto() + "'," +
                        "FechaCaducidad = '" + mProductoNuevo.getFechaCaducidad() + "'," +
                        "Proveedor_idProveedor = '" + mProductoNuevo.getProveedor_idProveedor() + "'," +
                        "Cantidad = '" + mProductoNuevo.getCantidadProducto() + "'" +
                        " where idProducto = " +  mProductoViejo.getIDProducto() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
    
    public boolean eliminarProducto(Producto mProducto) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("delete from Producto " + 
                        " where idProducto = " + mProducto.getIDProducto() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }  
    }
    
    public Producto consultarProducto(int ID) {
        Producto mProducto = null;
        Statement consulta;
        ResultSet resultado;
        
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Producto " +
                        "where idProducto = " + ID + ";");
            if (resultado.next()) {
                mProducto = new Producto();
                mProducto.setIDProducto(resultado.getInt("idProducto"));
                mProducto.setNombreProducto(resultado.getString("Nombre"));
                mProducto.setPrecioProducto(Float.parseFloat(resultado.getString("Precio")));
                mProducto.setPrecioVentaProducto(Float.parseFloat(resultado.getString("PrecioVenta")));
                mProducto.setFechaCaducidad(resultado.getString("FechaCaducidad"));
                mProducto.setProveedor_idProveedor(resultado.getString("Proveedor_idProveedor"));
                mProducto.setCantidadProducto(Float.parseFloat(resultado.getString("Cantidad")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return mProducto;       
    }
    
    public ArrayList ConsultaTodoProducto() {
        
        ArrayList mListaProducto = new ArrayList();
        Producto mProducto=null;
        Statement consulta;
        ResultSet resultado;
        
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Producto;");
            while (resultado.next()) {
                mProducto = new Producto();
                mProducto.setIDProducto(resultado.getInt("IdProducto"));
                mProducto.setNombreProducto(resultado.getString("Nombre"));
                mProducto.setPrecioProducto(Float.parseFloat(resultado.getString("Precio")));
                mProducto.setPrecioVentaProducto(resultado.getFloat("PrecioVenta"));
                mProducto.setFechaCaducidad(resultado.getString("FechaCaducidad"));
                mProducto.setProveedor_idProveedor(resultado.getString("Proveedor_idProveedor"));
                mProducto.setCantidadProducto(Float.parseFloat(resultado.getString("Cantidad")));
                mListaProducto.add(mProducto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mListaProducto;
      }
        
    //-------------- ABCC Proveedor
    public boolean AltaProveedor(Proveedor mProveedor) {
        Statement consulta;

        try {
            consulta = con.createStatement();
            consulta.execute("insert into Proveedor " + 
                        "(IdProveedor, NombreProveedor) " +
                        "values (null,'" + mProveedor.getNombre() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean BajaProveedor(Proveedor mProveedor) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("delete from Proveedor " + 
                        " where IdProveedor = " + mProveedor.getIdProveedor() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean CambiosProveedor(Proveedor mProveedor, Proveedor nProveedor) {
        Statement consulta;

        try {
            consulta = con.createStatement();
            consulta.execute("update Proveedor set " + 
                        "NombreProveedor = '" + nProveedor.getNombre() + "'" +
                        " where IdProveedor = " + mProveedor.getIdProveedor() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Proveedor ConsultaProveedor(int IdProveedor) {
        Proveedor mProveedor = null;
        Statement consulta;
        ResultSet resultado;
        
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Proveedor " +
                        "where IdProveedor = " + IdProveedor + ";");
            if (resultado.next()) {
                mProveedor = new Proveedor();
                mProveedor.setIdProveedor(resultado.getInt("IdProveedor"));
                mProveedor.setNombre(resultado.getString("NombreProveedor"));             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return mProveedor;       
    }
    public ArrayList ConsultaTodoProveedor() {
        ArrayList mLista = new ArrayList();
        Proveedor mProveedor=null;
        Statement consulta;
        ResultSet resultado;
        
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Proveedor;");
            while (resultado.next()) {
                mProveedor = new Proveedor();
                mProveedor.setIdProveedor(resultado.getInt("IdProveedor"));
                mProveedor.setNombre(resultado.getString("NombreProveedor"));
                mLista.add(mProveedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLista;
      }
      
    //----------------------------- Compras
    public boolean AltaCompra(Compra mCompra) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("insert into Compra "  +
                        "values (null,'" + mCompra.getFechaCompra() + "', '" + mCompra.getPrecioTotalCompra()+ "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean AltaDetalleCompra(DetalleCompra mDetalleCompra) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("insert into Detalle_Compras " + 
                        "(idDetalle_Compras, Cantidad, Precio, Producto_idProducto, Proveedor_idProveedor, Compra_idCompra) " +
                        "values (null,'" + mDetalleCompra.getCantidad() + "','" 
                                        + mDetalleCompra.getPrecio() + "','" 
                                        + mDetalleCompra.getProducto_idProducto() + "','"
                                        + mDetalleCompra.getProveedor_idProveedor() + "','"
                                        + mDetalleCompra.getCompra_idCompra() + "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }   
    public boolean CambiosCompra(Compra mCompra, Compra nCompra) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("update Compra set " + 
                        "PrecioTotalCompra = '" + nCompra.getPrecioTotalCompra() + "'" +
                        " where IdCompra = " + mCompra.getIdCompra() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
        
    }       
    public Compra ConsultaTodaCompra(int ID) {
        Compra mCompra=null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Compra " +
                        "where IdCompra = " + ID + ";");
            if (resultado.next()) {
                mCompra = new Compra();
                mCompra.setIdCompra(resultado.getInt("IdCompra"));
                mCompra.setFechaCompra(resultado.getString("FechaCompra"));
                mCompra.setPrecioTotalCompra(Float.parseFloat(resultado.getString("PrecioTotalCompra")));            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mCompra;
      }  
    public int ConsultaIDCompra() {
        ArrayList mLista = new ArrayList();
        Compra mCompra=null;
        Statement consulta;
        ResultSet resultado;
        int RegistroUltimo=0;
        
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(idCompra) FROM Compra;");
            while (resultado.next()) {
                RegistroUltimo = resultado.getInt("MAX(idCompra)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RegistroUltimo;
      }
    
    //----------------------------- Ventas
    public boolean AltaVenta(Venta mVenta) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("insert into Venta "  +
                        "values (null,'" + mVenta.getFechaVenta() + "', '" + mVenta.getPrecioTotalVenta()+  "', '" + mVenta.getGanacia()+ "');");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean AltaDetalleVenta(DetalleVenta mDetalleVenta) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("insert into Detalle_Ventas " + 
                        "(idDetalle_Ventas, Cantidad, PrecioVenta, Producto_idProducto, Venta_idVenta) " +
                        "values (null,'" + mDetalleVenta.getCantidad() + "','" 
                                        + mDetalleVenta.getPrecio() + "','" 
                                        + mDetalleVenta.getProducto_IdProducto() + "','"
                                        + mDetalleVenta.getVenta_IdVenta() + "');");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }   
    public boolean CambiosVenta(Venta mVenta, Venta nVenta) {
        Statement consulta;
        try {
            consulta = con.createStatement();
            consulta.execute("update Venta set " + 
                        "PrecioTotalVenta = '" + nVenta.getPrecioTotalVenta() + "'," +
                        "Ganancia = '" + nVenta.getGanacia() + "'" +
                        " where idVenta = " + mVenta.getIdVenta() + ";");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }     
        
    }       
    public Venta ConsultaTodaVenta(int ID) {
        Venta mVenta=null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Venta " +
                        "where idVenta = " + ID + ";");
            if (resultado.next()) {
                mVenta = new Venta();
                mVenta.setIdVenta(resultado.getInt("idVenta"));
                mVenta.setFechaVenta(resultado.getString("FechaVenta"));
                mVenta.setPrecioTotalVenta(Float.parseFloat(resultado.getString("PrecioTotalVenta")));            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mVenta;
      }  
    public int ConsultaIDVenta() {
        ArrayList mLista = new ArrayList();
        Venta mVenta=null;
        Statement consulta;
        ResultSet resultado;
        int RegistroUltimo=0;
        
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("SELECT MAX(idVenta) FROM Venta;");
            while (resultado.next()) {
                RegistroUltimo = resultado.getInt("MAX(idVenta)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RegistroUltimo;
      }
    public ArrayList ConsultaTodosIdVenta() {
        
        ArrayList mLista = new ArrayList();
        Venta mVenta=null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("select * from Venta;");
            while (resultado.next()) {
                mVenta = new Venta();
                mVenta.setIdVenta(resultado.getInt("idVenta"));
                mVenta.setFechaVenta(resultado.getString("FechaVenta"));
                mVenta.setPrecioTotalVenta(resultado.getFloat("PrecioTotalVenta"));
                mVenta.setGanacia(resultado.getFloat("Ganancia"));
                mLista.add(mVenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLista;
      }
    
    public ArrayList ConsultarRangosVenta(String Fecha1, String Fecha2) {
        
        ArrayList mLista = new ArrayList();
        Venta mVenta=null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = con.createStatement();
            resultado = consulta.executeQuery("SELECT FechaVenta,sum(PrecioTotalVenta) FROM Venta WHERE FechaVenta >= '"+ Fecha1 +"' and FechaVenta <='"+ Fecha2 +"' group by FechaVenta;");
            while (resultado.next()) {
                mVenta = new Venta();
                //mVenta.setIdVenta(resultado.getInt("idVenta"));
                mVenta.setFechaVenta(resultado.getString("FechaVenta"));
                mVenta.setPrecioTotalVenta(resultado.getFloat("PrecioTotalVenta"));
                //mVenta.setGanacia(resultado.getFloat("Ganancia"));
                mLista.add(mVenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLista;
      }
    
    
    public String url1 = "jdbc:mysql://localhost:8889/mydb";
    public String user1 = "root";
    public String pass = "root";

    public Connection conectare() {
        Connection link = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url1, this.user1, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        return link;
    }
}
