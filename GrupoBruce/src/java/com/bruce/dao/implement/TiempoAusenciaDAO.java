/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITiempoAusenciaDAO;
import com.bruce.dao.to.TiempoAusencia;
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
public class TiempoAusenciaDAO implements ITiempoAusenciaDAO{
    
    @Autowired
    private SessionFactory sf;

    @Override
    public List<TiempoAusencia> getBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TiempoAusencia.class);
        cr.add(Restrictions.eq("situacion", situacion));
        return cr.list();
    }

    @Override
    public void create(TiempoAusencia t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TiempoAusencia t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TiempoAusencia t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TiempoAusencia find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TiempoAusencia> findAll() {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(TiempoAusencia.class);
        return cr.list();
    }
    
}
