/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEntidadFinancieraDAO;
import com.bruce.dao.to.EntidadFinanciera;
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
public class EntidadFinancieraDAO implements IEntidadFinancieraDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EntidadFinanciera> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EntidadFinanciera.class);
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
    public void create(EntidadFinanciera t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EntidadFinanciera t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EntidadFinanciera t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EntidadFinanciera get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadFinanciera> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EntidadFinanciera");
        return query.list();
    }

    @Override
    public EntidadFinanciera lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        EntidadFinanciera entity = null;
        Criteria cr = session.createCriteria(EntidadFinanciera.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idEfinanciera"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            entity = (EntidadFinanciera) result.get(0);
        }
        return entity;
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EntidadFinanciera.class);
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
