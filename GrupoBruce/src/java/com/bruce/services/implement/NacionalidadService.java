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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class NacionalidadService implements INacionalidadService{
    
    @Autowired
    private INacionalidadDAO dao;

    @Override
    @Transactional
    public void insert(Nacionalidad t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(Nacionalidad t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Nacionalidad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Nacionalidad> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<Nacionalidad> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    @Transactional
    public void update(Nacionalidad t) {
        dao.update(t);
    }
    
}
