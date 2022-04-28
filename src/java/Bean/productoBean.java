/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.productoDao;
import Dao.productoDaoImplements;
import Dao.proveedorDao;
import Model.Producto;
import Model.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author trank
 */
@ManagedBean
@ViewScoped
public class productoBean {
    
Producto producto;
List<Producto> productos;
List<SelectItem> listProveedor;

    public List<SelectItem> getListProvedor() {
           
        this.listProveedor = new ArrayList<SelectItem>();
        productoDao dao = new productoDaoImplements();
        List<Proveedor> p = dao.mostrarProveedores();
        listProveedor.clear();
        for(Proveedor proveedor: p){
            SelectItem proveedorItem = new SelectItem(proveedor.getIdProv(), proveedor.getEmpresa());
            this.listProveedor.add(proveedorItem);
        }
        return listProveedor;
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        productoDao dao = new productoDaoImplements();
        productos = dao.mostrarProducto();  
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Creates a new instance of productoBean
     */
    public productoBean() {
        producto = new Producto ();
        
    }
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public void insertar()
    {
        productoDao dao = new productoDaoImplements();
        dao.insertarProducto(producto);
        producto = new Producto();
        addMessage("Detalles  Ingresados");
    }
    
    public void modificar()
    {
        productoDao dao = new productoDaoImplements();
        dao.modificarProducto(producto);
        producto = new Producto();
        addMessage("Detalles  Actualizados");
    }
    
    public void eliminar()
    {
        productoDao dao = new productoDaoImplements();
        dao.eliminarProducto(producto);
        producto = new Producto();
        addMessage("Detalles  Eliminados");
    }
     
      public void cancelar(){
         producto = new Producto();
     }
}
