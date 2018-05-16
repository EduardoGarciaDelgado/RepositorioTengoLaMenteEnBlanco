
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author macbookair
 */
public class Producto {
    public int IDProducto;
    public String NombreProducto;
    public float PrecioProducto;
    public float PrecioVentaProducto;
    public float CantidadProducto;
    public String FechaCaducidad;
    public String Proveedor_idProveedor;

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public float getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(float CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    
    
    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public float getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(float PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }
    
    public String getFechaCaducidad() {
        return FechaCaducidad;
    }
    
    
    public void setFechaCaducidad(String FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }
    
    
    public String getProveedor_idProveedor() {
        return Proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(String Proveedor_idProveedor) {
        this.Proveedor_idProveedor = Proveedor_idProveedor;
    }
    
    
    /*
    public void setFechaCaducidad(java.util.Date fecha) {
        this.FechaCaducidad = FechaCaducidad;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    public float getPrecioVentaProducto() {
        return PrecioVentaProducto;
    }

    public void setPrecioVentaProducto(float PrecioVentaProducto) {
        this.PrecioVentaProducto = PrecioVentaProducto;
    }
    
}
