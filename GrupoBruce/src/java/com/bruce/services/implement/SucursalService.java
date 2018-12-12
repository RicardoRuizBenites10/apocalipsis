/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.to.Sucursal;
import com.bruce.services.design.ISucursalService;
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
public class SucursalService implements ISucursalService{
    
    @Autowired
    private ISucursalDAO dao;

    @Override
    @Transactional
    public void insert(Sucursal t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(Sucursal t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Sucursal find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Sucursal> findAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public void update(Sucursal t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public List<Sucursal> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, null, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Sucursal lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }
    
}
