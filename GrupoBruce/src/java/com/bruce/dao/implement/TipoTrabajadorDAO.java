/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoTrabajadorDAO;
import com.bruce.dao.to.TipoTrabajador;
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
public class TipoTrabajadorDAO implements ITipoTrabajadorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TipoTrabajador> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoTrabajador TT WHERE TT.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(TipoTrabajador t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoTrabajador t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoTrabajador t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoTrabajador find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoTrabajador> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoTrabajador");
        return query.list();
    }

}
