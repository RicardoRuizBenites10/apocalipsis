/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.dao.design.IPeriodoPlanillaDAO;
import com.bruce.dao.to.PeriodoPlanilla;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
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
public class PeriodoPlanillaDAO implements IPeriodoPlanillaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<PeriodoPlanilla> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PeriodoPlanilla.class);
        if (filters != null) {
            filters.forEach(item -> {
                switch (item.getOperator()) {
                    case "like":
                        cr.add(Restrictions.like(item.getProperty(), item.getValue()));
                        break;
                    default:
                        cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                        break;
                }
            });
        }
        if (sorts != null) {
            sorts.forEach(item -> {
                cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
            });
        }
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public void create(PeriodoPlanilla t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(PeriodoPlanilla t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(PeriodoPlanilla t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public PeriodoPlanilla get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PeriodoPlanilla> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM PeriodoPlanilla");
        return query.list();
    }

    @Override
    public PeriodoPlanilla lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PeriodoPlanilla.class);
        filters.forEach(item -> {
            switch (item.getOperator()) {
                case "like":
                    cr.add(Restrictions.like(item.getProperty(), item.getValue()));
                    break;
                default:
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                    break;
            }
        });
        cr.addOrder(Order.desc("idPplanilla"));
        cr.setFirstResult(0);

        List result = cr.list();
        PeriodoPlanilla periodoPlanilla = !result.isEmpty() ? (PeriodoPlanilla) result.get(0) : null;
        return periodoPlanilla;
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PeriodoPlanilla.class);
        if (filters != null) {
            filters.forEach(item -> {
                switch (item.getOperator()) {
                    case "like":
                        cr.add(Restrictions.like(item.getProperty(), item.getValue()));
                        break;
                    default:
                        cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                        break;
                }
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }

}
