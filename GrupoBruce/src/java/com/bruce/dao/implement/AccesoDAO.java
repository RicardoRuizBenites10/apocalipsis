/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAccesoDAO;
import com.bruce.dao.to.Acceso;
import java.util.List;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import com.bruce.util.QueryUtil;
import com.bruce.util.SortPage;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
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
public class AccesoDAO implements IAccesoDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Acceso acceso) {
        sf.getCurrentSession().save(acceso);
    }

    @Override
    public void update(Acceso acceso) {
        sf.getCurrentSession().update(acceso);
    }

    @Override
    public void delete(Acceso acceso) {
        sf.getCurrentSession().delete(acceso);
    }

    @Override
    public Acceso get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceso lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Acceso acceso = null;
        Criteria cr = session.createCriteria(Acceso.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idAcceso"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            acceso = (Acceso) result.get(0);
        }
        return acceso;
    }

    @Override
    public List<Acceso> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("From Acceso");
        return query.list();
    }

    @Override
    public List<Acceso> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Acceso.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        return cr.list();
    }

    @Override
    public List<Acceso> getByRol(String idRol) {
        Session session = sf.getCurrentSession();
        SQLQuery query = session.createSQLQuery(QueryUtil.ACCESO_ROL);
        query.addEntity(Acceso.class);
        query.setParameter("IDROL", idRol);
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Acceso.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }
    
}
