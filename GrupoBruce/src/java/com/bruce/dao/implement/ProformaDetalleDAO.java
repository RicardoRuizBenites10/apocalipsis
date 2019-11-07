/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IProformaDetalleDAO;
import com.bruce.dao.to.ProformaDetalle;
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
public class ProformaDetalleDAO implements IProformaDetalleDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(ProformaDetalle t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(ProformaDetalle t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(ProformaDetalle t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public ProformaDetalle get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProformaDetalle lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PROFORMA_DETALLE", "PD");
        reverse.addResult("PD.ID_PROFORMA");
        reverse.addResult("PD.ID_ESPECIFICACION");
        reverse.addResult("PD.FECHA_UPDATE");
        reverse.addResult("PD.WASSTD");
        reverse.addResult("PD.ASIGNADO");
        reverse.addResult("PD.USU_UPDATE");
        reverse.addResult("ES.DESCRIPCION ESPECIFICACION");
        reverse.addJoin("INNER JOIN PROFORMA PF", "PD.ID_PROFORMA=PF.ID_PROFORMA AND PF.ID_CARROCERIA=:PF.ID_CARROCERIA");
        reverse.addJoin("INNER JOIN ESPECIFICACION ES", "ES.ID_ESPECIFICACION=PD.ID_ESPECIFICACION");
        reverse.setFilters(filters);
        reverse.getLSorts().add(new SortPage("ID_ESPECIFICACION", "DESC"));
        reverse.setPagination(0, 1);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ProformaDetalle.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        ProformaDetalle item = !result.isEmpty() ? (ProformaDetalle) result.get(0) : null;
        return item;
    }

    @Override
    public List<ProformaDetalle> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProformaDetalle> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PROFORMA_DETALLE", "PD");
        reverse.addResult("PD.ID_PROFORMA");
        reverse.addResult("PD.ID_ESPECIFICACION");
        reverse.addResult("PD.FECHA_UPDATE");
        reverse.addResult("PD.WASSTD");
        reverse.addResult("PD.ASIGNADO");
        reverse.addResult("PD.USU_UPDATE");
        reverse.addResult("ES.DESCRIPCION ESPECIFICACION");
        reverse.addResult("EC.NOMBRE CATEGORIA");
        reverse.addJoin("INNER JOIN PROFORMA PF", "PD.ID_PROFORMA=PF.ID_PROFORMA AND PF.ID_CARROCERIA=:PF.ID_CARROCERIA");
        reverse.addJoin("INNER JOIN ESPECIFICACION ES", "ES.ID_ESPECIFICACION=PD.ID_ESPECIFICACION");
        reverse.addJoin("INNER JOIN ESPECIFICACION_CATEGORIA EC", "ES.ID_ECATEGORIA=EC.ID_ECATEGORIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ProformaDetalle.class);
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
        ReverseQuery reverse = new ReverseQuery("PROFORMA_DETALLE", "PD");
        reverse.addJoin("INNER JOIN PROFORMA PF", "PD.ID_PROFORMA=PF.ID_PROFORMA AND PF.ID_CARROCERIA=:PF.ID_CARROCERIA");
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
    public List<ProformaDetalle> getByFilterP(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("PLANTILLA", "PF");
        reverse.addResult("0 ID_PROFORMA");
        reverse.addResult("PF.ID_ESPECIFICACION");
        reverse.addResult("GETDATE() FECHA_UPDATE");
        reverse.addResult("1 WASSTD");
        reverse.addResult("1 ASIGNADO");
        reverse.addResult("'' USU_UPDATE");
        reverse.addResult("ES.DESCRIPCION ESPECIFICACION");
        reverse.addResult("EC.NOMBRE CATEGORIA");
        reverse.addJoin("INNER JOIN ESPECIFICACION ES", "PF.ID_ESPECIFICACION=ES.ID_ESPECIFICACION AND PF.ID_CARROCERIA=:PF.ID_CARROCERIA");
        reverse.addJoin("INNER JOIN ESPECIFICACION_CATEGORIA EC", "ES.ID_ECATEGORIA=EC.ID_ECATEGORIA");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(ProformaDetalle.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

}
