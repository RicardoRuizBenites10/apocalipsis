/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IFormacionDAO;
import com.bruce.dao.to.Formacion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
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
public class FormacionDAO implements IFormacionDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Formacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Formacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Formacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Formacion find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formacion> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Formacion");
        return query.list();
    }

    @Override
    public List<Formacion> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Formacion.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Formacion.class);
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
    public Formacion lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Formacion formacion = null;
        Criteria cr = session.createCriteria(Formacion.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idFormacion"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            formacion = (Formacion) result.get(0);
        }
        return formacion;
    }

}
