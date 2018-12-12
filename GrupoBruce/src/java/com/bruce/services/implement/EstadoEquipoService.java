/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEstadoEquipoDAO;
import com.bruce.dao.to.EstadoEquipo;
import com.bruce.services.design.IEstadoEquipoService;
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
public class EstadoEquipoService implements IEstadoEquipoService{
    
    @Autowired
    private IEstadoEquipoDAO dao;
    
    @Override
    @Transactional
    public List<EstadoEquipo> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, null, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EstadoEquipo lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(EstadoEquipo t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(EstadoEquipo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EstadoEquipo t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EstadoEquipo find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<EstadoEquipo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
