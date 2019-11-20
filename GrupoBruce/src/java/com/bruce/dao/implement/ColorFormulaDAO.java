/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IColorFormulaDAO;
import com.bruce.dao.to.ColorFormula;
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
public class ColorFormulaDAO implements IColorFormulaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ColorFormula t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ColorFormula t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(ColorFormula t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ColorFormula get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColorFormula lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("COLOR_FORMULA", "CF");
        reverse.addResult("CF.ID_CDISENO");
        reverse.addResult("CF.ID_MATERIA");
        reverse.addResult("CF.CANTIDAD");
        reverse.addResult("CD.DENOMINACION COLORDISENO");
        reverse.addResult("M.NOMBRE MATERIAL");
        reverse.addJoin("INNER JOIN COLOR_DISENO CD", "CF.ID_CDISENO=CD.ID_CDISENO");
        reverse.addJoin("INNER JOIN MATERIAL M", "CF.ID_MATERIAL=M.ID_MATERIAL AND M.ID_SUCURSAL= :M.ID_SUCURSAL");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CDISENO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ColorFormula.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ColorFormula item = !result.isEmpty() ? (ColorFormula) result.get(0) : null;
        return item;
    }

    @Override
    public List<ColorFormula> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColorFormula> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("COLOR_FORMULA", "CF");
        reverse.addResult("CF.ID_CDISENO");
        reverse.addResult("CF.ID_MATERIA");
        reverse.addResult("CF.CANTIDAD");
        reverse.addResult("CD.DENOMINACION COLORDISENO");
        reverse.addResult("M.NOMBRE MATERIAL");
        reverse.addJoin("INNER JOIN COLOR_DISENO CD", "CF.ID_CDISENO=CD.ID_CDISENO");
        reverse.addJoin("INNER JOIN MATERIAL M", "CF.ID_MATERIAL=M.ID_MATERIAL AND M.ID_SUCURSAL= :M.ID_SUCURSAL");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ColorFormula.class);
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
        ReverseQuery reverse = new ReverseQuery("COLOR_FORMULA", "CF");
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
