/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
        Criteria cr = session.createCriteria(Asistencia.class);
        if (!filters.isEmpty()) {
            filters.forEach(item -> {
                if (item.getProperty().equalsIgnoreCase("fecha")) {
                    System.err.println("Mi fecha: " + item.getValue());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        cr.add(Restrictions.eq(item.getProperty(), formatoFecha.parse(String.valueOf(item.getValue()))));
                    } catch (ParseException ex) {
                        Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                }
            });
        }
        if (sorts != null) {
            sorts.forEach(item -> {
                cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
            });
        }
        cr.setFirstResult(start);
        cr.setMaxResults(limit);
        return cr.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Asistencia.class);
        if (filters != null) {
            filters.forEach(item -> {
                if (item.getProperty().equalsIgnoreCase("fecha")) {
                    System.err.println("Mi fecha: " + item.getValue());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        cr.add(Restrictions.eq(item.getProperty(), formatoFecha.parse(String.valueOf(item.getValue()))));
                    } catch (ParseException ex) {
                        Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
                }
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }

    @Override
    public Asistencia lastByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Asistencia asistencia = null;
        Criteria cr = session.createCriteria(Asistencia.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.addOrder(Order.desc("idAsistencia"));
        cr.setFirstResult(0);

        List result = cr.list();
        if (result.size() > 0) {
            asistencia = (Asistencia) result.get(0);
        }
        return asistencia;
    }

    @Override
    public void create(Asistencia t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Asistencia t) {
        sf.getCurrentSession().update(t);
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
