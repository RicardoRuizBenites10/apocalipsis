/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IHijoDAO;
import com.bruce.dao.to.Hijo;
import com.bruce.services.design.IHijoService;
import com.bruce.util.FilterPage;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SISTEMAS
 */
@Service
public class HijoService implements IHijoService{
    
    @Autowired
    private IHijoDAO dao;

    @Override
    public List<Hijo> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.filterByPadre(start, limit, filters);
    }

    @Override
    public int countFilter(List<FilterPage> filters) {
        return dao.countHijos(filters);
    }

    @Override
    public Map<String, Object> last(String idTrabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Hijo t) {
        dao.create(t);
    }

    @Override
    public void update(Hijo t) {
        dao.update(t);
    }

    @Override
    public void delete(Hijo t) {
        dao.delete(t);
    }

    @Override
    public Hijo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hijo> findAll() {
        return dao.findAll();
    }
    
}
