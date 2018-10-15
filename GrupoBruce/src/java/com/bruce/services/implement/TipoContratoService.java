/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoContratoDAO;
import com.bruce.dao.to.TipoContrato;
import com.bruce.services.design.ITipoContratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class TipoContratoService implements ITipoContratoService{

    @Autowired
    private ITipoContratoDAO dao;
        
    @Override
    @Transactional
    public void insert(TipoContrato t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TipoContrato t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TipoContrato t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoContrato find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TipoContrato> findAll() {
        return dao.findAll();
    }
    
}
