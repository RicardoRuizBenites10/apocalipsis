/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAreaDAO;
import com.bruce.dao.to.Area;
import java.util.List;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.io.Serializable;
import org.hibernate.Criteria;
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
public class AreaDAO implements IAreaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Area> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Area.class);
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
        Criteria cr = session.createCriteria(Area.class);
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
    public Area lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Area area = null;
        Criteria cr = session.createCriteria(Area.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idArea"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            area = (Area) result.get(0);
        }
        return area;
    }

    @Override
    public void create(Area t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Area t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Area t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Area get(Object idT) {
        return (Area) sf.getCurrentSession().get(Area.class, (Serializable) idT);
    }

    @Override
    public List<Area> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
