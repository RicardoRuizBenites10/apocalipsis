/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IContratistaDAO;
import com.bruce.dao.to.Contratista;
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
public class ContratistaDAO implements IContratistaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Contratista t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Contratista t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Contratista t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Contratista get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contratista lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONTRATISTA", "C");
        reverse.addResult("C.ID_CONTRATISTA");
        reverse.addResult("C.NOMBRE");
        reverse.addResult("C.DIRECCION");
        reverse.addResult("C.TELEFONO");
        reverse.addResult("C.CORREO");
        reverse.addResult("C.SITUACION");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CONTRATISTA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Contratista.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Contratista contratista = !result.isEmpty() ? (Contratista) result.get(0) : null;
        
        return contratista;
    }

    @Override
    public List<Contratista> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contratista> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONTRATISTA", "C");
        reverse.addResult("C.ID_CONTRATISTA");
        reverse.addResult("C.NOMBRE");
        reverse.addResult("C.DIRECCION");
        reverse.addResult("C.TELEFONO");
        reverse.addResult("C.CORREO");
        reverse.addResult("C.SITUACION");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Contratista.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                if ((item.getOperator().equalsIgnoreCase("in") || item.getOperator().equalsIgnoreCase("nin")) && item.getValue() != null) {
                    query.setParameterList(item.getProperty(), item.getValue().toString().split(","));
                } else {
                    query.setParameter(item.getProperty(), item.getValue());
                }
            });
        }
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONTRATISTA", "C");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                if ((item.getOperator().equalsIgnoreCase("in") || item.getOperator().equalsIgnoreCase("nin")) && item.getValue() != null) {
                    query.setParameterList(item.getProperty(), item.getValue().toString().split(","));
                } else {
                    query.setParameter(item.getProperty(), item.getValue());
                }
            });
        }
        List result = query.list();
        return (int) result.get(0);
    }

}
