/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IHijoDAO;
import com.bruce.dao.to.Hijo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
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
    public void create(Hijo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Hijo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Hijo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Hijo get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hijo> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Hijo");
        return query.list();
    }

    @Override
    public List<Hijo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Hijo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        if (sorts != null) {
            sorts.forEach(item -> {
                cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
            });
        }
        cr.addOrder(Order.desc("idHijo"));
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Hijo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }

    @Override
    public Hijo lastByFilter(List<FilterPage> filters) {
        Hijo hijo = null;
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Hijo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idHijo"));
        cr.setFirstResult(0);
        List result = cr.list();
        if (result.size() > 0) {
            hijo = (Hijo) result.get(0);
        }
        return hijo;
    }

}
