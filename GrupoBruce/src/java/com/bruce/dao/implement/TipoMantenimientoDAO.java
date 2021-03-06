/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoMantenimientoDAO;
import com.bruce.dao.to.TipoMantenimiento;
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
public class TipoMantenimientoDAO implements ITipoMantenimientoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TipoMantenimiento> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoMantenimiento.class);
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
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoMantenimiento.class);
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

    @Override
    public TipoMantenimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        TipoMantenimiento tipoMantenimiento = null;
        Criteria cr = session.createCriteria(TipoMantenimiento.class);
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
        cr.addOrder(Order.desc("idTmantenimiento"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            tipoMantenimiento = (TipoMantenimiento) result.get(0);
        }
        return tipoMantenimiento;
    }

    @Override
    public void create(TipoMantenimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoMantenimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoMantenimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoMantenimiento get(Object idT) {
        return (TipoMantenimiento) sf.getCurrentSession().get(TipoMantenimiento.class, (Serializable) sf);
    }

    @Override
    public List<TipoMantenimiento> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
