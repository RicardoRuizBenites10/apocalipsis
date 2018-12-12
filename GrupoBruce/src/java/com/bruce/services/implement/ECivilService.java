/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IECivilDAO;
import com.bruce.dao.to.Ecivil;
import com.bruce.services.design.IECivilService;
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
public class ECivilService implements IECivilService {

    @Autowired
    private IECivilDAO dao;

    @Override
    @Transactional
    public void insert(Ecivil t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(Ecivil t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Ecivil find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Ecivil> findAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public List<Ecivil> findBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void update(Ecivil t) {
        dao.update(t);
    }

}
