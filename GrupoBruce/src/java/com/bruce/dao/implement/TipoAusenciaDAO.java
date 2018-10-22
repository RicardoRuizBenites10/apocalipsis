/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoAusenciaDAO;
import com.bruce.dao.to.TipoAusencia;
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
public class TipoAusenciaDAO implements ITipoAusenciaDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public List<TipoAusencia> getBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoAusencia.class);
        cr.add(Restrictions.eq("situacion", situacion));
        return cr.list();
    }

    @Override
    public void create(TipoAusencia t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoAusencia t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoAusencia t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoAusencia find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoAusencia> findAll() {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TipoAusencia.class);
        return cr.list();
    }
    
}
