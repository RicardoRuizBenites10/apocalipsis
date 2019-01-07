/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IMantenimientoDAO;
import com.bruce.dao.to.Mantenimiento;
import com.bruce.dao.to.MantenimientoId;
import com.bruce.util.FilterPage;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
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
public class MantenimientoDAO implements IMantenimientoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Mantenimiento> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("MANTENIMIENTO", "M");
        reverse.addResult("M.ID_AEQUIPO");
        reverse.addResult("M.ID_MANTENIMIENTO");
        reverse.addResult("M.FECHA");
        reverse.addResult("M.FECHA_PROGRAMADA");
        reverse.addResult("M.FECHA_ATENDIDO");
        reverse.addResult("M.OBSERVACION");
        reverse.addResult("M.COSTO");
        reverse.addResult("M.ID_TMANTENIMIENTO");
        reverse.addResult("M.ID_EMANTENIMIENTO");
        reverse.addResult("M.ID_GENERADOR");
        reverse.addResult("T1.AP_PATERNO +' '+ T1.AP_MATERNO + ', ' + T1.NOMBRES AS GENERADOR");
        reverse.addResult("EM.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN TRABAJADOR T1", "T1.ID_TRABAJADOR = M.ID_GENERADOR");
        reverse.addJoin("INNER JOIN ESTADO_MANTENIMIENTO EM", "EM.ID_ESTADO = M.ID_EMANTENIMIENTO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Mantenimiento.class);
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
        ReverseQuery reverse = new ReverseQuery("MANTENIMIENTO", "M");
        reverse.addResult("M.ID_AEQUIPO");
        reverse.addResult("M.ID_MANTENIMIENTO");
        reverse.addResult("M.FECHA");
        reverse.addResult("M.FECHA_PROGRAMADA");
        reverse.addResult("M.FECHA_ATENDIDO");
        reverse.addResult("M.OBSERVACION");
        reverse.addResult("M.COSTO");
        reverse.addResult("M.ID_TMANTENIMIENTO");
        reverse.addResult("M.ID_EMANTENIMIENTO");
        reverse.addResult("M.ID_GENERADOR");
        reverse.addResult("T1.AP_PATERNO +' '+ T1.AP_MATERNO + ', ' + T1.NOMBRES AS GENERADOR");
        reverse.addResult("EM.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN TRABAJADOR T1", "T1.ID_TRABAJADOR = M.ID_GENERADOR");
        reverse.addJoin("INNER JOIN ESTADO_MANTENIMIENTO EM", "EM.ID_ESTADO = M.ID_EMANTENIMIENTO");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Mantenimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list().size();
    }

    @Override
    public Mantenimiento lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Mantenimiento mantenimiento = null;
        ReverseQuery reverse = new ReverseQuery("MANTENIMIENTO", "M");
        reverse.addResult("M.ID_AEQUIPO");
        reverse.addResult("M.ID_MANTENIMIENTO");
        reverse.addResult("M.FECHA");
        reverse.addResult("M.FECHA_PROGRAMADA");
        reverse.addResult("M.FECHA_ATENDIDO");
        reverse.addResult("M.OBSERVACION");
        reverse.addResult("M.COSTO");
        reverse.addResult("M.ID_TMANTENIMIENTO");
        reverse.addResult("M.ID_EMANTENIMIENTO");
        reverse.addResult("M.ID_GENERADOR");
        reverse.addResult("T1.AP_PATERNO +' '+ T1.AP_MATERNO + ', ' + T1.NOMBRES AS GENERADOR");
        reverse.addResult("EM.DESCRIPCION ETAPA");
        reverse.addJoin("INNER JOIN TRABAJADOR T1", "T1.ID_TRABAJADOR = M.ID_GENERADOR");
        reverse.addJoin("INNER JOIN ESTADO_MANTENIMIENTO EM", "EM.ID_ESTADO = M.ID_EMANTENIMIENTO");
        reverse.setFilters(filters);
        List<SortPage> sorts = new ArrayList<>();
        sorts.add(new SortPage("ID_MANTENIMIENTO", "DESC"));
        reverse.setSorts(sorts);
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Mantenimiento.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        if (!result.isEmpty()) {
            mantenimiento = (Mantenimiento) result.get(0);
        }
        return mantenimiento;
    }

    @Override
    public void create(Mantenimiento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Mantenimiento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Mantenimiento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Mantenimiento get(Object idT) {
        Session session = sf.getCurrentSession();
        MantenimientoId mm = (MantenimientoId) idT;
        Query query = session.createQuery("FROM Mantenimiento WHERE idAequipo = :idAequipo AND idMantenimiento = :idMantenimiento");
        query.setParameter("idAequipo", mm.getIdAequipo());
        query.setParameter("idMantenimiento", mm.getIdMantenimiento());
        List result = query.list();
        Mantenimiento mantenimiento = result.size() > 0 ? (Mantenimiento) result.get(0) : null;
        return mantenimiento;//(Mantenimiento) sf.getCurrentSession().get(Mantenimiento.class, (Serializable) sf);
    }

    @Override
    public List<Mantenimiento> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
