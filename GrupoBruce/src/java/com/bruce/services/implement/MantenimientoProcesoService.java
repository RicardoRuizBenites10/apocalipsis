/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IMantenimientoProcesoDAO;
import com.bruce.dao.to.MantenimientoProceso;
import com.bruce.util.FilterPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bruce.services.design.IMantenimientoProcesoService;

/**
 *
 * @author RICARDO
 */
@Service
public class MantenimientoProcesoService implements IMantenimientoProcesoService{
    
    @Autowired
    private IMantenimientoProcesoDAO dao;

    @Override
    @Transactional
    public List<MantenimientoProceso> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public MantenimientoProceso lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(MantenimientoProceso t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(MantenimientoProceso t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(MantenimientoProceso t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public MantenimientoProceso find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<MantenimientoProceso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
