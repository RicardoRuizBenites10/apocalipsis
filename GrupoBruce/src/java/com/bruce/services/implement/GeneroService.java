/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IGeneroDAO;
import com.bruce.dao.to.Genero;
import com.bruce.services.design.IGeneroService;
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
        return dao.findAll();
    }
    
    @Override
    @Transactional
    public List<Genero> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    @Transactional
    public void update(Genero t) {
        dao.update(t);
    }
}
