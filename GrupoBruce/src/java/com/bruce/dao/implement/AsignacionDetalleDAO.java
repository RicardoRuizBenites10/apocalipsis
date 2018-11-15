/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsignacionDetalleDAO;
import com.bruce.dao.to.AsignacionDetalle;
import com.bruce.util.FilterPage;
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
public class AsignacionDetalleDAO implements IAsignacionDetalleDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<AsignacionDetalle> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(AsignacionDetalle.class);
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
        Criteria cr = session.createCriteria(AsignacionDetalle.class);
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
    public AsignacionDetalle lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        AsignacionDetalle asigancionDetalle = null;
        Criteria cr = session.createCriteria(AsignacionDetalle.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idEinformatico"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            asigancionDetalle = (AsignacionDetalle) result.get(0);
        }
        return asigancionDetalle;
    }

    @Override
    public void create(AsignacionDetalle t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(AsignacionDetalle t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(AsignacionDetalle t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public AsignacionDetalle find(Object idT) {
        return (AsignacionDetalle) sf.getCurrentSession().get(AsignacionDetalle.class, (Serializable) sf);
    }

    @Override
    public List<AsignacionDetalle> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
