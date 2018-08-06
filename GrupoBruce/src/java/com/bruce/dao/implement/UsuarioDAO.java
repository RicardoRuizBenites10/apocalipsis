/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.implement;

import com.bruce.dao.design.IUsuarioDAO;
import com.bruce.dao.to.Usuario;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bruce.persistence.HibernateUtil;
import com.bruce.util.QuerySQL;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class UsuarioDAO implements IUsuarioDAO {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public Usuario valida(String usu, String pass) {
        Session session = sf.openSession();
        Usuario usuario=null;
        try {
            Query query = session.createQuery(QuerySQL.USUARIO_VALIDA);
            query.setParameter("usuario", usu);
            query.setParameter("pass", pass.getBytes());
            List result = query.list();
            Iterator iterator = result.iterator();
            if(iterator.hasNext()){
                usuario =  (Usuario) iterator.next();
//                Hibernate.initialize(usuario.getTrabajador());
//                Hibernate.initialize(usuario.getTrabajador().getEstadoTrabajador().getTrabajadors());
//                Hibernate.initialize(usuario.getTrabajador().getFormaPago().getTrabajadors());
//                Hibernate.initialize(usuario.getTrabajador().getNacionalidad().getTrabajadors());
//                Hibernate.initialize(usuario.getTrabajador().getPeriocidad().getTrabajadors());
//                Hibernate.initialize(usuario.getTrabajador().getPersona().getEcivil().getPersonas());
//                Hibernate.initialize(usuario.getTrabajador().getPersona().getGenero().getPersonas());
//                Hibernate.initialize(usuario.getTrabajador().getPersona().getTipoDocumento().getPersonas());
//                Hibernate.initialize(usuario.getTrabajador().getSucursal().getTrabajadors());
//                Hibernate.initialize(usuario.getTrabajador().getSucursal().getEmpresa().getSucursals());
//                Hibernate.initialize(usuario.getTrabajador().getTipoTrabajador().getTrabajadors());
//                Hibernate.initialize(usuario.getTrabajador().getTipoTrabajador().getPeriodos());
//                Hibernate.initialize(usuario.getAccesos());
            }
        } catch (HibernateException he) {
            throw he;
        } finally {
            session.close();
        }
        return usuario;
    }

    @Override
    public void create(Usuario t) {
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll() {
        Session session = sf.openSession();
        Transaction tx = null;
        List listUsuario = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Usuario");
            listUsuario = query.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return listUsuario;
    }

}
