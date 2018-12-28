/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IRolDAO;
import com.bruce.dao.to.Rol;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class RolDAO implements IRolDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    @Transactional
    public void create(Rol t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    @Transactional
    public void update(Rol t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    @Transactional
    public void delete(Rol t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    @Transactional
    public Rol get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Rol lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Rol entity = null;
        Criteria cr = session.createCriteria(Rol.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idRol"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            entity = (Rol) result.get(0);
        }
        return entity;
    }

    @Override
    @Transactional
    public List<Rol> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Rol");
        return query.list();
    }

    @Override
    @Transactional
    public List<Rol> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Rol.class);
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
        return cr.list();
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Rol.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }
}
