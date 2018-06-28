/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoDocumentoDAO;
import com.bruce.dao.to.TipoDocumento;
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
public class TipoDocumentoDAO implements ITipoDocumentoDAO{

    SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Override
    public List<TipoDocumento> filterBySituacion(boolean situacion) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM TipoDocumento TD WHERE TD.situacion = :situacion");
            query.setParameter("situacion", situacion);
            result = query.list();
            tx.commit();
        }catch(HibernateException he ){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
        return result;
    }

    @Override
    public void create(TipoDocumento t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
        }catch(HibernateException he ){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(TipoDocumento t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
        }catch(HibernateException he ){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void delete(TipoDocumento t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
        }catch(HibernateException he ){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public TipoDocumento find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM TipoDocumento");
            result = query.list();
            tx.commit();
        }catch(HibernateException he ){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
        return result;
    }
    
}
