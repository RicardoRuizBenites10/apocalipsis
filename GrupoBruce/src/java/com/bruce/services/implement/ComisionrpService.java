/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IComisionrpDAO;
import com.bruce.dao.to.Comisionrp;
import com.bruce.services.design.IComisionrpService;
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
public class ComisionrpService implements IComisionrpService{
    
    @Autowired
    private IComisionrpDAO dao;

    @Override
    @Transactional
    public void insert(Comisionrp t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(Comisionrp t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Comisionrp find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Comisionrp> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public void update(Comisionrp t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public List<Comisionrp> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Comisionrp lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }
}
