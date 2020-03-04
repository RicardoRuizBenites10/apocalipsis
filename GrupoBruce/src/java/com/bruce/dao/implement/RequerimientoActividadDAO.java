/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IRequerimientoActividadDAO;
import com.bruce.dao.to.RequerimientoActividad;
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
public class RequerimientoActividadDAO implements IRequerimientoActividadDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(RequerimientoActividad t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(RequerimientoActividad t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(RequerimientoActividad t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public RequerimientoActividad get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RequerimientoActividad lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA", "OB");
        reverse.addResult("OB.ID_OBRA");
        reverse.addResult("EA.ID_ESPECIFICACION");
        reverse.addResult("EA.ID_ACTIVIDAD");
        reverse.addResult("ISNULL(RAC.REQUERIDO,0) REQUERIDO");
        reverse.addResult("ISNULL(RAC.DESPACHADO,0) DESPACHADO");
        reverse.addResult("ISNULL(RAC.ESTADO,'N') ESTADO");
        reverse.addResult("AC.NOMBRE ACTIVIDAD");
        reverse.addJoin("INNER JOIN PROFORMA_DETALLE PFD", "OB.ID_PROFORMA=PFD.ID_PROFORMA");
        reverse.addJoin("INNER JOIN ESPECIFICACION_ACTIVIDAD EA", "PFD.ID_ESPECIFICACION=EA.ID_ESPECIFICACION");
        reverse.addJoin("INNER JOIN ACTIVIDAD AC", "EA.ID_ACTIVIDAD=AC.ID_ACTIVIDAD");
        reverse.addJoin("LEFT JOIN REQUERIMIENTO_ACTIVIDAD RAC", "OB.ID_OBRA=RAC.ID_OBRA AND EA.ID_ESPECIFICACION=RAC.ID_ESPECIFICACION AND EA.ID_ACTIVIDAD=RAC.ID_ACTIVIDAD");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_OBRA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(RequerimientoActividad.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        RequerimientoActividad item = !result.isEmpty() ? (RequerimientoActividad) result.get(0) : null;
        return item;
    }

    @Override
    public List<RequerimientoActividad> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RequerimientoActividad> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA", "OB");
        reverse.addResult("OB.ID_OBRA");
        reverse.addResult("EA.ID_ESPECIFICACION");
        reverse.addResult("EA.ID_ACTIVIDAD");
        reverse.addResult("ISNULL(RAC.REQUERIDO,0) REQUERIDO");
        reverse.addResult("ISNULL(RAC.DESPACHADO,0) DESPACHADO");
        reverse.addResult("ISNULL(RAC.ESTADO,'N') ESTADO");
        reverse.addResult("AC.NOMBRE ACTIVIDAD");
        reverse.addJoin("INNER JOIN PROFORMA_DETALLE PFD", "OB.ID_PROFORMA=PFD.ID_PROFORMA");
        reverse.addJoin("INNER JOIN ESPECIFICACION_ACTIVIDAD EA", "PFD.ID_ESPECIFICACION=EA.ID_ESPECIFICACION");
        reverse.addJoin("INNER JOIN ACTIVIDAD AC", "EA.ID_ACTIVIDAD=AC.ID_ACTIVIDAD");
        reverse.addJoin("LEFT JOIN REQUERIMIENTO_ACTIVIDAD RAC", "OB.ID_OBRA=RAC.ID_OBRA AND EA.ID_ESPECIFICACION=RAC.ID_ESPECIFICACION AND EA.ID_ACTIVIDAD=RAC.ID_ACTIVIDAD");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(RequerimientoActividad.class);
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
        reverse.addJoin("INNER JOIN PROFORMA_DETALLE PFD", "OB.ID_PROFORMA=PFD.ID_PROFORMA");
        reverse.addJoin("INNER JOIN ESPECIFICACION_ACTIVIDAD EA", "PFD.ID_ESPECIFICACION=EA.ID_ESPECIFICACION");
        reverse.addJoin("INNER JOIN ACTIVIDAD AC", "EA.ID_ACTIVIDAD=AC.ID_ACTIVIDAD");
        reverse.addJoin("LEFT JOIN REQUERIMIENTO_ACTIVIDAD RAC", "OB.ID_OBRA=RAC.ID_OBRA AND EA.ID_ESPECIFICACION=RAC.ID_ESPECIFICACION AND EA.ID_ACTIVIDAD=RAC.ID_ACTIVIDAD");
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
