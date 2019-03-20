/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IPlanillaDAO;
import com.bruce.dao.to.Planilla;
import com.bruce.dao.to.Planilla;
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
public class PlanillaDAO implements IPlanillaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Planilla t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Planilla t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(Planilla t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Planilla get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Planilla lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANILLA", "PN");
        reverse.addResult("PN.ID_TRABAJADOR");
        reverse.addResult("PN.ID_PPLANILLA");
        reverse.addResult("PN.ID_TTRABAJADOR");
        reverse.addResult("PN.ID_TPLANILLA");
        reverse.addResult("PN.ID_CONCEPTO");
        reverse.addResult("PN.FECHA");
        reverse.addResult("PN.IMPORTE");
        reverse.addResult("C.DESCRIPCION");
        reverse.addJoin("INNER JOIN CONCEPTO C", "C.ID_CONCEPTO = PN.ID_CONCEPTO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("FECHA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Planilla.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Planilla planilla = !result.isEmpty() ? (Planilla) result.get(0) : null;
        return planilla;
    }

    @Override
    public List<Planilla> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Planilla> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANILLA", "PN");
        reverse.addResult("PN.ID_TRABAJADOR");
        reverse.addResult("PN.ID_PPLANILLA");
        reverse.addResult("PN.ID_TTRABAJADOR");
        reverse.addResult("PN.ID_TPLANILLA");
        reverse.addResult("PN.ID_CONCEPTO");
        reverse.addResult("PN.FECHA");
        reverse.addResult("PN.IMPORTE");
        reverse.addResult("C.DESCRIPCION");
        reverse.addJoin("INNER JOIN CONCEPTO C", "C.ID_CONCEPTO = PN.ID_CONCEPTO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Planilla.class);
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
        ReverseQuery reverse = new ReverseQuery("PLANILLA", "PN");
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
