/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IECivilDAO;
import com.bruce.dao.to.Ecivil;
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
public class ECivilDAO implements IECivilDAO {

//    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    @Autowired
    private SessionFactory sf;

    @Override
    public List<Ecivil> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Ecivil EC WHERE EC.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(Ecivil t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Ecivil t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Ecivil t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Ecivil find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ecivil> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Ecivil");
        return query.list();
    }

}
