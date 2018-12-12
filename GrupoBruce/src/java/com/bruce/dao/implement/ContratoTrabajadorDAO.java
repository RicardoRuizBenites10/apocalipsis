/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.to.ContratoTrabajador;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class ContratoTrabajadorDAO implements IContratoTrabajadorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ContratoTrabajador t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ContratoTrabajador t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(ContratoTrabajador t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ContratoTrabajador get(Object idT) {
        Session session = sf.getCurrentSession();
        List<FilterPage> filters = (List<FilterPage>) idT;
        Criteria cr = session.createCriteria(ContratoTrabajador.class);
        filters.forEach(item -> {
            cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
        });
        return (ContratoTrabajador) cr.list();
    }

    @Override
    public List<ContratoTrabajador> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM ContratoTrabajador");
        return query.list();
    }

    @Override
    public List<ContratoTrabajador> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(ContratoTrabajador.class);
        filters.forEach(item -> {
            cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
        });
        cr.addOrder(Order.desc("idContrato"));
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(ContratoTrabajador.class);
        filters.forEach(item -> {
            cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
        });
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }

    @Override
    public ContratoTrabajador lastByFilter(List<FilterPage> filters) {
        ContratoTrabajador contrato = null;
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(ContratoTrabajador.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idContrato"));
        cr.setFirstResult(0);
        
        List result = cr.list();
        if (result.size() > 0) {
            contrato = (ContratoTrabajador) result.get(0);
        }
        return contrato;
    }

}
