/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IObraPinturaDAO;
import com.bruce.dao.to.ObraPintura;
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
public class ObraPinturaDAO implements IObraPinturaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ObraPintura t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ObraPintura t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(ObraPintura t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ObraPintura get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObraPintura lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA_PINTURA", "OP");
        reverse.addResult("OP.ID_OBRA");
        reverse.addResult("OP.ID_CDISENO");
        reverse.addResult("OP.FECHA");
        reverse.addResult("CD.DENOMINACION COLORDISENO");
        reverse.addJoin("INNER JOIN COLOR_DISENO CD", "CD.ID_CDISENO=OP.ID_CDISENO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CDISENO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ObraPintura.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ObraPintura item = !result.isEmpty() ? (ObraPintura) result.get(0) : null;
        return item;
    }

    @Override
    public List<ObraPintura> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObraPintura> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA_PINTURA", "OP");
        reverse.addResult("OP.ID_OBRA");
        reverse.addResult("OP.ID_CDISENO");
        reverse.addResult("OP.FECHA");
        reverse.addResult("CD.DENOMINACION COLORDISENO");
        reverse.addJoin("INNER JOIN COLOR_DISENO CD", "CD.ID_CDISENO=OP.ID_CDISENO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ObraPintura.class);
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
        ReverseQuery reverse = new ReverseQuery("OBRA_PINTURA", "OP");
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
