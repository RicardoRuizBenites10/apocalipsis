/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ICargoDAO;
import com.bruce.dao.to.Cargo;
import com.bruce.services.design.ICargoService;
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
public class CargoService implements ICargoService{

    @Autowired
    private ICargoDAO dao;
    
    @Override
    @Transactional
    public List<Cargo> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, null, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Cargo lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Cargo t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idArea", t.getIdArea()));
        Cargo last = lastByFilter(filters);
        int idLast = last != null ? Integer.parseInt(last.getIdCargo().substring(2)) : 0;
        t.setIdCargo(t.getIdArea().substring(2) + String.format("%02d", idLast + 1));
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Cargo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Cargo t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Cargo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Cargo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
