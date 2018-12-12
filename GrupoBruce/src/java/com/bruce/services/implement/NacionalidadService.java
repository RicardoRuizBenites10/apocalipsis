/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.INacionalidadDAO;
import com.bruce.dao.to.Nacionalidad;
import com.bruce.services.design.INacionalidadService;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
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
        return dao.getAll();
    }

    @Override
    @Transactional
    public List<Nacionalidad> findBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void update(Nacionalidad t) {
        dao.update(t);
    }
    
}
