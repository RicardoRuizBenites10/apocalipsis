/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IPeriodoVacacionDAO;
import com.bruce.dao.to.PeriodoVacacion;
import com.bruce.services.design.IPeriodoVacacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class PeriodoVacacionService implements IPeriodoVacacionService{
    
    @Autowired
    private IPeriodoVacacionDAO dao;
    
    @Override
    @Transactional
    public List<PeriodoVacacion> getBySituacion(boolean situacion) {
        return dao.getBySituacion(situacion);
    }

    @Override
    @Transactional
    public void insert(PeriodoVacacion t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(PeriodoVacacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(PeriodoVacacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public PeriodoVacacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<PeriodoVacacion> findAll() {
        return dao.findAll();
    }
    
}
