/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITExtralaboralDAO;
import com.bruce.dao.to.Textralaboral;
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
public class TExtralaboralDAO implements ITExtralaboralDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Textralaboral t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Textralaboral t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Textralaboral t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Textralaboral get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Textralaboral lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("TEXTRALABORAL", "TX");
        reverse.addResult("TX.ID_TRABAJADOR");
        reverse.addResult("TX.FECHA");
        reverse.addResult("TX.HORA_INICIO");
        reverse.addResult("TX.HORA_SALIDA");
        reverse.addResult("TX.DESCRIPCION");
        reverse.addResult("TX.ID_ACTIVIDAD");
        reverse.addResult("TX.ID_TTEXTRA");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = TX.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_TEXTRALABORAL", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Textralaboral.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Textralaboral textralaboral =  !result.isEmpty() ? (Textralaboral)result.get(0) : null;
        return textralaboral;
    }

    @Override
    public List<Textralaboral> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Textralaboral> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("TEXTRALABORAL", "TX");
        reverse.addResult("TX.ID_TRABAJADOR");
        reverse.addResult("TX.FECHA");
        reverse.addResult("TX.HORA_INICIO");
        reverse.addResult("TX.HORA_SALIDA");
        reverse.addResult("TX.DESCRIPCION");
        reverse.addResult("TX.ID_ACTIVIDAD");
        reverse.addResult("TX.ID_TTEXTRA");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = TX.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Textralaboral.class);
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
        ReverseQuery reverse = new ReverseQuery("TEXTRALABORAL", "TX");
        reverse.addResult("TX.ID_TRABAJADOR");
        reverse.addResult("TX.FECHA");
        reverse.addResult("TX.HORA_INICIO");
        reverse.addResult("TX.HORA_SALIDA");
        reverse.addResult("TX.DESCRIPCION");
        reverse.addResult("TX.ID_ACTIVIDAD");
        reverse.addResult("TX.ID_TTEXTRA");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "T.ID_TRABAJADOR = TX.ID_TRABAJADOR");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Textralaboral.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list().size();
    }
    
}
