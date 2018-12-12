/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IGeneroDAO;
import com.bruce.dao.to.Genero;
import com.bruce.services.design.IGeneroService;
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
public class GeneroService implements IGeneroService {
    
    @Autowired
    private IGeneroDAO dao;

    @Override
    @Transactional
    public void insert(Genero t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(Genero t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Genero find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Genero> findAll() {
        return dao.getAll();
    }
    
    @Override
    @Transactional
    public List<Genero> findBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void update(Genero t) {
        dao.update(t);
    }
}
