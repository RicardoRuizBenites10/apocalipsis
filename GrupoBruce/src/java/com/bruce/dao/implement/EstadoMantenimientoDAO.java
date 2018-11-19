/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEstadoMantenimientoDAO;
import com.bruce.dao.to.EstadoMantenimiento;
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
 * @author SISTEMAS
 */
@Repository
public class EstadoMantenimientoDAO implements IEstadoMantenimientoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EstadoMantenimiento> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EstadoMantenimiento.class);
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
        Criteria cr = session.createCriteria(EstadoMantenimiento.class);
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
    public EstadoMantenimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        EstadoMantenimiento estadoMantenimiento = null;
        Criteria cr = session.createCriteria(EstadoMantenimiento.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idEmantenimiento"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            estadoMantenimiento = (EstadoMantenimiento) result.get(0);
        }
        return estadoMantenimiento;
    }

    @Override
    public void create(EstadoMantenimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EstadoMantenimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EstadoMantenimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EstadoMantenimiento find(Object idT) {
        return (EstadoMantenimiento) sf.getCurrentSession().get(EstadoMantenimiento.class, (Serializable) idT);
    }

    @Override
    public List<EstadoMantenimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
