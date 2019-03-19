/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IConceptoAsignadoDAO;
import com.bruce.dao.to.ConceptoAsignado;
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
public class ConceptoAsignadoDAO implements IConceptoAsignadoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ConceptoAsignado t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ConceptoAsignado t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(ConceptoAsignado t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ConceptoAsignado get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConceptoAsignado lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ConceptoAsignado conceptoAsignado = null;
        ReverseQuery reverse = new ReverseQuery("CONCEPTO_ASIGNADO", "CA");
        reverse.addResult("CA.ID_TTRABAJADOR");
        reverse.addResult("CA.ID_TPLANILLA");
        reverse.addResult("CA.ID_CONCEPTO");
        reverse.addResult("CA.FECHA");
        reverse.addResult("CA.ORDEN");
        reverse.addResult("C.FORMULA FORMULA");
        reverse.addResult("C.DESCRIPCION DESCRIPCION");
        reverse.addJoin("INNER JOIN CONCEPTO C", "C.ID_CONCEPTO=CA.ID_CONCEPTO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ORDEN", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ConceptoAsignado.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        if (!result.isEmpty()) {
            conceptoAsignado = (ConceptoAsignado) result.get(0);
        }
        return conceptoAsignado;
    }

    @Override
    public List<ConceptoAsignado> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConceptoAsignado> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONCEPTO_ASIGNADO", "CA");
        reverse.addResult("CA.ID_TTRABAJADOR");
        reverse.addResult("CA.ID_TPLANILLA");
        reverse.addResult("CA.ID_CONCEPTO");
        reverse.addResult("CA.FECHA");
        reverse.addResult("CA.ORDEN");
        reverse.addResult("C.FORMULA FORMULA");
        reverse.addResult("C.DESCRIPCION DESCRIPCION");
        reverse.addJoin("INNER JOIN CONCEPTO C", "C.ID_CONCEPTO=CA.ID_CONCEPTO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ConceptoAsignado.class);
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
        ReverseQuery reverse = new ReverseQuery("CONCEPTO_ASIGNADO", "CA");
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
