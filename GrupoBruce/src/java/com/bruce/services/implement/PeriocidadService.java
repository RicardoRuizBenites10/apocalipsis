/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IPeriocidadDAO;
import com.bruce.dao.to.Periocidad;
import com.bruce.services.design.IPeriocidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class PeriocidadService implements IPeriocidadService {
    
    @Autowired
    private IPeriocidadDAO dao;

    @Override
    public void create(Periocidad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Periocidad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Periocidad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Periocidad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periocidad> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Periocidad> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }
    
}
