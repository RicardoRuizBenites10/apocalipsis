/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IFormaPagoDAO;
import com.bruce.dao.to.FormaPago;
import com.bruce.services.design.IFormaPagoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class FormaPagoService implements IFormaPagoService{
    
    @Autowired
    private IFormaPagoDAO dao;

    @Override
    public void create(FormaPago t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(FormaPago t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(FormaPago t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormaPago find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FormaPago> findAll() {
        return dao.findAll();
    }

    @Override
    public List<FormaPago> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }
    
}
