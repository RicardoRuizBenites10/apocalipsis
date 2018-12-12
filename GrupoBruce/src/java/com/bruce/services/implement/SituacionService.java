/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ISituacionDAO;
import com.bruce.dao.to.Situacion;
import com.bruce.services.design.ISituacionService;
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
public class SituacionService implements ISituacionService{
    
    @Autowired
    private ISituacionDAO dao;

    @Override
    @Transactional
    public Situacion last(String idTrabajador) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTrabajador", idTrabajador));
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Situacion t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Situacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Situacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional(readOnly = true)
    public Situacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public List<Situacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
