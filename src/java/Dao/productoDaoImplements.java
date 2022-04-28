/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Producto;
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
public class productoDaoImplements implements productoDao{

    @Override
    public void insertarProducto(Producto producto) {
               Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
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
    public void modificarProducto(Producto producto) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
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
    public void eliminarProducto(Producto producto) {
         Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
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
    public List<Producto> mostrarProducto() {
        Session session = null;
        List<Producto> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Producto as e inner join fetch e.proveedor");
           lista = (List<Producto>)query.list();
            
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
    public List<Proveedor> mostrarProveedores() {
         Session session = null;
        List<Proveedor> listaProv = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Proveedor");
           listaProv = (List<Proveedor>)query.list();
            
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
        return listaProv;
    }
    
}
