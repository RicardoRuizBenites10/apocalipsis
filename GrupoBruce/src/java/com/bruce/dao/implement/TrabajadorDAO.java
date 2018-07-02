/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.QuerySQL;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;

/**
 *
 * @author SISTEMAS
 */
public class TrabajadorDAO implements ITrabajadorDAO{
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Override
    public void create(Trabajador t) {
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
    public void update(Trabajador t) {
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
    public void delete(Trabajador t) {
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
    public Trabajador find(Object idT) {
        Session session = sf.openSession();
        Transaction tx = null;
        Trabajador trabajador = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Trabajador T WHERE T.idTrabajador = :idTrabajador");
            query.setParameter("idTrabajador", (String)idT);
            List result = query.list();
            Iterator iterator = result.iterator();
            if(iterator.hasNext()){
                trabajador = (Trabajador)iterator;
                Hibernate.initialize(trabajador);
            }
            tx.commit();
        }catch(HibernateException he ){
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
        }
        return trabajador;
    }

    @Override
    public List<Trabajador> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery(QuerySQL.TRABAJADOR_ALL);
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
    public Map<String, Object> getAllPerforms() {
        Session session = sf.openSession();
        Transaction tx = null;
        Map map = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery(QuerySQL.TRABAJADOR_ALL_PERFORMANCE);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            map = (Map) query.list();
            tx.commit();
        }catch(HibernateException he){
            if(tx!=null)tx.rollback();
        }finally{
            session.close();
        }
        return map;
    }
    
}
