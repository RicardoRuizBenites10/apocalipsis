/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.to.PeriodoPlanilla;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.dao.design.IPeriodoPlanillaDAO;

/**
 *
 * @author SISTEMAS
 */
public class PeriodoPlanillaDAO implements IPeriodoPlanillaDAO{
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Override
    public List<PeriodoPlanilla> filterBySituacion(boolean situacion) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Periodo P WHERE P.situacion = :situacion");
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
    public List<PeriodoPlanilla> filterByTipo(int id_tperiodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(PeriodoPlanilla t) {
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
    public void update(PeriodoPlanilla t) {
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
    public void delete(PeriodoPlanilla t) {
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
    public PeriodoPlanilla find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PeriodoPlanilla> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Periodo");
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