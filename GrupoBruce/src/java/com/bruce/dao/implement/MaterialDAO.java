/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMaterialDAO;
import com.bruce.dao.to.Material;
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
public class MaterialDAO implements IMaterialDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Material t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void update(Material t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Material t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Material get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Material lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("MATERIAL", "M");
        reverse.addResult("M.ID_EMPRESA");
        reverse.addResult("M.ID_SUCURSAL");
        reverse.addResult("M.ID_MATERIAL");
        reverse.addResult("M.NOMBRE");
        reverse.addResult("M.PRECIO");
        reverse.addResult("M.STOCK");
        reverse.addResult("M.STOCK_MINIMO");
        reverse.addResult("M.STOCK_MAXIMO");
        reverse.addResult("M.CANT_INGRESO");
        reverse.addResult("M.CANT_SALIDA");
        reverse.addResult("M.AUTOPARTE");
        reverse.addResult("M.SEG_CALIDAD");
        reverse.addResult("M.SITUACION");
        reverse.addResult("M.ID_FAMILIA");
        reverse.addResult("M.ID_SUBFAMILIA");
        reverse.addResult("M.ID_USUARIO");
        reverse.addResult("MF.DESCRIPCION FAMILIA");
        reverse.addResult("MS.DESCRIPCION SUBFAMILIA");
        reverse.addJoin("INNER JOIN MATERIAL_FAMILIA MF", "MF.ID_FAMILIA=M.ID_FAMILIA");
        reverse.addJoin("INNER JOIN MATERIAL_SUBFAMILIA MS", "MS.ID_SUBFAMILIA=M.ID_SUBFAMILIA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_MATERIAL", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Material.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Material item = !result.isEmpty() ? (Material) result.get(0) : null;
        return item;
    }

    @Override
    public List<Material> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("MATERIAL", "M");
        reverse.addResult("M.ID_EMPRESA");
        reverse.addResult("M.ID_SUCURSAL");
        reverse.addResult("M.ID_MATERIAL");
        reverse.addResult("M.NOMBRE");
        reverse.addResult("M.PRECIO");
        reverse.addResult("M.STOCK");
        reverse.addResult("M.STOCK_MINIMO");
        reverse.addResult("M.STOCK_MAXIMO");
        reverse.addResult("M.CANT_INGRESO");
        reverse.addResult("M.CANT_SALIDA");
        reverse.addResult("M.AUTOPARTE");
        reverse.addResult("M.SEG_CALIDAD");
        reverse.addResult("M.SITUACION");
        reverse.addResult("M.ID_FAMILIA");
        reverse.addResult("M.ID_SUBFAMILIA");
        reverse.addResult("M.ID_USUARIO");
        reverse.addResult("MF.DESCRIPCION FAMILIA");
        reverse.addResult("MS.DESCRIPCION SUBFAMILIA");
        reverse.addJoin("INNER JOIN MATERIAL_FAMILIA MF", "MF.ID_FAMILIA=M.ID_FAMILIA");
        reverse.addJoin("INNER JOIN MATERIAL_SUBFAMILIA MS", "MS.ID_SUBFAMILIA=M.ID_SUBFAMILIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Material.class);
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
        ReverseQuery reverse = new ReverseQuery("MATERIAL", "M");
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
