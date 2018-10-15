/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoContratoDAO;
import com.bruce.dao.to.TipoContrato;
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
public class TipoContratoDAO implements ITipoContratoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TipoContrato> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoContrato TC WHERE TC.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(TipoContrato t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoContrato t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoContrato t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoContrato find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoContrato> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoContrato");
        return query.list();
    }

}
