/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IECivilDAO;
import com.bruce.dao.to.Ecivil;
import com.bruce.services.design.IECivilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class ECivilService implements IECivilService {
    
    @Autowired
    private IECivilDAO dao;

    @Override
    public void insert(Ecivil t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Ecivil t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ecivil find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ecivil> findAll() {
        return dao.findAll();
    }
    
    @Override
    public List<Ecivil> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    public void update(Ecivil t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
