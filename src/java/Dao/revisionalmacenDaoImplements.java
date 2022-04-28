/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empleado;
import Model.Revisionalmacen;
import java.util.List;
import Persistencia.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author trank
 */
public class revisionalmacenDaoImplements implements revisionalmacenDao{

    @Override
    public void insertarRevisionalmacen(Revisionalmacen revisionalmacen) {
       Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(revisionalmacen);
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
    public void modificarRevisionalmacen(Revisionalmacen revisionalmacen) {
      Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(revisionalmacen);
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
    public void eliminarRevisionalmacen(Revisionalmacen revisionalmacen) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(revisionalmacen);
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
    public List<Revisionalmacen> mostrarRevisionalmacen() {
        
       Session session = null;
        List<Revisionalmacen> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Revisionalmacen as e inner join fetch e.empleado");
           lista = (List<Revisionalmacen>)query.list();
            
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
