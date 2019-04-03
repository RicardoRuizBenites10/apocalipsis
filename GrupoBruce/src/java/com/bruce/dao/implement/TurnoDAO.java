/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITurnoDAO;
import com.bruce.dao.to.Turno;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
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
public class TurnoDAO implements ITurnoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Turno t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Turno t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Turno t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Turno get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Turno.class);
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
        cr.addOrder(Order.desc("idTurno"));
        cr.setFirstResult(0);

        List result = cr.list();
        Turno turno = !result.isEmpty() ? (Turno) result.get(0) : null;
        return turno;
    }

    @Override
    public List<Turno> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turno> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Turno.class);
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
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Turno.class);
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
