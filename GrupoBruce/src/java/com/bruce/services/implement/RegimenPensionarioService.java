/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IRegimenPensionarioDAO;
import com.bruce.dao.to.RegimenPensionario;
import com.bruce.services.design.IRegimenPensionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class RegimenPensionarioService implements IRegimenPensionarioService{

    @Autowired
    private IRegimenPensionarioDAO dao;

    @Override
    public void insert(RegimenPensionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(RegimenPensionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegimenPensionario find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegimenPensionario> findAll() {
        return dao.findAll();
    }
    
    @Override
    public List<RegimenPensionario> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    public void update(RegimenPensionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
