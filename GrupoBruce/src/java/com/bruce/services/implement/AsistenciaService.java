/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.services.design.IAsistenciaService;
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
public class AsistenciaService implements IAsistenciaService{

    @Autowired
    private IAsistenciaDAO dao;
    
    @Override
    @Transactional
    public List<Asistencia> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Asistencia lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Asistencia t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Asistencia t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Asistencia t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Asistencia find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Asistencia> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
