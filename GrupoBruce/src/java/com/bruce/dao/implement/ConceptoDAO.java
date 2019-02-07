/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IConceptoDAO;
import com.bruce.dao.to.Concepto;
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
 * @author RICARDO
 */
@Repository
public class ConceptoDAO implements IConceptoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Concepto t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Concepto t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Concepto t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Concepto get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concepto lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Concepto concepto = null;
        ReverseQuery reverse = new ReverseQuery("CONCEPTO", "C");
        reverse.addResult("C.ID_TTRABAJADOR");
        reverse.addResult("C.ID_CONCEPTO");
        reverse.addResult("C.COD_PDT");
        reverse.addResult("C.DESCRIPCION");
        reverse.addResult("C.FORMULA");
        reverse.addResult("C.ID_TCONCEPTO");
        reverse.addResult("C.ID_TVARIABLE");
        reverse.addResult("C.SITUACION");
        reverse.addResult("TC.DESCRIPCION AS TCONCEPTO");
        reverse.addResult("TV.DESCRIPCION AS TVARIABLE");
        reverse.addJoin("INNER JOIN TIPO_CONCEPTO TC", "TC.ID_TIPO = C.ID_TCONCEPTO");
        reverse.addJoin("INNER JOIN TIPO_VARIABLE TV", "TV.ID_TIPO = C.ID_TVARIABLE");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CONCEPTO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Concepto.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        if (!result.isEmpty()) {
            concepto = (Concepto) result.get(0);
        }
        return concepto;
    }

    @Override
    public List<Concepto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concepto> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONCEPTO", "C");
        reverse.addResult("C.ID_TTRABAJADOR");
        reverse.addResult("C.ID_CONCEPTO");
        reverse.addResult("C.COD_PDT");
        reverse.addResult("C.DESCRIPCION");
        reverse.addResult("C.FORMULA");
        reverse.addResult("C.ID_TCONCEPTO");
        reverse.addResult("C.ID_TVARIABLE");
        reverse.addResult("C.SITUACION");
        reverse.addResult("TC.DESCRIPCION AS TCONCEPTO");
        reverse.addResult("TV.DESCRIPCION AS TVARIABLE");
        reverse.addJoin("INNER JOIN TIPO_CONCEPTO TC", "TC.ID_TIPO = C.ID_TCONCEPTO");
        reverse.addJoin("INNER JOIN TIPO_VARIABLE TV", "TV.ID_TIPO = C.ID_TVARIABLE");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Concepto.class);
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
        ReverseQuery reverse = new ReverseQuery("CONCEPTO", "C");
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
