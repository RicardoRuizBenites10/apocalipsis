/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.to.Sucursal;
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
 * @author RICARDO
 */
@Repository
public class SucursalDAO implements ISucursalDAO{
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void create(Sucursal t) {
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
    public void update(Sucursal t) {
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
    public void delete(Sucursal t) {
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
    public Sucursal find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sucursal> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Sucursal");
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
    public List<Sucursal> filterByEmpresa(String idEmpresa) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Sucursal S WHERE S.idEmpresa = :empresa");
            query.setParameter("empresa", idEmpresa);
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
