/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEstadoEstudioDAO;
import com.bruce.dao.to.EstadoEstudio;
import com.bruce.services.design.IEstadoEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class EstadoEstudioService implements IEstadoEstudioService{
    
    @Autowired
    private IEstadoEstudioDAO dao;

    @Override
    @Transactional
    public List<EstadoEstudio> getBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    @Transactional
    public void insert(EstadoEstudio t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(EstadoEstudio t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EstadoEstudio t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EstadoEstudio find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<EstadoEstudio> findAll() {
        return dao.findAll();
    }
    
}
