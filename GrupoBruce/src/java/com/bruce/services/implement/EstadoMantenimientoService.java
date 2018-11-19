/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEstadoMantenimientoDAO;
import com.bruce.dao.to.EstadoMantenimiento;
import com.bruce.services.design.IEstadoMantenimientoService;
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
public class EstadoMantenimientoService implements IEstadoMantenimientoService{
    
    @Autowired
    private IEstadoMantenimientoDAO dao;
    
    @Override
    @Transactional
    public List<EstadoMantenimiento> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EstadoMantenimiento lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(EstadoMantenimiento t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(EstadoMantenimiento t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EstadoMantenimiento t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EstadoMantenimiento find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<EstadoMantenimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
