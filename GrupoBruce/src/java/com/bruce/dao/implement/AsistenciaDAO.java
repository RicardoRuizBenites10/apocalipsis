/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.to.Asistencia;
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
 * @author RICARDO
 */
@Repository
public class AsistenciaDAO implements IAsistenciaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Asistencia> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("T.ID_TRABAJADOR");
        reverse.addResult("ISNULL(A.FECHA,:FECHA) FECHA");
        reverse.addResult("ISNULL(A.MARCA1,'') MARCA1");
        reverse.addResult("A.MARCA2");
        reverse.addResult("A.MARCA3");
        reverse.addResult("A.MARCA4");
        reverse.addResult("A.MARCA5");
        reverse.addResult("A.MARCA6");
        reverse.addResult("ISNULL(A.MARCA7,'') MARCA7");
        reverse.addResult("ISNULL(A.ANIO,DATEPART(YEAR,GETDATE())) ANIO");
        reverse.addResult("ISNULL(A.MES,DATEPART(MONTH,GETDATE())) MES");
        reverse.addResult("ISNULL(A.DIA,DATEPART(DAY,GETDATE())) DIA");
        reverse.addResult("ISNULL(A.AUSENCIA,0) AUSENCIA");
        reverse.addResult("ISNULL(A.ASISTIO,0) ASISTIO");
        reverse.addResult("ISNULL(A.HRS_DSCTO,0) HRS_DSCTO");
        reverse.addResult("ISNULL(A.HRS_EXTRA,0) HRS_EXTRA");
        reverse.addResult("ISNULL(A.STD_EXTRA,0) STD_EXTRA");
        reverse.addResult("ISNULL(A.PROCESADO,0) PROCESADO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("RIGHT JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR AND A.FECHA = :FECHA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Asistencia.class);
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
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addJoin("RIGHT JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR AND A.FECHA = :FECHA");
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
    public Asistencia lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ASISTENCIA", "A");
        reverse.addResult("T.ID_TRABAJADOR");
        reverse.addResult("A.FECHA");
        reverse.addResult("ISNULL(A.MARCA1,'') MARCA1");
        reverse.addResult("A.MARCA2");
        reverse.addResult("A.MARCA3");
        reverse.addResult("A.MARCA4");
        reverse.addResult("A.MARCA5");
        reverse.addResult("A.MARCA6");
        reverse.addResult("ISNULL(A.MARCA7,'') MARCA7");
        reverse.addResult("ISNULL(A.ANIO,DATEPART(YEAR,GETDATE())) ANIO");
        reverse.addResult("ISNULL(A.MES,DATEPART(MONTH,GETDATE())) MES");
        reverse.addResult("ISNULL(A.DIA,DATEPART(DAY,GETDATE())) DIA");
        reverse.addResult("ISNULL(A.AUSENCIA,0) AUSENCIA");
        reverse.addResult("ISNULL(A.ASISTIO,0) ASISTIO");
        reverse.addResult("ISNULL(A.HRS_DSCTO,0) HRS_DSCTO");
        reverse.addResult("ISNULL(A.HRS_EXTRA,0) HRS_EXTRA");
        reverse.addResult("ISNULL(A.STD_EXTRA,0) STD_EXTRA");
        reverse.addResult("ISNULL(A.PROCESADO,0) PROCESADO");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS TRABAJADOR");
        reverse.addJoin("RIGHT JOIN Trabajador T", "T.ID_TRABAJADOR = A.ID_TRABAJADOR");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("FECHA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Asistencia.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Asistencia asistencia =  !result.isEmpty() ? (Asistencia)result.get(0) : null;
        return asistencia;
    }

    @Override
    public void create(Asistencia t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Asistencia t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(Asistencia t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Asistencia get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asistencia> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
