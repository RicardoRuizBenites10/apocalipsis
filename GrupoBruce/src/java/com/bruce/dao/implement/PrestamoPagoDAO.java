/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IPrestamoPagoDAO;
import com.bruce.dao.to.PrestamoPago;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class PrestamoPagoDAO implements IPrestamoPagoDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(PrestamoPago t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(PrestamoPago t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(PrestamoPago t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public PrestamoPago get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrestamoPago lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PrestamoPago.class);
        filters.forEach(item -> {
            switch (item.getOperator()) {
                case "like":
                    cr.add(Restrictions.like(item.getProperty(), item.getValue()));
                    break;
                default:
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                    break;
            }
        });
        cr.addOrder(Order.desc("idPpago"));
        cr.setFirstResult(0);

        List result = cr.list();
        PrestamoPago prestamoPago = !result.isEmpty() ? (PrestamoPago) result.get(0) : null;
        return prestamoPago;
    }

    @Override
    public List<PrestamoPago> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoPago> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PrestamoPago.class);
        if (filters != null) {
            filters.forEach(item -> {
                switch (item.getOperator()) {
                    case "like":
                        cr.add(Restrictions.like(item.getProperty(), item.getValue()));
                        break;
                    default:
                        cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                        break;
                }
            });
        }
        if (sorts != null) {
            sorts.forEach(item -> {
                cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
            });
        }
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PrestamoPago.class);
        if (filters != null) {
            filters.forEach(item -> {
                switch (item.getOperator()) {
                    case "like":
                        cr.add(Restrictions.like(item.getProperty(), item.getValue()));
                        break;
                    default:
                        cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                        break;
                }
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }
    
}