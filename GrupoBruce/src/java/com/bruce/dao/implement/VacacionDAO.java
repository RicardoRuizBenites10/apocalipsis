/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IVacacionDAO;
import com.bruce.dao.to.Vacacion;
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
 * @author RICARDO
 */
@Repository
public class VacacionDAO implements IVacacionDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Vacacion> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Vacacion.class);
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
        cr.addOrder(Order.desc("idPVacacion"));
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Vacacion.class);
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
    public Vacacion lastByFilter(List<FilterPage> filters) {
        Vacacion last = null;
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Vacacion.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idPVacacion"));
        cr.setFirstResult(0);

        List list = cr.list();
        if (list.size() > 0) {
            last = (Vacacion) list.get(0);
        }

        return last;
    }

    @Override
    public List<Vacacion> filterYAByPeriodo(int idPeriodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vacacion> filterNAByPeriodo(int idPeriodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Vacacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Vacacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Vacacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Vacacion get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vacacion> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Vacacion");
        return query.list();
    }

}
