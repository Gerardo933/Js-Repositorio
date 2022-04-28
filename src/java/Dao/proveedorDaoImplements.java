/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Proveedor;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author trank
 */
public class proveedorDaoImplements implements proveedorDao{

    @Override
    public void insertarProveedor(Proveedor proveedor) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(proveedor);
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
    public void modificarProveedor(Proveedor proveedor) {
         Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(proveedor);
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
    public void eliminarProveedor(Proveedor proveedor) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(proveedor);
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
    public List<Proveedor> mostrarProveedor() {
        Session session = null;
        List<Proveedor> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Proveedor");
           lista = (List<Proveedor>)query.list();
            
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
    
}
