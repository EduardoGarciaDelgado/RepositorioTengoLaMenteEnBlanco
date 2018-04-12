
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    static Connection con = null;
    
    static String url = "jdbc:mysql://localhost:8889/mydb";
    static String pwd = "root";
    static String user = "root";
    
    public static Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                con = (Connection) DriverManager.getConnection(url, user,pwd);
                
                System.out.print("Coneccion exitosa");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
