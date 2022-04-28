/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.recibeproductoDao;
import Dao.recibeproductoDaoImplements;
import Model.Producto;
import Model.Proveedor;
import Model.Recibeproducto;
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
public class recibeproductoBean {
Recibeproducto recibeproducto;
List<Recibeproducto> recibeproductos;
List<SelectItem> listProd;
List<SelectItem> listProv;

    public List<SelectItem> getListProd() {
        this.listProd = new ArrayList<SelectItem>();
        recibeproductoDao dao = new recibeproductoDaoImplements();
        List<Producto> p = dao.mostrarProductos(recibeproducto);
        listProd.clear();
        for(Producto producto : p){
            SelectItem productoItem = new SelectItem(producto.getIdProd(), producto.getNombre());
            this.listProd.add(productoItem);
        }
        return listProd;
    }

    public List<SelectItem> getListProv() {
       this.listProv = new ArrayList<SelectItem>();
        recibeproductoDao dao = new recibeproductoDaoImplements();
        List<Proveedor> p = dao.mostrarProveedores();
        listProv.clear();
        for(Proveedor proveedor: p){
            SelectItem proveedorItem = new SelectItem(proveedor.getIdProv(), proveedor.getEmpresa());
            this.listProv.add(proveedorItem);
        }
        
        return listProv;
    }

    public Recibeproducto getRecibeproducto() {
        return recibeproducto;
    }

    public void setRecibeproducto(Recibeproducto recibeproducto) {
        this.recibeproducto = recibeproducto;
    }

    public List<Recibeproducto> getRecibeproductos() {
        recibeproductoDao dao = new recibeproductoDaoImplements();
        recibeproductos = dao.mostrarRecibeproducto();
        return recibeproductos;
    }

    public void setRecibeproductos(List<Recibeproducto> recibeproductos) {
        this.recibeproductos = recibeproductos;
    }

    /**
     * Creates a new instance of recibeproductoBean
     */
    public recibeproductoBean() {
        recibeproducto = new Recibeproducto();
    }
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
     public void insertar(){
         recibeproductoDao dao = new recibeproductoDaoImplements();
         dao.insertarRecibeproducto(recibeproducto);
         recibeproducto = new Recibeproducto();
         addMessage("Detalles  Ingresados");
     }
     
     public void modificar(){
         recibeproductoDao dao = new recibeproductoDaoImplements();
         dao.modificarRecibeprducto(recibeproducto);
         recibeproducto = new Recibeproducto();
         addMessage("Detalles  Ingresados");
     }
     
     public void eliminar(){
         recibeproductoDao dao = new recibeproductoDaoImplements();
         dao.eliminarRecibeproducto(recibeproducto);
         recibeproducto = new Recibeproducto();
         addMessage("Detalles  Ingresados");
     }
     
}
