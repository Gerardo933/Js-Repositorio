/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empleado;
import Model.Empresa;
import Persistencia.NewHibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author trank
 */
public class empleadoDaoImplements implements empleadoDao{

    @Override
    public void insertarEmpleado(Empleado empleado) {
          Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empleado);
            session.getTransaction().commit();
        }
        catch (HibernateException e) 
        {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally
        {
            if(session != null)
                    {
                        session.close();
                    }
        }
 
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empleado);
            session.getTransaction().commit();
        }
        catch (HibernateException e) 
        {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally
        {
            if(session != null)
                    {
                        session.close();
                    }
        }

    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
           Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empleado);
            session.getTransaction().commit();
        }
        catch (HibernateException e) 
        {
            System.out.println(e.getMessage());
            //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage((FacesMessage.SEVERITY_ERROR),"Error", "No puede eliminarse el registro porque está relacionado con otras tablas"));
            session.getTransaction().rollback();
        }
        finally
        {
            if(session != null)
                    {
                        session.close();
                    }
        }

    }

    @Override
    public List<Empleado> mostrarEmpleado() {
         Session session = null;
        List<Empleado> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Empleado as e inner join fetch e.empresa");
           lista = (List<Empleado>)query.list();
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
           
        }
        finally
        {
            if(session != null)
                    {
                        session.close();
                    }
        }
        return lista;
        
    }

    @Override
    public List<Empresa> mostrarEmpresas() {
       Session session = null;
        List<Empresa> listaEmpresas = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Empresa");
           listaEmpresas = (List<Empresa>)query.list();
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
           
        }
        finally
        {
            if(session != null)
                    {
                        session.close();
                    }
        }
        return listaEmpresas;
    }

   
    
}
