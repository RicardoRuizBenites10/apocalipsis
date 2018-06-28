/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IRegimenPensionarioDAO;
import com.bruce.dao.to.RegimenPensionario;
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
public class RegimenPensionarioDAO implements IRegimenPensionarioDAO{
        
    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public List<RegimenPensionario> filterBySituacion(boolean situacion) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM RegimenPensionario RP WHERE RP.situacion = :situacion");
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
    public void create(RegimenPensionario t) {
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
    public void update(RegimenPensionario t) {
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
    public void delete(RegimenPensionario t) {
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
    public RegimenPensionario find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegimenPensionario> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM RegimenPensionario");
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
