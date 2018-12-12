/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMantenimientoDAO;
import com.bruce.dao.to.Mantenimiento;
import com.bruce.dao.to.MantenimientoId;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
public class MantenimientoDAO implements IMantenimientoDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public List<Mantenimiento> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
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
    public Mantenimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Mantenimiento mantenimiento = null;
        Criteria cr = session.createCriteria(Mantenimiento.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idMantenimiento"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            mantenimiento = (Mantenimiento) result.get(0);
        }
        return mantenimiento;
    }

    @Override
    public void create(Mantenimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Mantenimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Mantenimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Mantenimiento get(Object idT) {
        Session session = sf.getCurrentSession();
        MantenimientoId mm = (MantenimientoId) idT;
        Query query = session.createQuery("FROM Mantenimiento WHERE idAequipo = :idAequipo AND idMantenimiento = :idMantenimiento");
        query.setParameter("idAequipo", mm.getIdAequipo());
        query.setParameter("idMantenimiento", mm.getIdMantenimiento());
        List result = query.list();
        Mantenimiento mantenimiento = result.size()>0 ? (Mantenimiento) result.get(0) : null;
        return mantenimiento;//(Mantenimiento) sf.getCurrentSession().get(Mantenimiento.class, (Serializable) sf);
    }

    @Override
    public List<Mantenimiento> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
