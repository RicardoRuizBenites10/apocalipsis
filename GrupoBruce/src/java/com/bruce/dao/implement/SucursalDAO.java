/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.to.Sucursal;
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

/**
 *
 * @author RICARDO
 */
@Repository
public class SucursalDAO implements ISucursalDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Sucursal t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Sucursal t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Sucursal t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Sucursal get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sucursal> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Sucursal");
        return query.list();
    }

    @Override
    public List<Sucursal> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Sucursal.class);
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
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Sucursal.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue(); 
    }

    @Override
    public Sucursal lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Sucursal function = null;
        Criteria cr = session.createCriteria(Sucursal.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idSucursal"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            function = (Sucursal) result.get(0);
        }
        return function; 
    }

}
