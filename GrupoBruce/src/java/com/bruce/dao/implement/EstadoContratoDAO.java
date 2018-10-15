/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEstadoContratoDAO;
import com.bruce.dao.to.EstadoContrato;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class EstadoContratoDAO implements IEstadoContratoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EstadoContrato> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EstadoContrato EC.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(EstadoContrato t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EstadoContrato t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EstadoContrato t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EstadoContrato find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstadoContrato> findAll() {
        Session session = sf.openSession();
        Query query = session.createQuery("FROM EstadoContrato");
        return query.list();
    }

}
