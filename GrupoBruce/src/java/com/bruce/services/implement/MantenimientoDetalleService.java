/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IMantenimientoDetalleDAO;
import com.bruce.dao.to.MantenimientoDetalle;
import com.bruce.util.FilterPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bruce.services.design.IMantenimientoDetalleService;

/**
 *
 * @author RICARDO
 */
@Service
public class MantenimientoDetalleService implements IMantenimientoDetalleService{
    
    @Autowired
    private IMantenimientoDetalleDAO dao;

    @Override
    @Transactional
    public List<MantenimientoDetalle> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public MantenimientoDetalle lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(MantenimientoDetalle t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(MantenimientoDetalle t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(MantenimientoDetalle t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public MantenimientoDetalle find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<MantenimientoDetalle> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
