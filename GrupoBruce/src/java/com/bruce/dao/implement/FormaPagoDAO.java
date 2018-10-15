/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IFormaPagoDAO;
import com.bruce.dao.to.FormaPago;
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
public class FormaPagoDAO implements IFormaPagoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<FormaPago> filterBySituacion(boolean situacion) {
        Session session = sf.openSession();
        Query query = session.createQuery("FROM FormaPago FP WHERE FP.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(FormaPago t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(FormaPago t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(FormaPago t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public FormaPago find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FormaPago> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM FormaPago");
        return query.list();
    }

}
