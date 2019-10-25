/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEspecificacionDAO;
import com.bruce.dao.to.Especificacion;
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
public class EspecificacionDAO implements IEspecificacionDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Especificacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Especificacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Especificacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Especificacion get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Especificacion lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION", "E");
        reverse.addResult("E.ID_ESPECIFICACION");
        reverse.addResult("E.DESCRIPCION");
        reverse.addResult("E.FECHA_INSERT");
        reverse.addResult("E.USU_INSERT");
        reverse.addResult("E.FECHA_UPDATE");
        reverse.addResult("E.USU_UPDATE");
        reverse.addResult("E.SITUACION");
        reverse.addResult("E.USA_ACTIVIDAD");
        reverse.addResult("E.ID_ECATEGORIA");
        reverse.addResult("EC.NOMBRE CATEGORIA");
        reverse.addResult("0 ASIGNADO");
        reverse.addJoin("INNER JOIN ESPECIFICACION_CATEGORIA EC", "E.ID_ECATEGORIA=EC.ID_ECATEGORIA");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_ESPECIFICACION", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Especificacion.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Especificacion item = !result.isEmpty() ? (Especificacion) result.get(0) : null;
        return item;
    }

    @Override
    public List<Especificacion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Especificacion> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION", "E");
        reverse.addResult("E.ID_ESPECIFICACION");
        reverse.addResult("E.DESCRIPCION");
        reverse.addResult("E.FECHA_INSERT");
        reverse.addResult("E.USU_INSERT");
        reverse.addResult("E.FECHA_UPDATE");
        reverse.addResult("E.USU_UPDATE");
        reverse.addResult("E.SITUACION");
        reverse.addResult("E.USA_ACTIVIDAD");
        reverse.addResult("E.ID_ECATEGORIA");
        reverse.addResult("EC.NOMBRE CATEGORIA");
        reverse.addResult("0 ASIGNADO");
        reverse.addJoin("INNER JOIN ESPECIFICACION_CATEGORIA EC", "E.ID_ECATEGORIA=EC.ID_ECATEGORIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Especificacion.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                if ((item.getOperator().equalsIgnoreCase("in") || item.getOperator().equalsIgnoreCase("nin")) && item.getValue() != null) {
                    query.setParameterList(item.getProperty(), item.getValue().toString().split(","));
                } else {
                    query.setParameter(item.getProperty(), item.getValue());
                }
            });
        }
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION", "E");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                if (item.isInWhere()) {
                    if ((item.getOperator().equalsIgnoreCase("in") || item.getOperator().equalsIgnoreCase("nin")) && item.getValue() != null) {
                        query.setParameterList(item.getProperty(), item.getValue().toString().split(","));
                    } else {
                        query.setParameter(item.getProperty(), item.getValue());
                    }
                }
            });
        }
        List result = query.list();
        return (int) result.get(0);
    }

    @Override
    public List<Especificacion> getByFilterSelects(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("ESPECIFICACION", "E");
        reverse.addResult("E.ID_ESPECIFICACION");
        reverse.addResult("E.DESCRIPCION");
        reverse.addResult("E.FECHA_INSERT");
        reverse.addResult("E.USU_INSERT");
        reverse.addResult("E.FECHA_UPDATE");
        reverse.addResult("E.USU_UPDATE");
        reverse.addResult("E.SITUACION");
        reverse.addResult("E.USA_ACTIVIDAD");
        reverse.addResult("E.ID_ECATEGORIA");
        reverse.addResult("EC.NOMBRE CATEGORIA");
        reverse.addResult("ISNULL(PT.ID_ESPECIFICACION ,0) ASIGNADO");
        reverse.addJoin("LEFT JOIN PLANTILLA PT", "PT.ID_ESPECIFICACION=E.ID_ESPECIFICACION AND PT.ID_CARROCERIA= :IDCARROCERIA");;
        reverse.addJoin("INNER JOIN ESPECIFICACION_CATEGORIA EC", "E.ID_ECATEGORIA=EC.ID_ECATEGORIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Especificacion.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                if ((item.getOperator().equalsIgnoreCase("in") || item.getOperator().equalsIgnoreCase("nin")) && item.getValue() != null) {
                    query.setParameterList(item.getProperty(), item.getValue().toString().split(","));
                } else {
                    query.setParameter(item.getProperty(), item.getValue());
                }
            });
        }
        return query.list();
    }

}
