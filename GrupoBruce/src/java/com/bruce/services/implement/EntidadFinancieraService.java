/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEntidadFinancieraDAO;
import com.bruce.dao.to.EntidadFinanciera;
import com.bruce.services.design.IEntidadFinancieraService;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class EntidadFinancieraService implements IEntidadFinancieraService {
    
    @Autowired
    private IEntidadFinancieraDAO dao;

    @Override
    @Transactional
    public void insert(EntidadFinanciera t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(EntidadFinanciera t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EntidadFinanciera find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<EntidadFinanciera> findAll() {
        return dao.getAll();
    }
    
    @Override
    @Transactional
    public List<EntidadFinanciera> findBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void update(EntidadFinanciera t) {
        dao.update(t);
    }
}
