/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IObraDAO;
import com.bruce.dao.to.Obra;
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
public class ObraDAO implements IObraDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void create(Obra t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Obra t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Obra t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Obra get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Obra lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA", "O");
        reverse.addResult("O.ID_OBRA");
        reverse.addResult("O.FECHA");
        reverse.addResult("O.NOMBRE");
        reverse.addResult("O.NRO_CHASIS");
        reverse.addResult("O.FECHA_INGRESO");
        reverse.addResult("O.FECHA_SALIDA");
        reverse.addResult("O.FECHA_INICIO");
        reverse.addResult("O.FECHA_FIN");
        reverse.addResult("O.HASCONTRATISTA");
        reverse.addResult("O.GOPINTURA");
        reverse.addResult("O.GOPINTURAFECHA");
        reverse.addResult("O.ASIENTO_NROORDEN");
        reverse.addResult("O.ASIENTO_RECEPCION");
        reverse.addResult("O.EJECUCION");
        reverse.addResult("O.DETENIDO");
        reverse.addResult("O.TERMINADO");
        reverse.addResult("O.ENTREGADOSTO");
        reverse.addResult("O.ENTREGADOCLI");
        reverse.addResult("O.ID_OBRTIP");
        reverse.addResult("O.ID_PROFORMA");
        reverse.addResult("O.ID_EOBRA");
        reverse.addResult("O.ID_USUARIO");
        reverse.addResult("OT.DESCRIPCION TIPO");
        reverse.addResult("EO.NOMBRE ESTADO");
        reverse.addResult("CL.NOMBRE CLIENTE");
        reverse.addResult("PF.ID_CARROCERIA CARROCERIA");
        reverse.addJoin("INNER JOIN OBRA_TIPO OT", "OT.ID_OBRTIP=O.ID_OBRTIP");
        reverse.addJoin("INNER JOIN ESTADO_OBRA EO", "EO.ID_EOBRA=O.ID_EOBRA");
        reverse.addJoin("INNER JOIN PROFORMA PF", "PF.ID_PROFORMA=O.ID_PROFORMA");
        reverse.addJoin("INNER JOIN CLIENTE CL", "CL.ID_CLIENTE=PF.ID_CLIENTE");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_OBRA", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Obra.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        Obra item = !result.isEmpty() ? (Obra) result.get(0) : null;
        return item;
    }

    @Override
    public List<Obra> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Obra> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("OBRA", "O");
        reverse.addResult("O.ID_OBRA");
        reverse.addResult("O.FECHA");
        reverse.addResult("O.NOMBRE");
        reverse.addResult("O.NRO_CHASIS");
        reverse.addResult("O.FECHA_INGRESO");
        reverse.addResult("O.FECHA_SALIDA");
        reverse.addResult("O.FECHA_INICIO");
        reverse.addResult("O.FECHA_FIN");
        reverse.addResult("O.HASCONTRATISTA");
        reverse.addResult("O.GOPINTURA");
        reverse.addResult("O.GOPINTURAFECHA");
        reverse.addResult("O.ASIENTO_NROORDEN");
        reverse.addResult("O.ASIENTO_RECEPCION");
        reverse.addResult("O.EJECUCION");
        reverse.addResult("O.DETENIDO");
        reverse.addResult("O.TERMINADO");
        reverse.addResult("O.ENTREGADOSTO");
        reverse.addResult("O.ENTREGADOCLI");
        reverse.addResult("O.ID_OBRTIP");
        reverse.addResult("O.ID_PROFORMA");
        reverse.addResult("O.ID_EOBRA");
        reverse.addResult("O.ID_USUARIO");
        reverse.addResult("OT.DESCRIPCION TIPO");
        reverse.addResult("EO.NOMBRE ESTADO");
        reverse.addResult("CL.NOMBRE CLIENTE");
        reverse.addResult("PF.ID_CARROCERIA CARROCERIA");
        reverse.addJoin("INNER JOIN OBRA_TIPO OT", "OT.ID_OBRTIP=O.ID_OBRTIP");
        reverse.addJoin("INNER JOIN ESTADO_OBRA EO", "EO.ID_EOBRA=O.ID_EOBRA");
        reverse.addJoin("INNER JOIN PROFORMA PF", "PF.ID_PROFORMA=O.ID_PROFORMA");
        reverse.addJoin("INNER JOIN CLIENTE CL", "CL.ID_CLIENTE=PF.ID_CLIENTE");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Obra.class);
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
        ReverseQuery reverse = new ReverseQuery("OBRA", "O");
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
