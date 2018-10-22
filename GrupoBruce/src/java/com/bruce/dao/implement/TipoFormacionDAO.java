/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoFormacionDAO;
import com.bruce.dao.to.TipoFormacion;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RICARDO
 */
@Repository
public class TipoFormacionDAO implements ITipoFormacionDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<TipoFormacion> getBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoFormacion.class);
        cr.add(Restrictions.eq("situacion", situacion));
        return cr.list();
    }

    @Override
    public void create(TipoFormacion t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoFormacion t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoFormacion t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoFormacion find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoFormacion> findAll() {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoFormacion.class);
        return cr.list();
    }
    
}
