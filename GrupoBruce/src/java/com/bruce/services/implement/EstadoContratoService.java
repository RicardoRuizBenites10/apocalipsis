/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEstadoContratoDAO;
import com.bruce.dao.to.EstadoContrato;
import com.bruce.services.design.IEstadoContratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class EstadoContratoService implements IEstadoContratoService{
    
    @Autowired
    private IEstadoContratoDAO dao;
    
    @Override
    @Transactional
    public void insert(EstadoContrato t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(EstadoContrato t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EstadoContrato t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EstadoContrato find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<EstadoContrato> findAll() {
        return dao.findAll();
    }
    
}
