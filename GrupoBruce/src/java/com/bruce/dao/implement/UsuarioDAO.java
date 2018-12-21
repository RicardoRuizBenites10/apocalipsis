/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IUsuarioDAO;
import com.bruce.dao.to.Usuario;
import com.bruce.util.FilterPage;
import com.bruce.util.Metodo;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.QueryUtil;
import com.bruce.util.SortPage;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class UsuarioDAO implements IUsuarioDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public Usuario valida(String usu, String pass) {
        Session session = sf.getCurrentSession();
        Usuario usuario = null;
        Query query = session.createQuery(QueryUtil.USUARIO_VALIDA);
        query.setParameter("usuario", usu);
        query.setParameter("pass", pass.getBytes());
        List result = query.list();
        Iterator iterator = result.iterator();
        if (iterator.hasNext()) {
            usuario = (Usuario) iterator.next();
        }
        return usuario;
    }

    @Override
    public void create(Usuario t) {
        sf.getCurrentSession().save(t);
    }

    @Override
    public void update(Usuario t) {
        sf.getCurrentSession().update(t);
    }

    @Override
    public void delete(Usuario t) {
        sf.getCurrentSession().delete(t);
    }

    @Override
    public Usuario get(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario lastByFilter(List<FilterPage> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> getAll() {
        Session session = sf.getCurrentSession();
        Criteria query = session.createCriteria(Usuario.class);
        return query.list();
    }

    @Override
    public List<Usuario> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        String filtros = Metodo.getFilters("U", filters);
        SQLQuery query = session.createSQLQuery(QueryUtil.USUARIOS + filtros);
        System.err.println("JOOODER: " + QueryUtil.USUARIOS + filtros);
        query.addEntity(Usuario.class);
        if (!filtros.trim().equalsIgnoreCase("")) {
            filters.forEach((item) -> {
                System.err.println("PARAMETRO: " + item.getProperty());
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
//        if (sorts != null) {
//            sorts.forEach(item -> {
//                cr.addOrder(item.getDirection().equalsIgnoreCase("ASC") ? Order.asc(item.getProperty()) : Order.desc(item.getProperty()));
//            });
//        }
        return query.list();
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Criteria cr = session.createCriteria(Usuario.class);
        if (filters != null) {
            filters.forEach(item -> {
                cr.add(Restrictions.eq(item.getProperty(), item.getValue()));
            });
        }
        cr.setProjection(Projections.rowCount());
        List result = cr.list();
        return ((Long) result.get(0)).intValue();
    }

}
