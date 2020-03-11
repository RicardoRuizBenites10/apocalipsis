/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IRequerimientoMaterialDAO;
import com.bruce.dao.to.RequerimientoMaterial;
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
public class RequerimientoMaterialDAO implements IRequerimientoMaterialDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(RequerimientoMaterial t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(RequerimientoMaterial t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(RequerimientoMaterial t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public RequerimientoMaterial get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RequerimientoMaterial lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD_MATERIAL", "AM");
        reverse.addResult("0 ID_REQUERIMIENTO");
        reverse.addResult("AM.ID_MATERIAL");
        reverse.addResult("AM.CANTIDAD ESTANDAR");
        reverse.addResult("AM.CANTIDAD-ISNULL(RAM.REQUERIDO,0) REQUERIDO");
        reverse.addResult("0 DESPACHADO");
        reverse.addResult("AM.ID_UMEDIDA");
        reverse.addResult("M.NOMBRE MATERIAL");
        reverse.addResult("M.STOCK");
        reverse.addResult("ISNULL(RAM.REQUERIDO,0) REQUERIDOT");
        reverse.addResult("ISNULL(RAM.DESPACHADO,0) DESPACHADOT");
        reverse.addJoin("INNER JOIN MATERIAL M", "AM.ID_MATERIAL=M.ID_MATERIAL");
        reverse.addJoin("LEFT JOIN REQUERIMIENTO_ACTIVIDAD_MATERIAL RAM", "RAM.ID_MATERIAL=M.ID_MATERIAL");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_MATERIAL", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(RequerimientoMaterial.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        RequerimientoMaterial item = !result.isEmpty() ? (RequerimientoMaterial) result.get(0) : null;
        return item;
    }

    @Override
    public List<RequerimientoMaterial> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RequerimientoMaterial> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ACTIVIDAD_MATERIAL", "AM");
        reverse.addResult("0 ID_REQUERIMIENTO");
        reverse.addResult("AM.ID_MATERIAL");
        reverse.addResult("AM.CANTIDAD ESTANDAR");
        reverse.addResult("AM.CANTIDAD-ISNULL(RAM.REQUERIDO,0) REQUERIDO");
        reverse.addResult("0 DESPACHADO");
        reverse.addResult("AM.ID_UMEDIDA");
        reverse.addResult("M.NOMBRE MATERIAL");
        reverse.addResult("M.STOCK");
        reverse.addResult("ISNULL(RAM.REQUERIDO,0) REQUERIDOT");
        reverse.addResult("ISNULL(RAM.DESPACHADO,0) DESPACHADOT");
        reverse.addJoin("INNER JOIN MATERIAL M", "AM.ID_MATERIAL=M.ID_MATERIAL");
        reverse.addJoin("LEFT JOIN REQUERIMIENTO_ACTIVIDAD_MATERIAL RAM", "RAM.ID_MATERIAL=M.ID_MATERIAL");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(RequerimientoMaterial.class);
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
        reverse.addJoin("INNER JOIN MATERIAL M", "AM.ID_MATERIAL=M.ID_MATERIAL");
        reverse.addJoin("LEFT JOIN REQUERIMIENTO_ACTIVIDAD_MATERIAL RAM", "RAM.ID_MATERIAL=M.ID_MATERIAL");
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
