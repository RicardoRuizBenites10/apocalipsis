/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IEmpresaDAO;
import com.bruce.dao.to.Empresa;
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
public class EmpresaDAO implements IEmpresaDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Empresa> filterBySituacion(boolean situacion) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Empresa E WHERE E.situacion = :situacion");
        query.setParameter("situacion", situacion);
        return query.list();
    }

    @Override
    public void create(Empresa t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Empresa t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Empresa t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Empresa find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empresa> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Empresa");
        return query.list();
    }

}
