/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.to.ContratoTrabajador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.Constante;
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
public class ContratoTrabajadorDAO implements IContratoTrabajadorDAO {

//    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ContratoTrabajador newContrato) {
        Session session = sf.openSession();
        Transaction tx = null;
        
        int idCLast = 0;
        ContratoTrabajador lastContrato = filterLastContrato(newContrato.getIdTrabajador());
        if (lastContrato != null && lastContrato.getIdEcontrato() == Constante.CONTRATO_ESTADO_VIGENTE) {
            lastContrato.setIdEcontrato(Constante.CONTRATO_ESTADO_RENOVADO);
            idCLast = lastContrato.getIdContrato();
        }
        
        newContrato.setIdContrato(idCLast + 1);
        newContrato.setIdEcontrato(Constante.CONTRATO_ESTADO_VIGENTE);
        
        try {
            tx = session.beginTransaction();
            if (lastContrato != null) {
                session.update(lastContrato);
            }
            session.save(newContrato);
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
    public void update(ContratoTrabajador t) {
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
    public void delete(ContratoTrabajador t) {
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
    public ContratoTrabajador find(Object idT) {
        Session session = sf.openSession();
        Transaction tx = null;
        ContratoTrabajador result = null;
        List<FilterPage> filters = (List<FilterPage>) idT;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ContratoTrabajador.class);
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
            result = (ContratoTrabajador) cr.list();
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
    public List<ContratoTrabajador> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM ContratoTrabajador");
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
    public List<ContratoTrabajador> filterByTrabajador(int start, int limit, List<FilterPage> filters) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ContratoTrabajador.class);
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
            cr.addOrder(Order.desc("idContrato"));
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
    public int getCountContratos(List<FilterPage> filters) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ContratoTrabajador.class);
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
    public ContratoTrabajador filterLastContrato(String idTrabajador) {
        Session session = sf.openSession();
        Transaction tx = null;
        ContratoTrabajador contrato = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(ContratoTrabajador.class);
            cr.add(Restrictions.eq("idTrabajador", idTrabajador));
            cr.addOrder(Order.desc("idContrato"));
            cr.setFirstResult(0);

            List result = cr.list();
            if (result.size() > 0) {
                contrato = (ContratoTrabajador) result.get(0);
            }
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return contrato;
    }

}
