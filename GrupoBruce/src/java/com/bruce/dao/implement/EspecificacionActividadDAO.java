/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEspecificacionActividadDAO;
import com.bruce.dao.to.EspecificacionActividad;
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
public class EspecificacionActividadDAO implements IEspecificacionActividadDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(EspecificacionActividad t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EspecificacionActividad t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EspecificacionActividad t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EspecificacionActividad get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EspecificacionActividad lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION_ACTIVIDAD", "EA");
        reverse.addResult("EA.ID_ESPECIFICACION");
        reverse.addResult("EA.ID_ACTIVIDAD");
        reverse.addResult("EA.FECHA");
        reverse.addResult("AC.NOMBRE ACTIVIDAD");
        reverse.addResult("EP.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN ACTIVIDAD AC", "AC.ID_ACTIVIDAD=EA.ID_ACTIVIDAD");
        reverse.addJoin("INNER JOIN ETAPA_PROCESO EP", "AC.ID_EPROCESO=EP.ID_EPROCESO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_ACTIVIDAD", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(EspecificacionActividad.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        EspecificacionActividad item = !result.isEmpty() ? (EspecificacionActividad) result.get(0) : null;
        return item;
    }

    @Override
    public List<EspecificacionActividad> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EspecificacionActividad> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION_ACTIVIDAD", "EA");
        reverse.addResult("EA.ID_ESPECIFICACION");
        reverse.addResult("EA.ID_ACTIVIDAD");
        reverse.addResult("EA.FECHA");
        reverse.addResult("AC.NOMBRE ACTIVIDAD");
        reverse.addResult("EP.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN ACTIVIDAD AC", "AC.ID_ACTIVIDAD=EA.ID_ACTIVIDAD");
        reverse.addJoin("INNER JOIN ETAPA_PROCESO EP", "AC.ID_EPROCESO=EP.ID_EPROCESO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(EspecificacionActividad.class);
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
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION_ACTIVIDAD", "EA");
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
