package Model;
// Generated 7/12/2020 11:16:12 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Recibeproducto generated by hbm2java
 */
public class Recibeproducto  implements java.io.Serializable {


     private Integer idRecibe;
     private Producto producto;
     private Proveedor proveedor;
     private Date hora;

    public Recibeproducto() {
        producto = new Producto();
        proveedor = new Proveedor();
    }

    public Recibeproducto(Producto producto, Proveedor proveedor, Date hora) {
       this.producto = producto;
       this.proveedor = proveedor;
       this.hora = hora;
    }
   
    public Integer getIdRecibe() {
        return this.idRecibe;
    }
    
    public void setIdRecibe(Integer idRecibe) {
        this.idRecibe = idRecibe;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }




}


