/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.to.ContratoTrabajador;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class ContratoTrabajadorDAO implements IContratoTrabajadorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ContratoTrabajador t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ContratoTrabajador t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(ContratoTrabajador t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ContratoTrabajador get(Object idT) {
        Session session = sf.getCurrentSession();
        List<FilterPage> filters = (List<FilterPage>) idT;
        Criteria cr = session.createCriteria(ContratoTrabajador.class);
        filters.forEach(item -> {
            cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
        });
        return (ContratoTrabajador) cr.list();
    }

    @Override
    public List<ContratoTrabajador> getAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM ContratoTrabajador");
        return query.list();
    }

    @Override
    public List<ContratoTrabajador> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONTRATO_TRABAJADOR", "CT");
        reverse.addResult("CT.ID_TRABAJADOR");
        reverse.addResult("CT.ID_CONTRATO");
        reverse.addResult("CT.FECHA_INICIO");
        reverse.addResult("CT.MONTO_CONTRATO");
        reverse.addResult("CT.FECHA_FIN");
        reverse.addResult("CT.FECHA_CESE");
        reverse.addResult("CT.MOTIVO_CESE");
        reverse.addResult("CT.ID_TCONTRATO");
        reverse.addResult("CT.ID_ECONTRATO");
        reverse.addResult("CT.ID_TIEMPO");
        reverse.addResult("CT.ID_AREA");
        reverse.addResult("CT.ID_CARGO");
        reverse.addResult("A.NOMBRE AREA");
        reverse.addJoin("INNER JOIN AREA A", "CT.ID_AREA=A.ID_AREA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ContratoTrabajador.class);
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
        ReverseQuery reverse = new ReverseQuery("CONTRATO_TRABAJADOR", "CT");
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

    @Override
    public ContratoTrabajador lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CONTRATO_TRABAJADOR", "CT");
        reverse.addResult("CT.ID_TRABAJADOR");
        reverse.addResult("CT.ID_CONTRATO");
        reverse.addResult("CT.FECHA_INICIO");
        reverse.addResult("CT.MONTO_CONTRATO");
        reverse.addResult("CT.FECHA_FIN");
        reverse.addResult("CT.FECHA_CESE");
        reverse.addResult("CT.MOTIVO_CESE");
        reverse.addResult("CT.ID_TCONTRATO");
        reverse.addResult("CT.ID_ECONTRATO");
        reverse.addResult("CT.ID_TIEMPO");
        reverse.addResult("CT.ID_AREA");
        reverse.addResult("CT.ID_CARGO");
        reverse.addResult("A.NOMBRE AREA");
        reverse.addJoin("INNER JOIN AREA A", "CT.ID_AREA=A.ID_AREA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CONTRATO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ContratoTrabajador.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ContratoTrabajador item = !result.isEmpty() ? (ContratoTrabajador) result.get(0) : null;
        return item;
    }

}
