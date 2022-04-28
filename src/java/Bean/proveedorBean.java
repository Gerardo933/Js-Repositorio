/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.proveedorDao;
import Dao.proveedorDaoImplements;
import Model.Proveedor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author trank
 */
@ManagedBean
@ViewScoped
public class proveedorBean {
Proveedor proveedor;
List<Proveedor> proveedors;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getProveedors() {
        proveedorDao dao = new proveedorDaoImplements();
        proveedors = dao.mostrarProveedor();
        
        return proveedors;
    }

    public void setProveedors(List<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }


    /**
     * Creates a new instance of proveedorBean
     */
    public proveedorBean() {
        proveedor = new Proveedor(); 
    }
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public void insertar()
    {
        proveedorDao dao = new proveedorDaoImplements();
        dao.insertarProveedor(proveedor);
        proveedor = new Proveedor();
        addMessage("Detalles  Ingresados");
    }
    
    public void modificar()
    {
        proveedorDao dao = new proveedorDaoImplements();
        dao.modificarProveedor(proveedor);
        proveedor = new Proveedor();
        addMessage("Detalles  Actualizados");
    }
    
    public void eliminar()
    {
        proveedorDao dao = new proveedorDaoImplements();
        dao.eliminarProveedor(proveedor);
        proveedor = new Proveedor();
        addMessage("Detalles  Eliminados");
    }
    public void cancelar(){
         proveedor = new Proveedor();
     }
}
