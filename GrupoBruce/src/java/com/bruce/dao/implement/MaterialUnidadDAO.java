/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMaterialUnidadDAO;
import com.bruce.dao.to.MaterialUnidad;
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
public class MaterialUnidadDAO implements IMaterialUnidadDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(MaterialUnidad t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(MaterialUnidad t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(MaterialUnidad t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public MaterialUnidad get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaterialUnidad lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("MATERIAL_UNIDAD", "MU");
        reverse.addResult("MU.ID_MATERIAL");
        reverse.addResult("MU.ID_UMEDIDA");
        reverse.addResult("MU.PRECIO");
        reverse.addResult("MU.BASE");
        reverse.addResult("MU.EQUIVALENCIA");
        reverse.addResult("UM.DENOMINACION");
        reverse.addJoin("INNER JOIN UNIDAD_MEDIDA UM", "UM.ID_UMEDIDA=MU.ID_UMEDIDA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_UMEDIDA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(MaterialUnidad.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        MaterialUnidad item = !result.isEmpty() ? (MaterialUnidad) result.get(0) : null;
        return item;
    }

    @Override
    public List<MaterialUnidad> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialUnidad> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("MATERIAL_UNIDAD", "MU");
        reverse.addResult("MU.ID_MATERIAL");
        reverse.addResult("MU.ID_UMEDIDA");
        reverse.addResult("MU.PRECIO");
        reverse.addResult("MU.BASE");
        reverse.addResult("MU.EQUIVALENCIA");
        reverse.addResult("UM.DENOMINACION");
        reverse.addJoin("INNER JOIN UNIDAD_MEDIDA UM", "UM.ID_UMEDIDA=MU.ID_UMEDIDA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(MaterialUnidad.class);
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
        ReverseQuery reverse = new ReverseQuery("MATERIAL_UNIDAD", "MU");
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
