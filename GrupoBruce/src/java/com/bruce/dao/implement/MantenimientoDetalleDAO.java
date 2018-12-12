/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMantenimientoDetalleDAO;
import com.bruce.dao.to.Mantenimiento;
import com.bruce.dao.to.MantenimientoDetalle;
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
public class MantenimientoDetalleDAO implements IMantenimientoDetalleDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public List<MantenimientoDetalle> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Mantenimiento.class);
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
        Criteria cr = session.createCriteria(Mantenimiento.class);
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
    public MantenimientoDetalle lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        MantenimientoDetalle mantenimientoDetalle = null;
        Criteria cr = session.createCriteria(MantenimientoDetalle.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idEinformatico"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            mantenimientoDetalle = (MantenimientoDetalle) result.get(0);
        }
        return mantenimientoDetalle;
    }

    @Override
    public void create(MantenimientoDetalle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MantenimientoDetalle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MantenimientoDetalle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MantenimientoDetalle get(Object idT) {
        return (MantenimientoDetalle) sf.getCurrentSession().get(MantenimientoDetalle.class, (Serializable) sf);
    }

    @Override
    public List<MantenimientoDetalle> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
