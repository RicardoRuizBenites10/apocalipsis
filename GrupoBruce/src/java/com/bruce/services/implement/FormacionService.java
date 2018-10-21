/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IFormacionDAO;
import com.bruce.dao.to.Formacion;
import com.bruce.services.design.IFormacionService;
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
public class FormacionService implements IFormacionService{

    @Autowired
    private IFormacionDAO dao;
    
    @Override
    @Transactional
    public List<Formacion> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Formacion lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Formacion t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTrabajador", t.getIdTrabajador()));
        Formacion last = lastByFilter(filters);
        int idLast = last != null ? last.getIdFormacion() : 0;
        t.setIdFormacion(idLast + 1);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Formacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Formacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Formacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Formacion> findAll() {
        return dao.findAll();
    }
    
}
