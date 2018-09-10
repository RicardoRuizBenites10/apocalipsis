/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.INacionalidadDAO;
import com.bruce.dao.to.Nacionalidad;
import com.bruce.services.design.INacionalidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SISTEMAS
 */
@Service
public class NacionalidadService implements INacionalidadService{
    
    @Autowired
    private INacionalidadDAO dao;

    @Override
    public void insert(Nacionalidad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Nacionalidad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nacionalidad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nacionalidad> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Nacionalidad> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    public void update(Nacionalidad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
