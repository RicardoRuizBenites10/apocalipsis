/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IProformaDAO;
import com.bruce.dao.to.Proforma;
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
public class ProformaDAO implements IProformaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Proforma t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Proforma t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Proforma t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Proforma get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proforma lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PROFORMA", "PR");
        reverse.addResult("PR.ID_PROFORMA");
        reverse.addResult("PR.FECHA");
        reverse.addResult("PR.ID_CARROCERIA");
        reverse.addResult("PR.ID_CLIENTE");
        reverse.addResult("CL.NOMBRE CLIENTE");
        reverse.addResult("CA.CODIGO CARROCERIA");
        reverse.addJoin("INNER JOIN CLIENTE CL", "CL.ID_CLIENTE=PR.ID_CLIENTE");
        reverse.addJoin("INNER JOIN CARROCERIA CA", "CA.ID_CARROCERIA=PR.ID_CARROCERIA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_PROFORMA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Proforma.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Proforma item = !result.isEmpty() ? (Proforma) result.get(0) : null;
        return item;
    }

    @Override
    public List<Proforma> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proforma> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PROFORMA", "PR");
        reverse.addResult("PR.ID_PROFORMA");
        reverse.addResult("PR.FECHA");
        reverse.addResult("PR.ID_CARROCERIA");
        reverse.addResult("PR.ID_CLIENTE");
        reverse.addResult("CL.NOMBRE CLIENTE");
        reverse.addResult("CA.CODIGO CARROCERIA");
        reverse.addJoin("INNER JOIN CLIENTE CL", "CL.ID_CLIENTE=PR.ID_CLIENTE");
        reverse.addJoin("INNER JOIN CARROCERIA CA", "CA.ID_CARROCERIA=PR.ID_CARROCERIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Proforma.class);
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
        ReverseQuery reverse = new ReverseQuery("PROFORMA", "PR");
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
