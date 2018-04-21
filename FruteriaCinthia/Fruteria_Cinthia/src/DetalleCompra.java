/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookair
 */
public class DetalleCompra {
    public int idDetalleCompras;
    public float Cantidad;
    public float Precio;
    public int Producto_idProducto;
    public int Proveedor_idProveedor;
    public int Compra_idCompra;

    public int getIdDetalleCompras() {
        return idDetalleCompras;
    }

    public void setIdDetalleCompras(int idDetalleCompras) {
        this.idDetalleCompras = idDetalleCompras;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getProducto_idProducto() {
        return Producto_idProducto;
    }

    public void setProducto_idProducto(int Producto_idProducto) {
        this.Producto_idProducto = Producto_idProducto;
    }

    public int getProveedor_idProveedor() {
        return Proveedor_idProveedor;
    }

    public void setProveedor_idProveedor(int Proveedor_idProveedor) {
        this.Proveedor_idProveedor = Proveedor_idProveedor;
    }

    public int getCompra_idCompra() {
        return Compra_idCompra;
    }

    public void setCompra_idCompra(int Compra_idCompra) {
        this.Compra_idCompra = Compra_idCompra;
    }
    
    
}
