/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEntidadDAO;
import com.bruce.dao.design.IEquipoInformaticoDAO;
import com.bruce.dao.to.EquipoInformatico;
import com.bruce.dao.to.EquipoInformatico;
import com.bruce.util.FilterPage;
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
 * @author RICARDO
 */
@Repository
public class EquipoInformaticoDAO implements IEquipoInformaticoDAO{

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EquipoInformatico> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EquipoInformatico.class);
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
        Criteria cr = session.createCriteria(EquipoInformatico.class);
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
    public EquipoInformatico lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        EquipoInformatico equipoInformatico = null;
        Criteria cr = session.createCriteria(EquipoInformatico.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idEinformatico"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            equipoInformatico = (EquipoInformatico) result.get(0);
        }
        return equipoInformatico;
    }

    @Override
    public void create(EquipoInformatico t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EquipoInformatico t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EquipoInformatico t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EquipoInformatico find(Object idT) {
        return (EquipoInformatico) sf.getCurrentSession().get(EquipoInformatico.class, (Serializable) sf);
    }

    @Override
    public List<EquipoInformatico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
