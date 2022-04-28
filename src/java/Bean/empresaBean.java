/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.empresaDao;
import Dao.empresaDaoImplements;
import Model.Empresa;
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
public class empresaBean {
    Empresa empresa;
    List<Empresa> empresas;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresas() {
        empresaDao dao = new empresaDaoImplements();
        empresas = dao.mostrarEmpresa ();
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
    

    /**
     * Creates a new instance of empresaBean
     */
    public empresaBean() {
        empresa = new Empresa ();
    }
     public void addMessage(String summary){
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
     public void insertar()
    {
        empresaDao dao = new empresaDaoImplements();
        dao.insertarEmpresa(empresa);
        empresa = new Empresa();
        addMessage("Detalles  Ingresados");
    }
    
    public void modificar()
    {
        empresaDao dao = new empresaDaoImplements();
        dao.modificarDEmpresa(empresa);
        empresa = new Empresa();
        addMessage("Detalles  Actualizados");
    }
    
    public void eliminar()
    {
        empresaDao dao = new empresaDaoImplements();
        dao.eliminarEmpresa(empresa);
        empresa = new Empresa();
        addMessage("Detalles  Eliminados");
    }
     public void cancelar(){
         empresa = new Empresa();
     }
}
