/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoVacacionDAO;
import com.bruce.dao.to.TipoVacacion;
import com.bruce.services.design.ITipoVacacionService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class TipoVacacionService implements ITipoVacacionService{

    @Autowired
    private ITipoVacacionDAO dao;
    
    @Override
    @Transactional
    public List<TipoVacacion> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, null, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(TipoVacacion t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TipoVacacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TipoVacacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoVacacion find(Object idT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TipoVacacion> findAll() {
        return dao.getAll();
    }
    
}
