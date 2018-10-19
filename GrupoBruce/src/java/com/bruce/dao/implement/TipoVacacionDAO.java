/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoVacacionDAO;
import com.bruce.dao.to.TipoVacacion;
import com.bruce.util.FilterPage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class TipoVacacionDAO implements ITipoVacacionDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public void create(TipoVacacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoVacacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoVacacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoVacacion find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoVacacion> findAll() {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoVacacion.class);
        return cr.list();
    }

    @Override
    public List<TipoVacacion> getByFilter(int start, int limit, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoVacacion.class);
        if(filters!=null){
            filters.forEach(item->{
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoVacacion.class);
        if(filters!=null){
            filters.forEach(item->{
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }
    
}
