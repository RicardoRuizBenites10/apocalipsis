/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.to.Asistencia;
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
public class AsistenciaDAO implements IAsistenciaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Asistencia> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("A.ID_TRABAJADOR");
        reverse.addResult("A.ID_ASISTENCIA");
        reverse.addResult("A.FECHA");
        reverse.addResult("A.MARCA1");
        reverse.addResult("A.MARCA2");
        reverse.addResult("A.MARCA3");
        reverse.addResult("A.MARCA4");
        reverse.addResult("A.MARCA5");
        reverse.addResult("A.MARCA6");
        reverse.addResult("A.MARCA7");
        reverse.addResult("A.ANIO");
        reverse.addResult("A.MES");
        reverse.addResult("A.DIA");
        reverse.addResult("A.PERMISO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("INNER JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Asistencia.class);
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
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("A.ID_TRABAJADOR");
        reverse.addResult("A.ID_ASISTENCIA");
        reverse.addResult("A.FECHA");
        reverse.addResult("A.MARCA1");
        reverse.addResult("A.MARCA2");
        reverse.addResult("A.MARCA3");
        reverse.addResult("A.MARCA4");
        reverse.addResult("A.MARCA5");
        reverse.addResult("A.MARCA6");
        reverse.addResult("A.MARCA7");
        reverse.addResult("A.ANIO");
        reverse.addResult("A.MES");
        reverse.addResult("A.DIA");
        reverse.addResult("A.PERMISO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("INNER JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Asistencia.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list().size();
    }

    @Override
    public Asistencia lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("A.ID_TRABAJADOR");
        reverse.addResult("A.ID_ASISTENCIA");
        reverse.addResult("A.FECHA");
        reverse.addResult("A.MARCA1");
        reverse.addResult("A.MARCA2");
        reverse.addResult("A.MARCA3");
        reverse.addResult("A.MARCA4");
        reverse.addResult("A.MARCA5");
        reverse.addResult("A.MARCA6");
        reverse.addResult("A.MARCA7");
        reverse.addResult("A.ANIO");
        reverse.addResult("A.MES");
        reverse.addResult("A.DIA");
        reverse.addResult("A.PERMISO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("INNER JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_ASISTENCIA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Asistencia.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Asistencia asistencia =  !result.isEmpty() ? (Asistencia)result.get(0) : null;
        return asistencia;
    }

    @Override
    public void create(Asistencia t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Asistencia t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Asistencia t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Asistencia get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asistencia> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
