/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoEquipoDAO;
import com.bruce.dao.to.TipoEquipo;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.io.Serializable;
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
public class TipoEquipoDAO implements ITipoEquipoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TipoEquipo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoEquipo.class);
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
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoEquipo.class);
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
    public TipoEquipo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        TipoEquipo tipoEquipo = null;
        Criteria cr = session.createCriteria(TipoEquipo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idTequipo"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            tipoEquipo = (TipoEquipo) result.get(0);
        }
        return tipoEquipo;
    }

    @Override
    public void create(TipoEquipo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoEquipo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoEquipo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoEquipo get(Object idT) {
        return (TipoEquipo) sf.getCurrentSession().get(TipoEquipo.class, (Serializable) sf);
    }

    @Override
    public List<TipoEquipo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
