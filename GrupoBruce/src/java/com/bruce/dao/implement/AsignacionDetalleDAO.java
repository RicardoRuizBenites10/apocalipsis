/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsignacionDetalleDAO;
import com.bruce.dao.to.AsignacionDetalle;
import com.bruce.util.FilterPage;
import com.bruce.util.QueryUtil;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
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
public class AsignacionDetalleDAO implements IAsignacionDetalleDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<AsignacionDetalle> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASIGNACION_DETALLE", "AD");
        reverse.addResult("AD.ID_AEQUIPO");
        reverse.addResult("AD.ID_ADETALLE");
        reverse.addResult("AD.FECHA");
        reverse.addResult("AD.FECHA_ASIGNADO");
        reverse.addResult("AD.ASIGNADO");
        reverse.addResult("AD.ID_EINFORMATICO");
        reverse.addResult("EI.DENOMINACION EINFORMATICO");
        reverse.addJoin("INNER JOIN EQUIPO_INFORMATICO EI", "EI.ID_EINFORMATICO = AD.ID_EINFORMATICO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(AsignacionDetalle.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

    @Override
    public boolean validaREquipoAsignacion(AsignacionDetalle asignacionDetalle) {
        boolean rpta;
        Session session = sf.getCurrentSession();
        Query query = session.createSQLQuery(QueryUtil.ASIGNACION_DETALLE_VALIDA);
        query.setParameter("IDEINFORMATICO", asignacionDetalle.getIdEinformatico());
        query.setParameter("IDASIGNACION", asignacionDetalle.getIdAequipo());
        List result = query.list();
        rpta = result.isEmpty();
        return rpta;
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASIGNACION_DETALLE", "AD");
        reverse.addResult("AD.ID_AEQUIPO");
        reverse.addResult("AD.ID_ADETALLE");
        reverse.addResult("AD.FECHA");
        reverse.addResult("AD.FECHA_ASIGNADO");
        reverse.addResult("AD.ASIGNADO");
        reverse.addResult("AD.ID_EINFORMATICO");
        reverse.addResult("EI.DENOMINACION EINFORMATICO");
        reverse.addJoin("INNER JOIN EQUIPO_INFORMATICO EI", "EI.ID_EINFORMATICO = AD.ID_EINFORMATICO");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(AsignacionDetalle.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        return result.size();
    }

    @Override
    public AsignacionDetalle lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        AsignacionDetalle asigancionDetalle = null;
        ReverseQuery reverse = new ReverseQuery("ASIGNACION_DETALLE", "AD");
        reverse.addResult("AD.ID_AEQUIPO");
        reverse.addResult("AD.ID_ADETALLE");
        reverse.addResult("AD.FECHA");
        reverse.addResult("AD.FECHA_ASIGNADO");
        reverse.addResult("AD.ASIGNADO");
        reverse.addResult("AD.ID_EINFORMATICO");
        reverse.addResult("EI.DENOMINACION EINFORMATICO");
        reverse.addJoin("INNER JOIN EQUIPO_INFORMATICO EI", "EI.ID_EINFORMATICO = AD.ID_EINFORMATICO");
        reverse.setFilters(filters);
        List<SortPage> sorts = new ArrayList<>();
        sorts.add(new SortPage("ID_EINFORMATICO", "DESC"));
        reverse.setSorts(sorts);
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(AsignacionDetalle.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        if (!result.isEmpty()) {
            asigancionDetalle = (AsignacionDetalle) result.get(0);
        }
        return asigancionDetalle;
    }

    @Override
    public void create(AsignacionDetalle t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(AsignacionDetalle t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(AsignacionDetalle t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public AsignacionDetalle get(Object idT) {
        return (AsignacionDetalle) sf.getCurrentSession().get(AsignacionDetalle.class, (Serializable) sf);
    }

    @Override
    public List<AsignacionDetalle> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
