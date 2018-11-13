/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.Metodo;
import com.bruce.util.QuerySQL;
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
public class TrabajadorDAO implements ITrabajadorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Trabajador t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Trabajador t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Trabajador t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Trabajador find(Object idT) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Trabajador T WHERE T.idTrabajador = :idTrabajador");
        query.setParameter("idTrabajador", (String) idT);
        List result = query.list();
        Trabajador trabajador = result.size() > 0 ? (Trabajador) result.get(0) : null;
        return trabajador;
    }

    @Override
    public List<Trabajador> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery(QuerySQL.TRABAJADOR_ALL);
        return query.list();
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
    public List<Trabajador> getTrabajadorsPagination(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Trabajador.class);
        filters.forEach(item -> {
            switch (item.getOperator()) {
                case "like":
                    cr.add(Restrictions.like(item.getProperty(), item.getValue() + "%"));
                    break;
                default:
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                    break;
            }
        });
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
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Trabajador.class);
        filters.forEach(item -> {
            switch (item.getOperator()) {
                case "like":
                    cr.add(Restrictions.like(item.getProperty(), item.getValue() + "%"));
                    break;
                default:
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                    break;
            }
        });
        cr.setProjection(Projections.rowCount());
        return ((Long) cr.list().get(0)).intValue();
    }
}
