
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
public class main {

    /**
     * @param args the command line arguments
     */
    static Connection con = null;
    
    public static void main(String[] args) {
        MenuPrincipal mC = new MenuPrincipal();
        mC.show();
        
        con = Conexion.conexion();
        
        
    }
}