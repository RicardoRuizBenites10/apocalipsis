/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsignacionEquipoDAO;
import com.bruce.dao.to.AsignacionEquipo;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RICARDO
 */
@Repository
public class AsignacionEquipoDAO implements IAsignacionEquipoDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<AsignacionEquipo> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASIGNACION_EQUIPO", "AE");
        reverse.addResult("AE.ID_AEQUIPO");
        reverse.addResult("AE.FECHA");
        reverse.addResult("AE.NRO_IP");
        reverse.addResult("AE.NOM_USU");
        reverse.addResult("AE.PAS_USU");
        reverse.addResult("AE.ESTADO");
        reverse.addResult("AE.ID_ASIGNADOR");
        reverse.addResult("AE.ID_RECEPCIONADOR");
        reverse.addResult("T1.AP_PATERNO +' '+ T1.AP_MATERNO + ', ' + T1.NOMBRES AS ASIGNADOR");
        reverse.addResult("T2.AP_PATERNO +' '+ T2.AP_MATERNO + ', ' + T2.NOMBRES AS RECEPCIONADOR");
        reverse.addJoin("INNER JOIN TRABAJADOR T1", "T1.ID_TRABAJADOR = AE.ID_ASIGNADOR");
        reverse.addJoin("INNER JOIN Trabajador T2", "T2.ID_TRABAJADOR = AE.ID_RECEPCIONADOR");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(AsignacionEquipo.class);
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
        Criteria cr = session.createCriteria(AsignacionEquipo.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }

    @Override
    public AsignacionEquipo lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        AsignacionEquipo asignacionEquipo = null;
        ReverseQuery reverse = new ReverseQuery("ASIGNACION_EQUIPO", "AE");
        reverse.addResult("AE.ID_AEQUIPO");
        reverse.addResult("AE.FECHA");
        reverse.addResult("AE.NRO_IP");
        reverse.addResult("AE.NOM_USU");
        reverse.addResult("AE.PAS_USU");
        reverse.addResult("AE.ESTADO");
        reverse.addResult("AE.ID_ASIGNADOR");
        reverse.addResult("AE.ID_RECEPCIONADOR");
        reverse.addResult("T1.AP_PATERNO +' '+ T1.AP_MATERNO + ', ' + T1.NOMBRES AS ASIGNADOR");
        reverse.addResult("T2.AP_PATERNO +' '+ T2.AP_MATERNO + ', ' + T2.NOMBRES AS RECEPCIONADOR");
        reverse.addJoin("INNER JOIN TRABAJADOR T1", "T1.ID_TRABAJADOR = AE.ID_ASIGNADOR");
        reverse.addJoin("INNER JOIN Trabajador T2", "T2.ID_TRABAJADOR = AE.ID_RECEPCIONADOR");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_AEQUIPO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(AsignacionEquipo.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        if(!result.isEmpty()){
            asignacionEquipo = (AsignacionEquipo) result.get(0);
        }
        return asignacionEquipo;
    }

    @Override
    public void create(AsignacionEquipo t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(AsignacionEquipo t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(AsignacionEquipo t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public AsignacionEquipo get(Object idT) {
        return (AsignacionEquipo) sf.getCurrentSession().get(AsignacionEquipo.class, (Serializable) sf);
    }

    @Override
    public List<AsignacionEquipo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
