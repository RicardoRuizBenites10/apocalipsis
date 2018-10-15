/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IPeriocidadDAO;
import com.bruce.dao.to.Periocidad;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class PeriocidadDAO implements IPeriocidadDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Periocidad> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Periocidad P WHERE P.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(Periocidad t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Periocidad t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Periocidad t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Periocidad find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periocidad> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Periocidad");
        return query.list();
    }

}
