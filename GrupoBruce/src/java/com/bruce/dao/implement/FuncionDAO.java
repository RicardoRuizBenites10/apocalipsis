/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IFuncionDAO;
import com.bruce.dao.to.Funcion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import org.hibernate.Criteria;
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
public class FuncionDAO implements IFuncionDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public List<Funcion> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Funcion.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Funcion.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();   
    }

    @Override
    public Funcion lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Funcion function = null;
        Criteria cr = session.createCriteria(Funcion.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idFuncion"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            function = (Funcion) result.get(0);
        }
        return function; 
    }

    @Override
    public void create(Funcion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Funcion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Funcion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Funcion find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
