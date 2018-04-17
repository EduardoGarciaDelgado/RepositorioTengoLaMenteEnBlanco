/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
<<<<<<< HEAD
 * @author macbookair
 */
public class Proveedor {
    public String Nombre;
=======
 * @author Cinthia
 */
public class Proveedor {
    public String Nombre;
    public int IdProveedor;
    public Proveedor(){
        Nombre="";
        IdProveedor=0;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }
>>>>>>> b4217c4f227190f32a4cb0489e478a500c9592a1

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
