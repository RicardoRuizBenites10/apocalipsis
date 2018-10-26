/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoEstudioDAO;
import com.bruce.dao.to.TipoEstudio;
import com.bruce.dao.to.TipoEstudio;
import com.bruce.util.FilterPage;
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
 * @author SISTEMAS
 */
@Repository
public class TipoEstudioDAO implements ITipoEstudioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(TipoEstudio t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoEstudio t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoEstudio t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoEstudio find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoEstudio> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoEstudio");
        return query.list();
    }

    @Override
    public List<TipoEstudio> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoEstudio.class);
        if (filters != null) {
            filters.forEach(item -> {
                if (item.getOperator() == null || item.getOperator().equals("")) {
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                } else {
                    switch (item.getOperator()) {
                        case "like":
                            cr.add(Restrictions.like(item.getProperty(), item.getValue() + "%"));
                            break;
                        default:
                            cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                            break;
                    }
                }
            });
        }
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoEstudio.class);
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
    public TipoEstudio lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        TipoEstudio tipoEstudio = null;
        Criteria cr = session.createCriteria(TipoEstudio.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idTipoEstudio"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            tipoEstudio = (TipoEstudio) result.get(0);
        }
        return tipoEstudio;
    }

}
