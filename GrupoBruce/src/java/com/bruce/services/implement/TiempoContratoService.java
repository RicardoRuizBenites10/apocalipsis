/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITiempoContratoDAO;
import com.bruce.dao.to.TiempoContrato;
import com.bruce.services.design.ITiempoContratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class TiempoContratoService implements ITiempoContratoService{
    
    @Autowired
    private ITiempoContratoDAO dao;
    
    @Override
    @Transactional
    public void insert(TiempoContrato t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TiempoContrato t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TiempoContrato t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TiempoContrato find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TiempoContrato> findAll() {
        return dao.findAll();
    }
    
}
