/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IVacacionDAO;
import com.bruce.dao.to.Vacacion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RICARDO
 */
@Repository
public class VacacionDAO implements IVacacionDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Vacacion> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("VACACION", "V");
        reverse.addResult("V.ID_TRABAJADOR");
        reverse.addResult("V.ID_VACACION");
        reverse.addResult("V.FECHA_BASE");
        reverse.addResult("V.FECHA_SALIDA");
        reverse.addResult("V.FECHA_RETORNO");
        reverse.addResult("V.DIAS_TOMADOS");
        reverse.addResult("V.ID_TVACACION");
        reverse.addResult("V.ID_PVACACION");
        reverse.addResult("TV.DESCRIPCION TIPO");
        reverse.addJoin("INNER JOIN TIPO_VACACION TV", "TV.ID_TVACACION = V.ID_TVACACION");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Vacacion.class);
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
        ReverseQuery reverse = new ReverseQuery("VACACION", "V");
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

    @Override
    public Vacacion lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("VACACION", "V");
        reverse.addResult("V.ID_TRABAJADOR");
        reverse.addResult("V.ID_VACACION");
        reverse.addResult("V.FECHA_BASE");
        reverse.addResult("V.FECHA_SALIDA");
        reverse.addResult("V.FECHA_RETORNO");
        reverse.addResult("V.DIAS_TOMADOS");
        reverse.addResult("V.ID_TVACACION");
        reverse.addResult("V.ID_PVACACION");
        reverse.addResult("TV.DESCRIPCION TIPO");
        reverse.addJoin("INNER JOIN TIPO_VACACION TV", "TV.ID_TVACACION = V.ID_TVACACION");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_VACACION", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Vacacion.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        
        List result = query.list();
        Vacacion last = !result.isEmpty() ? (Vacacion) result.get(0) : null;
        return last;
    }

    @Override
    public List<Vacacion> filterYAByPeriodo(int idPeriodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vacacion> filterNAByPeriodo(int idPeriodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Vacacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Vacacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Vacacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Vacacion get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vacacion> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Vacacion");
        return query.list();
    }

}
