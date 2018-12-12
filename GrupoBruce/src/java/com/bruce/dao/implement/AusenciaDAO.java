/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAusenciaDAO;
import com.bruce.dao.to.Ausencia;
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
 * @author RICARDO
 */
@Repository
public class AusenciaDAO implements IAusenciaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Ausencia> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Ausencia.class);
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
        Criteria cr = session.createCriteria(Ausencia.class);
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
    public Ausencia lastByFilter(List<FilterPage> filters) {
        Ausencia ausencia = null;
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Ausencia.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idAusencia"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            ausencia = (Ausencia) result.get(0);
        }
        return ausencia;
    }

    @Override
    public void create(Ausencia t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Ausencia t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Ausencia t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Ausencia get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ausencia> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
