/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ICategoriaOcupacionalDAO;
import com.bruce.dao.to.CategoriaOcupacional;
import com.bruce.dao.to.TipoTrabajador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class CategoriaOcupacionalDAO implements ICategoriaOcupacionalDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<CategoriaOcupacional> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoTrabajador.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
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
    public void create(CategoriaOcupacional t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(CategoriaOcupacional t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(CategoriaOcupacional t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public CategoriaOcupacional get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoriaOcupacional> getAll() {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoTrabajador.class);
        return cr.list();
    }

    @Override
    public CategoriaOcupacional lastByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
