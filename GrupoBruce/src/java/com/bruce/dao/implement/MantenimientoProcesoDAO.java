/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMantenimientoProcesoDAO;
import com.bruce.dao.to.MantenimientoProceso;
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
public class MantenimientoProcesoDAO implements IMantenimientoProcesoDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public List<MantenimientoProceso> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(MantenimientoProceso.class);
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
        Criteria cr = session.createCriteria(MantenimientoProceso.class);
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
    public MantenimientoProceso lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        MantenimientoProceso mantenimientoProceso = null;
        Criteria cr = session.createCriteria(MantenimientoProceso.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idMproceso"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            mantenimientoProceso = (MantenimientoProceso) result.get(0);
        }
        return mantenimientoProceso;
    }

    @Override
    public void create(MantenimientoProceso t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(MantenimientoProceso t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(MantenimientoProceso t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public MantenimientoProceso get(Object idT) {
        return (MantenimientoProceso) sf.getCurrentSession().get(MantenimientoProceso.class, (Serializable) sf);
    }

    @Override
    public List<MantenimientoProceso> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
