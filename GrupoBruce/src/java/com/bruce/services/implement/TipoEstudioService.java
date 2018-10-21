/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoEstudioDAO;
import com.bruce.dao.to.TipoEstudio;
import com.bruce.services.design.ITipoEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class TipoEstudioService implements ITipoEstudioService{
    
    @Autowired
    private ITipoEstudioDAO dao;

    @Override
    @Transactional
    public List<TipoEstudio> getBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    @Transactional
    public void insert(TipoEstudio t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TipoEstudio t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TipoEstudio t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoEstudio find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TipoEstudio> findAll() {
        return dao.findAll();
    }
    
}
