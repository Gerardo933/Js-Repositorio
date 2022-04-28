/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Producto;
import Model.Proveedor;
import Model.Recibeproducto;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author trank
 */
public class recibeproductoDaoImplements implements recibeproductoDao {

    @Override
    public void insertarRecibeproducto(Recibeproducto recibeproducto) {
    Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(recibeproducto);
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
    public void modificarRecibeprducto(Recibeproducto recibeproducto) {
          Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(recibeproducto);
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
    public void eliminarRecibeproducto(Recibeproducto recibeproducto) {
      Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(recibeproducto);
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
    public List<Recibeproducto> mostrarRecibeproducto() {
  Session session = null;
        List<Recibeproducto> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Recibeproducto as e inner join fetch e.proveedor left join fetch e.producto");
           lista = (List<Recibeproducto>)query.list();
            
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
    public List<Proveedor> mostrarProveedores() {
        Session session = null;
        List<Proveedor> listaProv = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Proveedores");
           listaProv = (List<Proveedor>)query.list();
            
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
        return listaProv;       
    }

    @Override
    public List<Producto> mostrarProductos(Recibeproducto recibeproducto) {
          
        Session session = null;
        List<Producto> listaProd = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           //referencia a clase que esta en el model
           Query query = session.createQuery("from Producto where idProd='"+recibeproducto.getProveedor().getIdProv()+"'");
           listaProd = (List<Producto>)query.list();
            
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
        return listaProd;       
    
    }
    
}
