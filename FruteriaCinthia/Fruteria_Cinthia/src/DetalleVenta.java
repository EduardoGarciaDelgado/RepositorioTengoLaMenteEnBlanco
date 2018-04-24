/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbookair
 */
public class DetalleVenta {
    public int IdDetalleVentas;
    public float Cantidad;
    public float Precio;
    public int Producto_IdProducto;
    public int Venta_IdVenta;

    public int getIdDetalleVentas() {
        return IdDetalleVentas;
    }

    public void setIdDetalleVentas(int IdDetalleVentas) {
        this.IdDetalleVentas = IdDetalleVentas;
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

    public int getProducto_IdProducto() {
        return Producto_IdProducto;
    }

    public void setProducto_IdProducto(int Producto_IdProducto) {
        this.Producto_IdProducto = Producto_IdProducto;
    }


    public int getVenta_IdVenta() {
        return Venta_IdVenta;
    }

    public void setVenta_IdVenta(int Venta_IdVenta) {
        this.Venta_IdVenta = Venta_IdVenta;
    }
}
