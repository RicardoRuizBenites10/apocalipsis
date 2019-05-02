/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IObraDAO;
import com.bruce.dao.to.Obra;
import com.bruce.dao.to.Obra;
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
public class ObraDAO implements IObraDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Obra t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Obra t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Obra t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Obra get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Obra lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA", "OB");
        reverse.addResult("OB.ID_OBRA");
        reverse.addResult("OB.NOMBRE");
        reverse.addResult("OB.FECHA");
        reverse.addResult("OB.FECHA_INICIO");
        reverse.addResult("OB.FECHA_FIN");
        reverse.addResult("OB.ID_OBRTIP");
        reverse.addResult("OB.ID_CLIENTE");
        reverse.addResult("OB.ID_PROFORMA");
        reverse.addResult("OT.DESCRIPCION TIPO");
        reverse.addResult("CL.NOMBRE CLIENTE");
        reverse.addJoin("INNER JOIN OBRA_TIPO OT", "OT.ID_OBRTIP=OB.ID_OBRTIP");
        reverse.addJoin("INNER JOIN CLIENTE CL", "CL.ID_CLIENTE=OB.ID_CLIENTE");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_OBRA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Obra.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Obra item = !result.isEmpty() ? (Obra) result.get(0) : null;
        return item;
    }

    @Override
    public List<Obra> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Obra> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA", "OB");
        reverse.addResult("OB.ID_OBRA");
        reverse.addResult("OB.NOMBRE");
        reverse.addResult("OB.FECHA");
        reverse.addResult("OB.FECHA_INICIO");
        reverse.addResult("OB.FECHA_FIN");
        reverse.addResult("OB.ID_OBRTIP");
        reverse.addResult("OB.ID_CLIENTE");
        reverse.addResult("OB.ID_PROFORMA");
        reverse.addResult("OT.DESCRIPCION TIPO");
        reverse.addResult("CL.NOMBRE CLIENTE");
        reverse.addJoin("INNER JOIN OBRA_TIPO OT", "OT.ID_OBRTIP=OB.ID_OBRTIP");
        reverse.addJoin("INNER JOIN CLIENTE CL", "CL.ID_CLIENTE=OB.ID_CLIENTE");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Obra.class);
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
        ReverseQuery reverse = new ReverseQuery("OBRA", "OB");
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
