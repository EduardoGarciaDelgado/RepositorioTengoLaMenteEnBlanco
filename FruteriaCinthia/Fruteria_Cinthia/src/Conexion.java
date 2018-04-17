
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

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
    
    public boolean conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                con = (Connection) DriverManager.getConnection(url, user,pwd);
                System.out.print("Conexion exitosa");
                
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
                         "'" + mProducto.getFechaCaducidad() + "'," + "'" + mProducto.getProveedor_idProveedor() +"');");
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
                        "FechaCaducidad = '" + mProductoNuevo.getFechaCaducidad() + "'" +
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return mProducto;       
    }
    
}
