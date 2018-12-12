/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITiempoContratoDAO;
import com.bruce.dao.to.Empresa;
import com.bruce.dao.to.TiempoContrato;
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
 * @author RICARDO
 */
@Repository
public class TiempoContratoDAO implements ITiempoContratoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TiempoContrato> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TiempoContrato.class);
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
    public void create(TiempoContrato t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TiempoContrato t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TiempoContrato t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TiempoContrato get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TiempoContrato> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TiempoContrato");
        return query.list();
    }

    @Override
    public TiempoContrato lastByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
