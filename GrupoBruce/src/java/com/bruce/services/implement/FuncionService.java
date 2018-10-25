/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IFuncionDAO;
import com.bruce.dao.to.Funcion;
import com.bruce.services.design.IFuncionService;
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
public class FuncionService implements IFuncionService{
    
    @Autowired
    private IFuncionDAO dao;
    
    @Override
    @Transactional
    public List<Funcion> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Funcion lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Funcion t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Funcion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Funcion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Funcion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Funcion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
