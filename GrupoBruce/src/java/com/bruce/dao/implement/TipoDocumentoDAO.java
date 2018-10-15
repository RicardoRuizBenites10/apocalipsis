/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ITipoDocumentoDAO;
import com.bruce.dao.to.TipoDocumento;
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
public class TipoDocumentoDAO implements ITipoDocumentoDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<TipoDocumento> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoDocumento TD WHERE TD.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(TipoDocumento t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(TipoDocumento t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(TipoDocumento t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public TipoDocumento find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM TipoDocumento");
        return query.list();
    }

}
