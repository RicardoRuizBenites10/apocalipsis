/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoEstudioDAO;
import com.bruce.dao.to.TipoEstudio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class TipoEstudioDAO implements ITipoEstudioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TipoEstudio> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoEstudio.class);
        cr.add(Restrictions.eq("situacion", situacion));
        return cr.list();
    }

    @Override
    public void create(TipoEstudio t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoEstudio t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoEstudio t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoEstudio find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoEstudio> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoEstudio");
        return query.list();
    }

}
