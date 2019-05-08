/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ICarroceriaDAO;
import com.bruce.dao.to.Carroceria;
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
public class CarroceriaDAO implements ICarroceriaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Carroceria t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Carroceria t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Carroceria t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Carroceria get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carroceria lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CARROCERIA", "CC");
        reverse.addResult("CC.ID_CARROCERIA");
        reverse.addResult("CC.CODIGO");
        reverse.addResult("CC.FECHA");
        reverse.addResult("CC.DESCRIPCION");
        reverse.addResult("CC.SITUACION");
        reverse.addResult("CC.ID_CHAPRO");
        reverse.addResult("CC.ID_CHASIS");
        reverse.addResult("CC.ID_CARMOD");
        reverse.addResult("CC.ID_CARTIP");
        reverse.addResult("CC.ID_CARFAL");
        reverse.addResult("CM.NOMBRE TIPO");
        reverse.addResult("CT.NOMBRE SUBTIPO");
        reverse.addResult("CF.NOMBRE FALDA");
        reverse.addResult("CHP.NOMBRE PROVEEDOR");
        reverse.addResult("CH.MODELO CHASIS");
        reverse.addJoin("INNER JOIN CARROCERIA_MODELO CM", "CM.ID_CARMOD=CC.ID_CARMOD");
        reverse.addJoin("INNER JOIN CARROCERIA_TIPO CT", "CT.ID_CARTIP=CC.ID_CARTIP AND CT.ID_CARMOD=CM.ID_CARMOD");
        reverse.addJoin("INNER JOIN CARROCERIA_FALDA CF", "CF.ID_CARFAL=CC.ID_CARFAL");
        reverse.addJoin("INNER JOIN CHASIS_PROVEEDOR CHP", "CHP.ID_CHAPRO=CC.ID_CHAPRO");
        reverse.addJoin("INNER JOIN CHASIS CH", "CH.ID_CHASIS=CC.ID_CHASIS");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_CARROCERIA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Carroceria.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Carroceria item = !result.isEmpty() ? (Carroceria) result.get(0) : null;
        return item;
    }

    @Override
    public List<Carroceria> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carroceria> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("CARROCERIA", "CC");
        reverse.addResult("CC.ID_CARROCERIA");
        reverse.addResult("CC.CODIGO");
        reverse.addResult("CC.FECHA");
        reverse.addResult("CC.DESCRIPCION");
        reverse.addResult("CC.SITUACION");
        reverse.addResult("CC.ID_CHAPRO");
        reverse.addResult("CC.ID_CHASIS");
        reverse.addResult("CC.ID_CARMOD");
        reverse.addResult("CC.ID_CARTIP");
        reverse.addResult("CC.ID_CARFAL");
        reverse.addResult("CM.NOMBRE TIPO");
        reverse.addResult("CT.NOMBRE SUBTIPO");
        reverse.addResult("CF.NOMBRE FALDA");
        reverse.addResult("CHP.NOMBRE PROVEEDOR");
        reverse.addResult("CH.MODELO CHASIS");
        reverse.addJoin("INNER JOIN CARROCERIA_MODELO CM", "CM.ID_CARMOD=CC.ID_CARMOD");
        reverse.addJoin("INNER JOIN CARROCERIA_TIPO CT", "CT.ID_CARTIP=CC.ID_CARTIP AND CT.ID_CARMOD=CM.ID_CARMOD");
        reverse.addJoin("INNER JOIN CARROCERIA_FALDA CF", "CF.ID_CARFAL=CC.ID_CARFAL");
        reverse.addJoin("INNER JOIN CHASIS_PROVEEDOR CHP", "CHP.ID_CHAPRO=CC.ID_CHAPRO");
        reverse.addJoin("INNER JOIN CHASIS CH", "CH.ID_CHASIS=CC.ID_CHASIS");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Carroceria.class);
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
        ReverseQuery reverse = new ReverseQuery("CARROCERIA", "CC");
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
