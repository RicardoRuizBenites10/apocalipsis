/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEntidadFinancieraDAO;
import com.bruce.dao.to.EntidadFinanciera;
import com.bruce.services.design.IEntidadFinancieraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class EntidadFinancieraService implements IEntidadFinancieraService {
    
    @Autowired
    private IEntidadFinancieraDAO dao;

    @Override
    public void insert(EntidadFinanciera t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EntidadFinanciera t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntidadFinanciera find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadFinanciera> findAll() {
        return dao.findAll();
    }
    
    @Override
    public List<EntidadFinanciera> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    public void update(EntidadFinanciera t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
