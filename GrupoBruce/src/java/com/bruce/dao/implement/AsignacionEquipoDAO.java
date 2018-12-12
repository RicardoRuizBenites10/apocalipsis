/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsignacionEquipoDAO;
import com.bruce.dao.to.AsignacionEquipo;
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
public class AsignacionEquipoDAO implements IAsignacionEquipoDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<AsignacionEquipo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(AsignacionEquipo.class, "aseq");
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(AsignacionEquipo.class);
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
    public AsignacionEquipo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        AsignacionEquipo asignacionEquipo = null;
        Criteria cr = session.createCriteria(AsignacionEquipo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idAequipo"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            asignacionEquipo = (AsignacionEquipo) result.get(0);
        }
        return asignacionEquipo;
    }

    @Override
    public void create(AsignacionEquipo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(AsignacionEquipo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(AsignacionEquipo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public AsignacionEquipo get(Object idT) {
        return (AsignacionEquipo) sf.getCurrentSession().get(AsignacionEquipo.class, (Serializable) sf);
    }

    @Override
    public List<AsignacionEquipo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
