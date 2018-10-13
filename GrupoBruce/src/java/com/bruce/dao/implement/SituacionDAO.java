/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ISituacionDAO;
import com.bruce.dao.to.Situacion;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class SituacionDAO implements ISituacionDAO{
    
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Override
    public void create(Situacion currentSituacion) {
        Session session = sf.openSession();
        Transaction tx = null;

        Situacion lastSituacion = last(currentSituacion.getIdTrabajador());
        int idLast = 0;

        if (lastSituacion != null) {
            idLast = lastSituacion.getIdSituacion();
        }

        currentSituacion.setIdSituacion(idLast + 1);

        try {
            tx = session.beginTransaction();
            session.save(currentSituacion);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Situacion t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Situacion t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Situacion find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Situacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Situacion last(String idTrabajador) {
        Session session = sf.openSession();
        Transaction tx = null;
        Situacion situacion = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Situacion.class);
            cr.add(Restrictions.eq("idTrabajador", idTrabajador));
            cr.addOrder(Order.desc("idSituacion"));
            cr.setFirstResult(0);

            List result = cr.list();
            if (result.size() > 0) {
                situacion = (Situacion) result.get(0);
            }
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return situacion;
    }
    
    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Situacion.class);
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
            cr.setProjection(Projections.rowCount());
            result = cr.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return ((Long) result.get(0)).intValue();
    }
    
}
