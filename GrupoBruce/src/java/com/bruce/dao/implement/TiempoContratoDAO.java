/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITiempoContratoDAO;
import com.bruce.dao.to.TiempoContrato;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RICARDO
 */
@Repository
public class TiempoContratoDAO implements ITiempoContratoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TiempoContrato> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TiempoContrato TC WHERE TC.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(TiempoContrato t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TiempoContrato t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TiempoContrato t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TiempoContrato find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TiempoContrato> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TiempoContrato");
        return query.list();
    }

}
