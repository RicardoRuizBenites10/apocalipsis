/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEspecificacionCategoriaDAO;
import com.bruce.dao.to.EspecificacionCategoria;
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
public class EspecificacionCategoriaDAO implements IEspecificacionCategoriaDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(EspecificacionCategoria t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EspecificacionCategoria t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EspecificacionCategoria t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EspecificacionCategoria get(Object idT) {
        return (EspecificacionCategoria) sf.getCurrentSession().get(EspecificacionCategoria.class, (Serializable) idT);
    }

    @Override
    public EspecificacionCategoria lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EspecificacionCategoria.class);
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
        cr.addOrder(Order.desc("idEcategoria"));
        cr.setFirstResult(0);

        List result = cr.list();
        EspecificacionCategoria item = !result.isEmpty() ? (EspecificacionCategoria) result.get(0) : null;
        return item;
    }

    @Override
    public List<EspecificacionCategoria> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EspecificacionCategoria> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EspecificacionCategoria.class);
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
        Criteria cr = session.createCriteria(EspecificacionCategoria.class);
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
