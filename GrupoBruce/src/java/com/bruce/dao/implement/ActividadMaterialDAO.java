/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IActividadMaterialDAO;
import com.bruce.dao.to.ActividadMaterial;
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
public class ActividadMaterialDAO implements IActividadMaterialDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(ActividadMaterial t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ActividadMaterial t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(ActividadMaterial t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ActividadMaterial get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActividadMaterial lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD_MATERIAL", "AM");
        reverse.addResult("AM.ID_ACTIVIDAD");
        reverse.addResult("AM.ID_MATERIAL");
        reverse.addResult("AM.CANTIDAD");
        reverse.addResult("AM.ID_UMEDIDA");
        reverse.addResult("M.NOMBRE MATERIAL");
        reverse.addResult("UM.DENOMINACION UNIDAD");
        reverse.addJoin("INNER JOIN MATERIAL M", "M.ID_MATERIAL=AM.ID_MATERIAL");
        reverse.addJoin("INNER JOIN UNIDAD_MEDIDA UM", "UM.ID_UMEDIDA=AM.ID_UMEDIDA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_MATERIAL", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ActividadMaterial.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ActividadMaterial item = !result.isEmpty() ? (ActividadMaterial) result.get(0) : null;
        return item;
    }

    @Override
    public List<ActividadMaterial> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ActividadMaterial> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD_MATERIAL", "AM");
        reverse.addResult("AM.ID_ACTIVIDAD");
        reverse.addResult("AM.ID_MATERIAL");
        reverse.addResult("AM.CANTIDAD");
        reverse.addResult("AM.ID_UMEDIDA");
        reverse.addResult("M.NOMBRE MATERIAL");
        reverse.addResult("UM.DENOMINACION UNIDAD");
        reverse.addJoin("INNER JOIN MATERIAL M", "M.ID_MATERIAL=AM.ID_MATERIAL");
        reverse.addJoin("INNER JOIN UNIDAD_MEDIDA UM", "UM.ID_UMEDIDA=AM.ID_UMEDIDA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ActividadMaterial.class);
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
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD_MATERIAL", "AM");
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
