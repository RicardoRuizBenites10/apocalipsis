/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.INacionalidadDAO;
import com.bruce.dao.to.Nacionalidad;
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
public class NacionalidadDAO implements INacionalidadDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Nacionalidad t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Nacionalidad t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Nacionalidad t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Nacionalidad find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nacionalidad> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Nacionalidad");
        return query.list();
    }

    @Override
    public List<Nacionalidad> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Nacionalidad N WHERE N.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }
}
