/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEtapaProcesoDAO;
import com.bruce.dao.to.EtapaProceso;
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
 * @author SISTEMAS
 */
@Repository
public class EtapaProcesoDAO implements IEtapaProcesoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(EtapaProceso t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EtapaProceso t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EtapaProceso t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EtapaProceso get(Object idT) {
        return (EtapaProceso) sf.getCurrentSession().get(EtapaProceso.class, (Serializable) idT);
    }

    @Override
    public EtapaProceso lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EtapaProceso.class);
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
        cr.addOrder(Order.desc("idEproceso"));
        cr.setFirstResult(0);

        List result = cr.list();
        EtapaProceso proceso = !result.isEmpty() ? (EtapaProceso) result.get(0) : null;
        return proceso;
    }

    @Override
    public List<EtapaProceso> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EtapaProceso> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EtapaProceso.class);
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
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EtapaProceso.class);
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
