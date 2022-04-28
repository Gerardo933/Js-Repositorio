/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empleado;
import Model.Empresa;
import Model.Entrada;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author trank
 */
public class entradaDaoImplements implements entradaDao {

    @Override
    public void insertarEntrada(Entrada entrada) {
    Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entrada);
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
    public void modificarEntrada(Entrada entrada) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entrada);
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
    public void eliminarEntrada(Entrada entrada) {
         Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(entrada);
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
    public List<Entrada> mostrarEntrada() {
        Session session = null;
        List<Entrada> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Entrada as e inner join fetch e.empleado");
           lista = (List<Entrada>)query.list();
            
        }
        catch (HibernateException e)
        {
            System.out.println(e.getMessage());
           
        } finally{
            if(session != null)
                    {
                        session.close();
                    }
        }
        return lista; 
        
    }


      @Override
    public List<Empleado> mostrarEmpeados() {
        Session session = null;
        List<Empleado> listaEmpl = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Empleado as e inner join fetch e.empresa");
           listaEmpl = (List<Empleado>)query.list();
            
        }
        catch (HibernateException e)
        {
            System.out.println(e.getMessage());
           
        } finally{
            if(session != null)
                    {
                        session.close();
                    }
        }
        return listaEmpl;
    }

  
    
}
