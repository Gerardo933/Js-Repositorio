/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Dao.entradaDao;
import Dao.entradaDaoImplements;
import Dao.revisionalmacenDao;
import Dao.revisionalmacenDaoImplements;
import Model.Empleado;
import Model.Revisionalmacen;
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
public class revisionalmacenBean {
Revisionalmacen revisionalmacen;
List<Revisionalmacen> revisionalmacens;
List<SelectItem> listEmpleados;

    public List<SelectItem> getListEmpleados() {
         this.listEmpleados = new ArrayList<SelectItem>();
        entradaDao dao = new entradaDaoImplements();
        List<Empleado> p = dao.mostrarEmpeados();
        listEmpleados.clear();
        for(Empleado empleado : p){
            SelectItem empleadoItem = new SelectItem(empleado.getIdE(),empleado.getNombre()+" "+empleado.getApellidos());
            this.listEmpleados.add(empleadoItem);
        }
        return listEmpleados;
    }

    public Revisionalmacen getRevisionalmacen() {
        return revisionalmacen;
    }

    public void setRevisionalmacen(Revisionalmacen revisionalmacen) {
        this.revisionalmacen = revisionalmacen;
    }

    public List<Revisionalmacen> getRevisionalmacens() {
        revisionalmacenDao dao = new revisionalmacenDaoImplements();
        revisionalmacens = dao.mostrarRevisionalmacen();
        return revisionalmacens;
    }

    public void setRevisionalmacens(List<Revisionalmacen> revisionalmacens) {
        this.revisionalmacens = revisionalmacens;
    }


    /**
     * Creates a new instance of revisionalmacenBean
     */
    public revisionalmacenBean() {
        revisionalmacen = new Revisionalmacen ();
    }
    
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     
     public void insertar(){
         revisionalmacenDao dao = new revisionalmacenDaoImplements();
         dao.insertarRevisionalmacen(revisionalmacen);
         revisionalmacen = new Revisionalmacen ();
         addMessage("Detalles  Ingresados");
     }
     
      public void modificar(){
         revisionalmacenDao dao = new revisionalmacenDaoImplements();
         dao.modificarRevisionalmacen(revisionalmacen);
         revisionalmacen = new Revisionalmacen ();
         addMessage("Detalles  Ingresados");
     }
      
       public void eliminar(){
         revisionalmacenDao dao = new revisionalmacenDaoImplements();
         dao.eliminarRevisionalmacen(revisionalmacen);
         revisionalmacen = new Revisionalmacen ();
         addMessage("Detalles  Ingresados");
     }
     public void cancelar(){
         revisionalmacen = new Revisionalmacen();
     }
}
