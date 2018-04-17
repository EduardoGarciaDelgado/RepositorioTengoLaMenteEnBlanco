
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
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
    private Connection conexion;
    
    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mydb", "root", "");
            if (conexion != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public void desconectar() {
        try {
            this.conexion.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public boolean AltaProveedor(Proveedor mProveedor) {
        Statement consulta;

        try {
            consulta = conexion.createStatement();
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
            consulta = conexion.createStatement();
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
            consulta = conexion.createStatement();
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
            consulta = conexion.createStatement();
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
      public ArrayList ConsultaProveedor() {
        ArrayList mLista = new ArrayList();
        Proveedor mProveedor=null;
        Statement consulta;
        ResultSet resultado;
        
        try {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("select * from alta;");
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
}
