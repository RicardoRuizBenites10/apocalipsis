/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IObraContratistaDAO;
import com.bruce.dao.to.ObraContratista;
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
public class ObraContratistaDAO implements IObraContratistaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ObraContratista t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ObraContratista t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(ObraContratista t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ObraContratista get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObraContratista lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA_CONTRATISTA", "OC");
        reverse.addResult("OC.ID_OBRA");
        reverse.addResult("OC.ID_CONTRATISTA");
        reverse.addResult("OC.ID_EPROCESO");
        reverse.addResult("OC.FECHA");
        reverse.addResult("C.NOMBRE CONTRATISTA");
        reverse.addResult("EP.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN CONTRATISTA C", "C.ID_CONTRATISTA=OC.ID_CONTRATISTA");
        reverse.addJoin("INNER JOIN ETAPA_PROCESO EP", "EP.ID_EPROCESO=OC.ID_EPROCESO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CONTRATISTA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ObraContratista.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ObraContratista item = !result.isEmpty() ? (ObraContratista) result.get(0) : null;
        return item;
    }

    @Override
    public List<ObraContratista> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObraContratista> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA_CONTRATISTA", "OC");
        reverse.addResult("OC.ID_OBRA");
        reverse.addResult("OC.ID_CONTRATISTA");
        reverse.addResult("OC.ID_EPROCESO");
        reverse.addResult("OC.FECHA");
        reverse.addResult("C.NOMBRE CONTRATISTA");
        reverse.addResult("EP.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN CONTRATISTA C", "C.ID_CONTRATISTA=OC.ID_CONTRATISTA");
        reverse.addJoin("INNER JOIN ETAPA_PROCESO EP", "EP.ID_EPROCESO=OC.ID_EPROCESO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ObraContratista.class);
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
        ReverseQuery reverse = new ReverseQuery("OBRA_CONTRATISTA", "OC");
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
