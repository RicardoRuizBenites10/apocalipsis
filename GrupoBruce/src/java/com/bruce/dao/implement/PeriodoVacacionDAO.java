/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IPeriodoVacacionDAO;
import com.bruce.dao.to.PeriodoVacacion;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Criteria;
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
public class PeriodoVacacionDAO implements IPeriodoVacacionDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<PeriodoVacacion> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PeriodoVacacion.class);
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
    public void create(PeriodoVacacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(PeriodoVacacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(PeriodoVacacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public PeriodoVacacion get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PeriodoVacacion> getAll() {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(PeriodoVacacion.class);
        return cr.list();
    }

    @Override
    public PeriodoVacacion lastByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
