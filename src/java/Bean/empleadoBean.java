/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.empleadoDao;
import Dao.empleadoDaoImplements;
import Model.Empleado;
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
public class empleadoBean {

    Empleado empleado;
    List<Empleado> empleados;
    List<SelectItem> listEmpresas;

    public List<SelectItem> getListEmpresas() {
        this.listEmpresas = new ArrayList<SelectItem>();
        empleadoDao dao = new empleadoDaoImplements();
        List<Empresa> p = dao.mostrarEmpresas();
       listEmpresas.clear();
        for(Empresa empresa: p){
            SelectItem empresaItem = new SelectItem(empresa.getIdEmp(), empresa.getNombre());
            this.listEmpresas.add(empresaItem);
        }
        return listEmpresas;
    }
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleados() {
        empleadoDao dao = new empleadoDaoImplements();
        empleados = dao.mostrarEmpleado();
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    
    /**
     * Creates a new instance of empleadoBean
     */
    public empleadoBean() {
        empleado = new Empleado ();
    }
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
     public void insertar()
    {
        empleadoDao dao = new empleadoDaoImplements();
        dao.insertarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Detalles  Ingresados");
    }
    
    public void modificar()
    {
        empleadoDao dao = new empleadoDaoImplements();
        dao.modificarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Detalles  Actualizados");
    }
    
    public void eliminar()
    {  
        empleadoDao dao = new empleadoDaoImplements();
        dao.eliminarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Detalles  Eliminados");
      
        
    }
     public void cancelar(){
         empleado = new Empleado();
     }
}
