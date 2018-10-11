/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.Constante;
import com.bruce.util.Metodo;
import com.bruce.util.QuerySQL;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class TrabajadorDAO implements ITrabajadorDAO {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public void create(Trabajador newTrabajador) {
        Session session = sf.openSession();
        Transaction tx = null;
        newTrabajador.setIdEtrabajador(Constante.TRABAJADOR_ESTADO_ACTIVO);
        try {
            tx = session.beginTransaction();
            session.save(newTrabajador);
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
    public void update(Trabajador t){
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
    public void delete(Trabajador t) {
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
    public Trabajador find(Object idT) {
        Session session = sf.openSession();
        Transaction tx = null;
        Trabajador trabajador = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Trabajador T WHERE T.idTrabajador = :idTrabajador");
            query.setParameter("idTrabajador", (String) idT);
            List result = query.list();
            trabajador = (Trabajador) result.get(0);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return trabajador;
    }

    @Override
    public List<Trabajador> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(QuerySQL.TRABAJADOR_ALL);
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

//    @Override
//    public List<TrabajadorDTO> getAllPerforms() {
//        Session session = sf.openSession();
//        Transaction tx = null;
//        List<TrabajadorDTO> result = null;
//        try {
//            tx = session.beginTransaction();
////            Query query = session.createQuery(QuerySQL.TRABAJADOR_ALL_PERFORMANCE);
////            result = query.setResultTransformer(Transformers.aliasToBean(TrabajadorDTO.class)).list();
//            tx.commit();
//        } catch (HibernateException he) {
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return result;
//    }

    @Override
    public List<Trabajador> getTrabajadorsPagination(int start, int limit, List<SortPage> sorts) {
        Session session = sf.openSession();
        Transaction tx = null;
        List result = null;
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Trabajador.class);
            sorts.forEach(item -> {
                ArrayList<String> propiedad = (ArrayList<String>) Metodo.getSplit(item.getProperty(), ".");
                if (propiedad.size() > 1) {
                    cr.createCriteria(propiedad.get(0)).addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(propiedad.get(1)) : Order.desc(propiedad.get(1)));
                } else {
                    cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
                }
            });
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
    public int getTrabajadorCount() {
        Session session = sf.openSession();
        Transaction tx = null;
        List count = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Trabajador.class);
            cr.setProjection(Projections.rowCount());
            count = cr.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return ((Long) count.get(0)).intValue();
    }
}
