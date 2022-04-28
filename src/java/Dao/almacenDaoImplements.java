/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Almacen;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author trank
 */
public class almacenDaoImplements implements almacenDao {
     @Override
    public void insertarAlmacen(Almacen almacen) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(almacen);
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
    public void modificarAlmacen(Almacen almacen) {
          Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(almacen);
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
    public void eliminarAlmacen(Almacen almacen) {
        
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(almacen);
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
    public List<Almacen> mostrarAlmacen() {
        
        
        Session session = null;
        List<Almacen> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Almacen");
           lista = (List<Almacen>)query.list();
            
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
    
}
