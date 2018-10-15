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
        return dao.last(idTrabajador);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Situacion currentSituacion) {
        Situacion lastSituacion = dao.last(currentSituacion.getIdTrabajador());
        int idLast = 0;
        if (lastSituacion != null) {
            idLast = lastSituacion.getIdSituacion();
        }
        currentSituacion.setIdSituacion(idLast + 1);
        dao.create(currentSituacion);
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
