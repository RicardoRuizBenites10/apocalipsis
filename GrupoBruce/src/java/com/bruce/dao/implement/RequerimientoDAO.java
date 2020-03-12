/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IRequerimientoDAO;
import com.bruce.dao.to.Requerimiento;
import com.bruce.dao.to.Requerimiento;
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
public class RequerimientoDAO implements IRequerimientoDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Requerimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Requerimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Requerimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Requerimiento get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Requerimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("REQUERIMIENTO", "R");
        reverse.addResult("R.ID_REQUERIMIENTO");
        reverse.addResult("R.FECHA_GENERADO");
        reverse.addResult("R.FECHA_PROGRAMADO");
        reverse.addResult("R.EXTORNADO");
        reverse.addResult("R.REQUERIDO");
        reverse.addResult("R.DESPACHADO");
        reverse.addResult("R.ID_OBRA");
        reverse.addResult("R.ID_TRABAJADOR");
        reverse.addResult("R.ID_ESPECIFICACION");
        reverse.addResult("R.ID_ACTIVIDAD");
        reverse.addResult("R.ID_USUARIO");
        reverse.addResult("A.NOMBRE ACTIVIDAD");
        reverse.addResult("T.AP_PATERNO + ' ' + T.AP_MATERNO + ' ' + T.NOMBRES TRABAJADOR");
        reverse.addJoin("INNER JOIN OBRA O", "R.ID_OBRA=O.ID_OBRA");
        reverse.addJoin("INNER JOIN ACTIVIDAD A", "R.ID_ACTIVIDAD=A.ID_ACTIVIDAD");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "R.ID_TRABAJADOR=T.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_REQUERIMIENTO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Requerimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Requerimiento item = !result.isEmpty() ? (Requerimiento) result.get(0) : null;
        return item;
    }

    @Override
    public List<Requerimiento> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Requerimiento> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("REQUERIMIENTO", "R");
        reverse.addResult("R.ID_REQUERIMIENTO");
        reverse.addResult("R.FECHA_GENERADO");
        reverse.addResult("R.FECHA_PROGRAMADO");
        reverse.addResult("R.EXTORNADO");
        reverse.addResult("R.REQUERIDO");
        reverse.addResult("R.DESPACHADO");
        reverse.addResult("R.ID_OBRA");
        reverse.addResult("R.ID_TRABAJADOR");
        reverse.addResult("R.ID_ESPECIFICACION");
        reverse.addResult("R.ID_ACTIVIDAD");
        reverse.addResult("R.ID_USUARIO");
        reverse.addResult("A.NOMBRE ACTIVIDAD");
        reverse.addResult("T.AP_PATERNO + ' ' + T.AP_MATERNO + ' ' + T.NOMBRES TRABAJADOR");
        reverse.addJoin("INNER JOIN OBRA O", "R.ID_OBRA=O.ID_OBRA");
        reverse.addJoin("INNER JOIN ACTIVIDAD A", "R.ID_ACTIVIDAD=A.ID_ACTIVIDAD");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "R.ID_TRABAJADOR=T.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Requerimiento.class);
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
        ReverseQuery reverse = new ReverseQuery("REQUERIMIENTO", "R");
        reverse.addJoin("INNER JOIN OBRA O", "R.ID_OBRA=O.ID_OBRA");
        reverse.addJoin("INNER JOIN ACTIVIDAD A", "R.ID_ACTIVIDAD=A.ID_ACTIVIDAD");
        reverse.addJoin("INNER JOIN TRABAJADOR T", "R.ID_TRABAJADOR=T.ID_TRABAJADOR");
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
