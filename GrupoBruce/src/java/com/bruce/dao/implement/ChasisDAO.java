/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IChasisDAO;
import com.bruce.dao.to.Chasis;
import com.bruce.dao.to.Chasis;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class ChasisDAO implements IChasisDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Chasis t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Chasis t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Chasis t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Chasis get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chasis lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CHASIS", "CH");
        reverse.addResult("CH.ID_CHASIS");
        reverse.addResult("CH.MODELO");
        reverse.addResult("CH.DDEE");
        reverse.addResult("CH.ID_CHAPRO");
        reverse.addResult("CH.ID_CARMOD");
        reverse.addResult("CHP.DESCRIPCION PROVEEDOR");
        reverse.addResult("CM.DESCRIPCION CARROCERIA");
        reverse.addJoin("INNER JOIN CHASIS_PROVEEDOR CHP", "CHP.ID_CHAPRO=CH.ID_CHAPRO");
        reverse.addJoin("INNER JOIN CARROCERIA_MODELO CM", "CM.ID_CARMOD=CH.ID_CARMOD");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CHASIS", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Chasis.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Chasis item = !result.isEmpty() ? (Chasis) result.get(0) : null;
        return item;
    }

    @Override
    public List<Chasis> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chasis> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CHASIS", "CH");
        reverse.addResult("CH.ID_CHASIS");
        reverse.addResult("CH.MODELO");
        reverse.addResult("CH.DDEE");
        reverse.addResult("CH.ID_CHAPRO");
        reverse.addResult("CH.ID_CARMOD");
        reverse.addResult("CHP.DESCRIPCION PROVEEDOR");
        reverse.addResult("CM.DESCRIPCION CARROCERIA");
        reverse.addJoin("INNER JOIN CHASIS_PROVEEDOR CHP", "CHP.ID_CHAPRO=CH.ID_CHAPRO");
        reverse.addJoin("INNER JOIN CARROCERIA_MODELO CM", "CM.ID_CARMOD=CH.ID_CARMOD");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Chasis.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CHASIS", "CH");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        return (int) result.get(0);
    }
    
}
