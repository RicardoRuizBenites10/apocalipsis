/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEntidadFinancieraDAO;
import com.bruce.dao.to.EntidadFinanciera;
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
public class EntidadFinancieraDAO implements IEntidadFinancieraDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<EntidadFinanciera> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EntidadFinanciera EF WHERE EF.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(EntidadFinanciera t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(EntidadFinanciera t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(EntidadFinanciera t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public EntidadFinanciera find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadFinanciera> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM EntidadFinanciera");
        return query.list();
    }

}
