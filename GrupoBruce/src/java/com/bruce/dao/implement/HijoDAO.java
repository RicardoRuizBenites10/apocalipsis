/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IHijoDAO;
import com.bruce.dao.to.Hijo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class HijoDAO implements IHijoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Hijo currentHijo) {
        Session session = sf.openSession();
        Transaction tx = null;

        Hijo lastHijo = lastHijo(currentHijo.getIdTrabajador());
        int idLast = 0;

        if (lastHijo != null) {
            idLast = lastHijo.getIdHijo();
        }

        currentHijo.setIdHijo(idLast + 1);

        try {
            tx = session.beginTransaction();
            session.save(currentHijo);
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
    public void update(Hijo t) {
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
    public void delete(Hijo t) {
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
    public Hijo find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hijo> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Hijo");
            result = query.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Hijo> filterByPadre(int start, int limit, List<FilterPage> filters) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Hijo.class);
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
            cr.addOrder(Order.desc("idHijo"));
            cr.setFirstResult(start);
            cr.setMaxResults(limit);
            result = cr.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public int countHijos(List<FilterPage> filters) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Hijo.class);
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

    @Override
    public Hijo lastHijo(String idTrabajador) {
        Session session = sf.openSession();
        Transaction tx = null;
        Hijo hijo = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Hijo.class);
            cr.add(Restrictions.eq("idTrabajador", idTrabajador));
            cr.addOrder(Order.desc("idHijo"));
            cr.setFirstResult(0);

            List result = cr.list();
            if (result.size() > 0) {
                hijo = (Hijo) result.get(0);
            }
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return hijo;
    }

}
