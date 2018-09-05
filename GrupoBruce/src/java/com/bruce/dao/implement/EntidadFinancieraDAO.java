/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEntidadFinancieraDAO;
import com.bruce.dao.to.EntidadFinanciera;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class EntidadFinancieraDAO implements IEntidadFinancieraDAO{
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Override
    public List<EntidadFinanciera> filterBySituacion(boolean situacion) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM EntidadFinanciera EF.situacion = :situacion");
            query.setParameter("situacion", situacion);
            result = query.list();
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
        return result;
    }

    @Override
    public void create(EntidadFinanciera t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(EntidadFinanciera t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void delete(EntidadFinanciera t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public EntidadFinanciera find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadFinanciera> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM EntidadFinanciera");
            result = query.list();
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
        return result;
    }
    
}
