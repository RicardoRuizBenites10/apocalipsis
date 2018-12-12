/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoAusenciaDAO;
import com.bruce.dao.to.TipoAusencia;
import com.bruce.services.design.ITipoAusenciaService;
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
public class TipoAusenciaService implements ITipoAusenciaService{

    @Autowired
    private ITipoAusenciaDAO dao;
    
    @Override
    @Transactional
    public List<TipoAusencia> getBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void insert(TipoAusencia t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TipoAusencia t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TipoAusencia t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoAusencia find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TipoAusencia> findAll() {
        return dao.getAll();
    }
    
}
