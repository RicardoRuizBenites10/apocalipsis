/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IGeneroDAO;
import com.bruce.dao.to.Genero;
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
public class GeneroDAO implements IGeneroDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Genero> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Genero G WHERE G.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(Genero t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Genero t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Genero t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Genero find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genero> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Genero");
        return query.list();
    }

}
