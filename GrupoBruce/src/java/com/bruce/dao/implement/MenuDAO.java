/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMenuDAO;
import com.bruce.dao.to.Menu;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;

/**
 *
 * @author SISTEMAS
 */
public class MenuDAO implements IMenuDAO{
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Override
    public List<Menu> filterBySituacion(boolean situacion) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Menu M WHERE M.situacion = :situacion");
            query.setParameter("situacion", situacion);
            result = query.list();
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null)tx.rollback();
        }finally{
            session.close();
        }
        return result;
    }

    @Override
    public void create(Menu menu) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(menu);
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(Menu menu) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(menu);
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void delete(Menu menu) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(menu);
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Menu find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Menu> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Menu");
            result = query.list();
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null)tx.rollback();
        }finally{
            session.close();
        }
        return result;
    }
    
}
