/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import com.bruce.services.design.ITrabajadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SISTEMAS
 */
@Service
public class TrabajadorService implements ITrabajadorService{
    
    @Autowired
    private ITrabajadorDAO dao;

    @Override
    public void insert(Trabajador t) {
        dao.create(t);
    }

    @Override
    public void delete(Trabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trabajador find(Object id) {
        return dao.find(id);
    }

    @Override
    public List<Trabajador> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Trabajador> findPagination(int start, int limit, List<SortPage> sorts) {
        return dao.getTrabajadorsPagination(start, limit, sorts);
    }

    @Override
    public int totalCount() {
        return dao.getTrabajadorCount();
    }

    @Override
    public void update(Trabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
