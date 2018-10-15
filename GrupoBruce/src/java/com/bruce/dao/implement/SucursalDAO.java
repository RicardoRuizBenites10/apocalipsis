/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.to.Sucursal;
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
public class SucursalDAO implements ISucursalDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void create(Sucursal t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Sucursal t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Sucursal t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Sucursal find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sucursal> findAll() {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Sucursal");
        return query.list();
    }

    @Override
    public List<Sucursal> filterByEmpresa(String idEmpresa) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Sucursal S WHERE S.idEmpresa = :empresa");
        query.setParameter("empresa", idEmpresa);
        return query.list();
    }

}
