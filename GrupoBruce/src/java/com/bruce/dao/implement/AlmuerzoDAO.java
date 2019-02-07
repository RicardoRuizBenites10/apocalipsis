/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAlmuerzoDAO;
import com.bruce.dao.to.Almuerzo;
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
public class AlmuerzoDAO implements IAlmuerzoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Almuerzo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Almuerzo t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(Almuerzo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Almuerzo get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Almuerzo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ALMUERZO", "A");
        reverse.addResult("T.ID_TRABAJADOR");
        reverse.addResult("ISNULL(A.FECHA,:FECHA) FECHA");
        reverse.addResult("ISNULL(A.REFRIGERIO,1) REFRIGERIO");
        reverse.addResult("ISNULL(A.EN_COMEDOR,1) EN_COMEDOR");
        reverse.addResult("ISNULL(A.PROCESADO,0) PROCESADO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("RIGHT JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("FECHA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Almuerzo.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Almuerzo almuerzo = !result.isEmpty() ? (Almuerzo) result.get(0) : null;
        return almuerzo;
    }

    @Override
    public List<Almuerzo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Almuerzo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ALMUERZO", "A");
        reverse.addResult("T.ID_TRABAJADOR");
        reverse.addResult("ISNULL(A.FECHA,:FECHA) FECHA");
        reverse.addResult("ISNULL(A.REFRIGERIO,1) REFRIGERIO");
        reverse.addResult("ISNULL(A.EN_COMEDOR,1) EN_COMEDOR");
        reverse.addResult("ISNULL(A.PROCESADO,0) PROCESADO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("RIGHT JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR AND A.FECHA = :FECHA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Almuerzo.class);
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
        ReverseQuery reverse = new ReverseQuery("ALMUERZO", "A");
        reverse.addJoin("RIGHT JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR AND A.FECHA = :FECHA");
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
