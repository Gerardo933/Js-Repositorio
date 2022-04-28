/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.entradaDao;
import Dao.entradaDaoImplements;
import Model.Empleado;
import Model.Entrada;
import Model.Empresa;
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
public class entradaBean {
Entrada entrada;
List<Entrada> entradas;
List<SelectItem> listEmpleados;
    public Entrada getEntrada() {
        return entrada;
    }

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

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public List<Entrada> getEntradas() {
        entradaDao dao = new entradaDaoImplements();
        entradas = dao.mostrarEntrada();
        
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }



    /**
     * Creates a new instance of entradaBean
     */
    public entradaBean() {
        entrada = new Entrada();
    }
    
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
     public void insertar(){
      entradaDao dao = new entradaDaoImplements();   
      dao.insertarEntrada(entrada);
      entrada = new Entrada();
      addMessage("Detalles  Ingresados");
}
   
      public void modificar(){
      entradaDao dao = new entradaDaoImplements();   
      dao.modificarEntrada(entrada);
      entrada = new Entrada();
      addMessage("Detalles  Ingresados");
}
      
      
       public void eliminar(){
      entradaDao dao = new entradaDaoImplements();   
      dao.eliminarEntrada(entrada);
      entrada = new Entrada();
      addMessage("Detalles  Ingresados");
}
      public void cancelar(){
         entrada = new Entrada();
     }
     
     
    
}
