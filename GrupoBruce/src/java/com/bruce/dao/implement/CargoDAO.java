/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ICargoDAO;
import com.bruce.dao.to.Cargo;
import java.util.List;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
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
public class CargoDAO implements ICargoDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<Cargo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Cargo.class);
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
        Criteria cr = session.createCriteria(Cargo.class);
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
    public Cargo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Cargo cargo = null;
        Criteria cr = session.createCriteria(Cargo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idCargo"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            cargo = (Cargo) result.get(0);
        }
        return cargo;    
    }

    @Override
    public void create(Cargo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Cargo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Cargo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Cargo get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cargo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
