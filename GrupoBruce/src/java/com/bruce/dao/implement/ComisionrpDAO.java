/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IComisionrpDAO;
import com.bruce.dao.to.Comisionrp;
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
public class ComisionrpDAO implements IComisionrpDAO {

//    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    @Autowired(required = true)
    private SessionFactory sf;

    @Override
    public void create(Comisionrp t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comisionrp t) {
        Session session = sf.getCurrentSession();
        session.update(t);
    }

    @Override
    public void delete(Comisionrp t) {
        Session session = sf.getCurrentSession();
        session.delete(t);
    }

    @Override
    public Comisionrp find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comisionrp> findAll() {
        Session session = sf.getCurrentSession();
        List result = session.createQuery("FROM Comisionrp").list();
        return result;
    }

    @Override
    public List<Comisionrp> findByRPensionario(String idRPensionario) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("FROM Comisionrp WHERE idRpensionario :idRPensionario");
        query.setParameter("idRPensionario", idRPensionario);
        return query.list();
    }

}
