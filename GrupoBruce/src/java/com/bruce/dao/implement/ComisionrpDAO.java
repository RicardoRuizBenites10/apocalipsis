/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IComisionrpDAO;
import com.bruce.dao.to.Comisionrp;
import com.bruce.util.FilterPage;
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
public class ComisionrpDAO implements IComisionrpDAO {

    @Autowired(required = true)
    private SessionFactory sf;

    @Override
    public void create(Comisionrp t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comisionrp t) {
        Session session = sf.getCurrentSession();
        session.update(t);
    }

    @Override
    public void delete(Comisionrp t) {
        Session session = sf.getCurrentSession();
        session.delete(t);
    }

    @Override
    public Comisionrp find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comisionrp> findAll() {
        Session session = sf.getCurrentSession();
        List result = session.createQuery("FROM Comisionrp").list();
        return result;
    }

    @Override
    public List<Comisionrp> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Comisionrp.class);
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
        Criteria cr = session.createCriteria(Comisionrp.class);
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
    public Comisionrp lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Comisionrp comisionrp = null;
        Criteria cr = session.createCriteria(Comisionrp.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idComisionrp"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            comisionrp = (Comisionrp) result.get(0);
        }
        return comisionrp; 
    }

}
