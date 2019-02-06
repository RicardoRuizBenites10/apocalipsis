/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.to.TipoTextra;
import com.bruce.dao.to.TipoTextra;
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
import com.bruce.dao.design.ITipoTextraDAO;

/**
 *
 * @author RICARDO
 */
@Repository
public class TipoTextraDAO implements ITipoTextraDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(TipoTextra t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoTextra t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoTextra t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoTextra get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoTextra> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoTextra lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoTextra.class);
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
        cr.addOrder(Order.desc("idTtextra"));
        cr.setFirstResult(0);

        List result = cr.list();
        TipoTextra tipoTextra = !result.isEmpty() ? (TipoTextra) result.get(0) : null;
        return tipoTextra;
    }

    @Override
    public List<TipoTextra> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoTextra.class);
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
        Criteria cr = session.createCriteria(TipoTextra.class);
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
