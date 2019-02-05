/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IActividadDAO;
import com.bruce.dao.to.Actividad;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class ActividadDAO implements IActividadDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Actividad t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Actividad t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Actividad t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Actividad get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actividad lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD", "A");
        reverse.addResult("A.ID_ACTIVIDAD");
        reverse.addResult("A.FECHA");
        reverse.addResult("A.NOMBRE");
        reverse.addResult("A.DURACION");
        reverse.addResult("A.PRECIO");
        reverse.addResult("A.SITUACION");
        reverse.addResult("A.ID_MONEDA");
        reverse.addResult("A.ID_EPROCESO");
        reverse.addResult("A.USA_MATERIAL");
        reverse.addResult("A.ID_USUARIO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("FECHA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Actividad.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Actividad actividad = !result.isEmpty() ? (Actividad) result.get(0) : null;
        return actividad;
    }

    @Override
    public List<Actividad> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Actividad> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD", "A");
        reverse.addResult("A.ID_ACTIVIDAD");
        reverse.addResult("A.FECHA");
        reverse.addResult("A.NOMBRE");
        reverse.addResult("A.DURACION");
        reverse.addResult("A.PRECIO");
        reverse.addResult("A.SITUACION");
        reverse.addResult("A.ID_MONEDA");
        reverse.addResult("A.ID_EPROCESO");
        reverse.addResult("A.USA_MATERIAL");
        reverse.addResult("A.ID_USUARIO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Actividad.class);
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
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD", "A");
        reverse.addResult("A.ID_ACTIVIDAD");
        reverse.addResult("A.FECHA");
        reverse.addResult("A.NOMBRE");
        reverse.addResult("A.DURACION");
        reverse.addResult("A.PRECIO");
        reverse.addResult("A.SITUACION");
        reverse.addResult("A.ID_MONEDA");
        reverse.addResult("A.ID_EPROCESO");
        reverse.addResult("A.USA_MATERIAL");
        reverse.addResult("A.ID_USUARIO");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Actividad.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list().size();
    }

}
