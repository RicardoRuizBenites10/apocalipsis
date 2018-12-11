/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IAccesoDAO;
import com.bruce.dao.to.Acceso;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class AccesoDAO implements IAccesoDAO{
    
    @Autowired
    private SessionFactory sf;
    
    @Override
    public Acceso filterByID(String idUsuario, int idMenu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Acceso acceso) {
        sf.getCurrentSession().save(acceso);
    }

    @Override
    public void update(Acceso acceso) {
        sf.getCurrentSession().update(acceso);
    }

    @Override
    public void delete(Acceso acceso) {
        sf.getCurrentSession().delete(acceso);
    }

    @Override
    public Acceso get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Acceso lastByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Acceso> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Acceso> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
