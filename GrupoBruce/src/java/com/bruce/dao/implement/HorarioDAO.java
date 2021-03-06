/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IHorarioDAO;
import com.bruce.dao.to.Horario;
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
public class HorarioDAO implements IHorarioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Horario t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Horario t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Horario t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Horario get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("HORARIO", "H");
        reverse.addResult("H.ID_TURNO");
        reverse.addResult("H.HORA_ENTRADA");
        reverse.addResult("H.HORA_SALIDA");
        reverse.addResult("H.REFRIGERIO");
        reverse.addResult("H.LIBRE");
        reverse.addResult("H.SITUACION");
        reverse.addResult("H.ID_DIA");
        reverse.addResult("D.DESCRIPCION AS DIA");
        reverse.addJoin("INNER JOIN DIA D", "D.ID_DIA = H.ID_DIA");
        reverse.addJoin("INNER JOIN TURNO T", "T.ID_TURNO = H.ID_TURNO");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_TURNO", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Horario.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Horario horario = !result.isEmpty() ? (Horario) result.get(0) : null;
        return horario;
    }

    @Override
    public List<Horario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Horario> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("HORARIO", "H");
        reverse.addResult("H.ID_TURNO");
        reverse.addResult("H.HORA_ENTRADA");
        reverse.addResult("H.HORA_SALIDA");
        reverse.addResult("H.REFRIGERIO");
        reverse.addResult("H.LIBRE");
        reverse.addResult("H.SITUACION");
        reverse.addResult("H.ID_DIA");
        reverse.addResult("D.DESCRIPCION AS DIA");
        reverse.addJoin("INNER JOIN DIA D", "D.ID_DIA = H.ID_DIA");
        reverse.addJoin("INNER JOIN TURNO T", "T.ID_TURNO = H.ID_TURNO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Horario.class);
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
        ReverseQuery reverse = new ReverseQuery("HORARIO", "H");
        reverse.addJoin("INNER JOIN DIA D", "D.ID_DIA = H.ID_DIA");
        reverse.addJoin("INNER JOIN TURNO T", "T.ID_TURNO = H.ID_TURNO");
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
