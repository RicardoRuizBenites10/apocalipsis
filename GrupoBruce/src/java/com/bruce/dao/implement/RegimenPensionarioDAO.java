/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IRegimenPensionarioDAO;
import com.bruce.dao.to.RegimenPensionario;
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
public class RegimenPensionarioDAO implements IRegimenPensionarioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<RegimenPensionario> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM RegimenPensionario RP WHERE RP.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(RegimenPensionario t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(RegimenPensionario t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(RegimenPensionario t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public RegimenPensionario find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegimenPensionario> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM RegimenPensionario");
        return query.list();
    }

}
