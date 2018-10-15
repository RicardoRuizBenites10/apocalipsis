/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEstadoTrabajadorDAO;
import com.bruce.dao.to.EstadoTrabajador;
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
public class EstadoTrabajadorDAO implements IEstadoTrabajadorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EstadoTrabajador> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EstadoTrabajador ET WHERE ET.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(EstadoTrabajador t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EstadoTrabajador t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EstadoTrabajador t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EstadoTrabajador find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstadoTrabajador> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EstadoTrabajador");
        return query.list();
    }

}
