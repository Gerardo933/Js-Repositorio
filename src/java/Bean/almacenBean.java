/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.almacenDao;
import Dao.almacenDaoImplements;
import Model.Almacen;
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
public class almacenBean {

    Almacen almacen;
    List<Almacen> almacens;

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public List<Almacen> getAlmacens() {
        almacenDao dao = new almacenDaoImplements();
        almacens = dao.mostrarAlmacen();
        return almacens;
    }

    public void setAlmacens(List<Almacen> almacens) {
        this.almacens = almacens;
    }
    
    
    
    /**
     * Creates a new instance of almacenBean
     */
    public almacenBean() {
        
        almacen = new Almacen();
        
    }
    
    public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        almacenDao dao = new almacenDaoImplements();
        dao.insertarAlmacen(almacen);
        almacen = new Almacen();
        addMessage("Detalles  Ingresados");
    }
    
    public void modificar()
    {
        almacenDao dao = new almacenDaoImplements();
        dao.modificarAlmacen(almacen);
        almacen = new Almacen();
        addMessage("Detalles  Actualizados");
    }
    
    public void eliminar()
    {
        almacenDao dao = new almacenDaoImplements();
        dao.eliminarAlmacen(almacen);
        almacen = new Almacen();
        addMessage("Detalles  Eliminados");
    }
   public void cancelar(){
        almacen = new Almacen();
     }
    
}
