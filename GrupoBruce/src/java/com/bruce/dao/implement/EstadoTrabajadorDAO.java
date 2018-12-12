/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEstadoTrabajadorDAO;
import com.bruce.dao.to.EstadoTrabajador;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class EstadoTrabajadorDAO implements IEstadoTrabajadorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EstadoTrabajador> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(EstadoTrabajador.class);
        if(filters!=null){
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        if (sorts != null) {
            sorts.forEach(item -> {
                cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
            });
        }
        return cr.list();
    }

    @Override
    public void create(EstadoTrabajador t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EstadoTrabajador t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EstadoTrabajador t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EstadoTrabajador get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstadoTrabajador> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EstadoTrabajador");
        return query.list();
    }

    @Override
    public EstadoTrabajador lastByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
