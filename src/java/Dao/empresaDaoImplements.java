/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empresa;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author trank
 */
public class empresaDaoImplements implements empresaDao{

    @Override
    public void insertarEmpresa(Empresa empresa) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empresa);
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
    public void modificarDEmpresa(Empresa empresa) {
         Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empresa);
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
    public void eliminarEmpresa(Empresa empresa) {
        Session session = null;
        try 
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empresa);
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
    public List<Empresa> mostrarEmpresa() {
         Session session = null;
        List<Empresa> lista = null;
       
        try 
        {
           session = NewHibernateUtil.getSessionFactory().openSession();
           Query query = session.createQuery("from Empresa");
           lista = (List<Empresa>)query.list();
            
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
