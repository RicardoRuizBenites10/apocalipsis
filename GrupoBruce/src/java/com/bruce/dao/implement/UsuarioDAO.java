/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IUsuarioDAO;
import com.bruce.dao.to.Usuario;
import com.bruce.util.FilterPage;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bruce.util.ReverseQuery;
import com.bruce.util.SortPage;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
        ReverseQuery reverse = new ReverseQuery("USUARIO", "U");
        reverse.addResult("U.ID_USUARIO");
        reverse.addResult("U.USU");
        reverse.addResult("DECRYPTBYPASSPHRASE('Bruces@22',U.CLAVE) AS CLAVE");
        reverse.addResult("U.ESTADO");
        reverse.addResult("U.ID_ROL");
        reverse.addResult("R.DENOMINACION AS rol");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS trabajador");
        reverse.addJoin("INNER JOIN Rol R", "R.ID_ROL = U.ID_ROL");
        reverse.addJoin("INNER JOIN Trabajador T", "T.ID_TRABAJADOR = U.ID_USUARIO");
        reverse.setFilters(filters);
        reverse.setSorts(sorts);
        reverse.setPagination(start, limit);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Usuario.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        return query.list();
    }

    @Override
    public Usuario valida(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        Usuario usuario = null;
        ReverseQuery reverse = new ReverseQuery("USUARIO", "U");
        reverse.addResult("U.ID_USUARIO");
        reverse.addResult("U.USU");
        reverse.addResult("DECRYPTBYPASSPHRASE('Bruces@22',U.CLAVE) AS CLAVE");
        reverse.addResult("U.ESTADO");
        reverse.addResult("U.ID_ROL");
        reverse.addResult("R.DENOMINACION AS rol");
        reverse.addResult("T.AP_PATERNO +' '+ T.AP_MATERNO + ', ' + T.NOMBRES AS trabajador");
        reverse.addJoin("INNER JOIN Rol R", "R.ID_ROL = U.ID_ROL");
        reverse.addJoin("INNER JOIN Trabajador T", "T.ID_TRABAJADOR = U.ID_USUARIO");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        query.addEntity(Usuario.class);
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        if (!result.isEmpty()) {
            usuario = (Usuario) result.get(0);
        }
        return usuario;
    }

    @Override
    public int countByFilter(List<FilterPage> filters) {
        Session session = sf.getCurrentSession();
        ReverseQuery reverse = new ReverseQuery("USUARIO", "U");
        reverse.setFilters(filters);
        SQLQuery query = session.createSQLQuery(reverse.getQuery());
        if (!filters.isEmpty()) {
            filters.forEach((item) -> {
                query.setParameter(item.getProperty(), item.getValue());
            });
        }
        List result = query.list();
        return (int) result.get(0);
    }

}
