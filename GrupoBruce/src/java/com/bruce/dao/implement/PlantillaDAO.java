/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IPlantillaDAO;
import com.bruce.dao.to.Plantilla;
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
public class PlantillaDAO implements IPlantillaDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Plantilla t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Plantilla t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Plantilla t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Plantilla get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Plantilla lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANTILLA", "PT");
        reverse.addResult("PT.ID_CARROCERIA");
        reverse.addResult("PT.ID_ESPECIFICACION");
        reverse.addResult("PT.FECHA_INSERT");
        reverse.addResult("PT.USU_INSERT");
        reverse.addResult("PT.FECHA_UPDATE");
        reverse.addResult("PT.USU_UPDATE");
        reverse.addResult("ES.DESCRIPCION ESPECIFICACION");
        reverse.addJoin("INNER JOIN ESPECIFICACION ES", "ES.ID_ESPECIFICACION=PT.ID_ESPECIFICACION");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_ESPECIFICACION", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Plantilla.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Plantilla item = !result.isEmpty() ? (Plantilla) result.get(0) : null;
        return item;
    }

    @Override
    public List<Plantilla> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Plantilla> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANTILLA", "PT");
        reverse.addResult("PT.ID_CARROCERIA");
        reverse.addResult("PT.ID_ESPECIFICACION");
        reverse.addResult("PT.FECHA_INSERT");
        reverse.addResult("PT.USU_INSERT");
        reverse.addResult("PT.FECHA_UPDATE");
        reverse.addResult("PT.USU_UPDATE");
        reverse.addResult("ES.DESCRIPCION ESPECIFICACION");
        reverse.addJoin("INNER JOIN ESPECIFICACION ES", "ES.ID_ESPECIFICACION=PT.ID_ESPECIFICACION");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Plantilla.class);
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
        ReverseQuery reverse = new ReverseQuery("PLANTILLA", "PT");
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