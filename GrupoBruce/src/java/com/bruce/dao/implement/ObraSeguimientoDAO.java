/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IObraSeguimientoDAO;
import com.bruce.dao.to.ObraSeguimiento;
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
public class ObraSeguimientoDAO implements IObraSeguimientoDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(ObraSeguimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ObraSeguimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(ObraSeguimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ObraSeguimiento get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObraSeguimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA_SEGUIMIENTO", "OS");
        reverse.addResult("OS.ID_OBRA");
        reverse.addResult("OS.ID_EPROCESO");
        reverse.addResult("OS.INICIO_PROGRAMADO");
        reverse.addResult("OS.FIN_PROGRAMADO");
        reverse.addResult("OS.INICIO");
        reverse.addResult("OS.FIN");
        reverse.addResult("OS.OBSERVACION");
        reverse.addResult("OS.ID_USUARIO");
        reverse.addResult("EP.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN ETAPA_PROCESO EP", "EP.ID_EPROCESO=OS.ID_EPROCESO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_EPROCESO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ObraSeguimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ObraSeguimiento item = !result.isEmpty() ? (ObraSeguimiento) result.get(0) : null;
        return item;
    }

    @Override
    public List<ObraSeguimiento> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObraSeguimiento> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA_SEGUIMIENTO", "OS");
        reverse.addResult("OS.ID_OBRA");
        reverse.addResult("OS.ID_EPROCESO");
        reverse.addResult("OS.INICIO_PROGRAMADO");
        reverse.addResult("OS.FIN_PROGRAMADO");
        reverse.addResult("OS.INICIO");
        reverse.addResult("OS.FIN");
        reverse.addResult("OS.OBSERVACION");
        reverse.addResult("OS.ID_USUARIO");
        reverse.addResult("EP.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN ETAPA_PROCESO EP", "EP.ID_EPROCESO=OS.ID_EPROCESO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ObraSeguimiento.class);
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
        ReverseQuery reverse = new ReverseQuery("OBRA_SEGUIMIENTO", "OS");
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
