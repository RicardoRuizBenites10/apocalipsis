/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ISituacionDAO;
import com.bruce.dao.to.Situacion;
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
public class SituacionDAO implements ISituacionDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Situacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Situacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Situacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Situacion get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Situacion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Situacion> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Situacion.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
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
    public Situacion lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Situacion situacion = null;
        Criteria cr = session.createCriteria(Situacion.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }        
        cr.addOrder(Order.desc("idSituacion"));
        cr.setFirstResult(0);
        List result = cr.list();
        if (result.size() > 0) {
            situacion = (Situacion) result.get(0);
        }
        return situacion;
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Situacion.class);
        filters.forEach(item -> {
            cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
        });
        cr.setProjection(Projections.rowCount());
        return ((Long) cr.list().get(0)).intValue();
    }

}
