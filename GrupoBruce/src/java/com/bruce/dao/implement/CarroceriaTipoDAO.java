/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ICarroceriaTipoDAO;
import com.bruce.dao.to.CarroceriaTipo;
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
public class CarroceriaTipoDAO implements ICarroceriaTipoDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(CarroceriaTipo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(CarroceriaTipo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(CarroceriaTipo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public CarroceriaTipo get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarroceriaTipo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CARROCERIA_TIPO", "CT");
        reverse.addResult("CT.ID_CARTIP");
        reverse.addResult("CT.FECHA");
        reverse.addResult("CT.CODIGO");
        reverse.addResult("CT.DESCRIPCION");
        reverse.addResult("CT.SITUACION");
        reverse.addResult("CT.ID_CARMOD");
        reverse.addResult("CM.DESCRIPCION MODELO");
        reverse.addJoin("INNER JOIN CARROCERIA_MODELO CM", "CM.ID_CARMOD=CT.ID_CARMOD");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CARTIP", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(CarroceriaTipo.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        CarroceriaTipo item = !result.isEmpty() ? (CarroceriaTipo) result.get(0) : null;
        return item;
    }

    @Override
    public List<CarroceriaTipo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarroceriaTipo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CARROCERIA_TIPO", "CT");
        reverse.addResult("CT.ID_CARTIP");
        reverse.addResult("CT.FECHA");
        reverse.addResult("CT.CODIGO");
        reverse.addResult("CT.DESCRIPCION");
        reverse.addResult("CT.SITUACION");
        reverse.addResult("CT.ID_CARMOD");
        reverse.addResult("CM.DESCRIPCION MODELO");
        reverse.addJoin("INNER JOIN CARROCERIA_MODELO CM", "CM.ID_CARMOD=CT.ID_CARMOD");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(CarroceriaTipo.class);
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
        ReverseQuery reverse = new ReverseQuery("CARROCERIA_TIPO", "CT");
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
