/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEstadoMantenimientoDAO;
import com.bruce.dao.to.EstadoMantenimiento;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import java.io.Serializable;
import java.util.ArrayList;
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
public class EstadoMantenimientoDAO implements IEstadoMantenimientoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EstadoMantenimiento> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESTADO_MANTENIMIENTO", "EM");
        reverse.addResult("EM.ID_ESTADO");
        reverse.addResult("EM.ORDEN");
        reverse.addResult("EM.DESCRIPCION");
        reverse.addResult("EM.ACCION");
        reverse.addResult("EM.SOLUCIONADOR");
        reverse.addResult("EM.ULTIMO");
        reverse.addResult("EM.SITUACION");
        reverse.addResult("EM.ID_PRECEDE");
        reverse.addResult("EM.ID_PROCESO");
        reverse.addResult("EM1.DESCRIPCION PRECEDE");
        reverse.addJoin("LEFT JOIN ESTADO_MANTENIMIENTO EM1", "EM1.ID_ESTADO = EM.ID_PRECEDE");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        System.err.println("Query: \n" + reverse.getQuery());
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(EstadoMantenimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                System.err.println("\nParametro: " + item.getProperty() + " valor: " + item.getValue());
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESTADO_MANTENIMIENTO", "EM");
        reverse.addResult("EM.ID_ESTADO");
        reverse.addResult("EM.ORDEN");
        reverse.addResult("EM.DESCRIPCION");
        reverse.addResult("EM.ACCION");
        reverse.addResult("EM.SOLUCIONADOR");
        reverse.addResult("EM.ULTIMO");
        reverse.addResult("EM.SITUACION");
        reverse.addResult("EM.ID_PRECEDE");
        reverse.addResult("EM.ID_PROCESO");
        reverse.addResult("EM1.DESCRIPCION PRECEDE");
        reverse.addJoin("LEFT JOIN ESTADO_MANTENIMIENTO EM1", "EM1.ID_ESTADO = EM.ID_PRECEDE");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(EstadoMantenimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        return result.size();
    }

    @Override
    public EstadoMantenimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        EstadoMantenimiento estadoMantenimiento = null;
        ReverseQuery reverse = new ReverseQuery("ESTADO_MANTENIMIENTO", "EM");
        reverse.addResult("EM.ID_ESTADO");
        reverse.addResult("EM.ORDEN");
        reverse.addResult("EM.DESCRIPCION");
        reverse.addResult("EM.ACCION");
        reverse.addResult("EM.SOLUCIONADOR");
        reverse.addResult("EM.ULTIMO");
        reverse.addResult("EM.SITUACION");
        reverse.addResult("EM.ID_PRECEDE");
        reverse.addResult("EM.ID_PROCESO");
        reverse.addResult("EM1.DESCRIPCION PRECEDE");
        reverse.addJoin("LEFT JOIN ESTADO_MANTENIMIENTO EM1", "EM1.ID_ESTADO = EM.ID_PRECEDE");
        reverse.setFilters(filters);
        List<SortPage> sorts = new ArrayList<>();
        sorts.add(new SortPage("ID_ESTADO", "DESC"));
        reverse.setSorts(sorts);
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(EstadoMantenimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }

        List result = query.list();
        if (!result.isEmpty()) {
            estadoMantenimiento = (EstadoMantenimiento) result.get(0);
        }
        return estadoMantenimiento;
    }

    @Override
    public void create(EstadoMantenimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EstadoMantenimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EstadoMantenimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EstadoMantenimiento get(Object idT) {
        return (EstadoMantenimiento) sf.getCurrentSession().get(EstadoMantenimiento.class, (Serializable) idT);
    }

    @Override
    public List<EstadoMantenimiento> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
