/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEstadoEstudioDAO;
import com.bruce.dao.to.EstadoEstudio;
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
public class EstadoEstudioDAO implements IEstadoEstudioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EstadoEstudio> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EstadoEstudio EE WHERE EE.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(EstadoEstudio t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EstadoEstudio t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EstadoEstudio t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EstadoEstudio find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstadoEstudio> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EstadoEstudio");
        return query.list();
    }

}
