/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ICalendarioDAO;
import com.bruce.dao.to.Calendario;
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
 * @author RICARDO
 */
@Repository
public class CalendarioDAO implements ICalendarioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Calendario t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Calendario t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Calendario t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Calendario get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Calendario lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CALENDARIO", "C");
        reverse.addResult("C.FECHA");
        reverse.addResult("C.NRO_SEMANA");
        reverse.addResult("C.DIA");
        reverse.addResult("C.MES");
        reverse.addResult("C.ANIO");
        reverse.addResult("C.LIBRE");
        reverse.addResult("C.DESCRIPCION");
        reverse.addResult("C.HORA_SALIDA");
        reverse.addResult("C.ID_DIA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("FECHA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Calendario.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Calendario calendario =  !result.isEmpty() ? (Calendario)result.get(0) : null;
        return calendario;
    }

    @Override
    public List<Calendario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Calendario> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CALENDARIO", "C");
        reverse.addResult("C.FECHA");
        reverse.addResult("C.NRO_SEMANA");
        reverse.addResult("C.DIA");
        reverse.addResult("C.MES");
        reverse.addResult("C.ANIO");
        reverse.addResult("C.LIBRE");
        reverse.addResult("C.DESCRIPCION");
        reverse.addResult("C.HORA_SALIDA");
        reverse.addResult("C.ID_DIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Calendario.class);
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
        ReverseQuery reverse = new ReverseQuery("CALENDARIO", "C");
        reverse.addResult("C.FECHA");
        reverse.addResult("C.NRO_SEMANA");
        reverse.addResult("C.DIA");
        reverse.addResult("C.MES");
        reverse.addResult("C.ANIO");
        reverse.addResult("C.LIBRE");
        reverse.addResult("C.DESCRIPCION");
        reverse.addResult("C.HORA_SALIDA");
        reverse.addResult("C.ID_DIA");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Calendario.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list().size();
    }

}
