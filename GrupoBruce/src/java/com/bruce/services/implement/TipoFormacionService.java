/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoFormacionDAO;
import com.bruce.dao.to.TipoFormacion;
import com.bruce.services.design.ITipoFormacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class TipoFormacionService implements ITipoFormacionService{
    
    @Autowired
    private ITipoFormacionDAO dao;
    
    @Override
    @Transactional
    public List<TipoFormacion> getBySituacion(boolean situacion) {
        return dao.getBySituacion(situacion);
    }

    @Override
    @Transactional
    public void insert(TipoFormacion t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TipoFormacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TipoFormacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoFormacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TipoFormacion> findAll() {
        return dao.findAll();
    }
    
}
