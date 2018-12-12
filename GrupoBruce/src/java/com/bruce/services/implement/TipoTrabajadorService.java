/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoTrabajadorDAO;
import com.bruce.dao.to.TipoTrabajador;
import com.bruce.services.design.ITipoTrabajadorService;
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
public class TipoTrabajadorService implements ITipoTrabajadorService{

    @Autowired
    private ITipoTrabajadorDAO dao;

    @Override
    @Transactional
    public void insert(TipoTrabajador t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(TipoTrabajador t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoTrabajador find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<TipoTrabajador> findAll() {
        return dao.getAll();
    }
    
    @Override
    @Transactional
    public List<TipoTrabajador> findBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void update(TipoTrabajador t) {
        dao.update(t);
    }
    
}
