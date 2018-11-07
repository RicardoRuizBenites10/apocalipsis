/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IMantenimientoDAO;
import com.bruce.dao.to.Mantenimiento;
import com.bruce.services.design.IMantenimientoService;
import com.bruce.util.FilterPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class MantenimientoService implements IMantenimientoService{
    
    @Autowired
    private IMantenimientoDAO dao;
    
    @Override
    @Transactional
    public List<Mantenimiento> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Mantenimiento lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Mantenimiento t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Mantenimiento t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Mantenimiento t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Mantenimiento find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<Mantenimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
