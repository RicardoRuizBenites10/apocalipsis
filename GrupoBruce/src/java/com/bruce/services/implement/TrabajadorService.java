/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import com.bruce.dao.to.perform.TrabajadorDTO;
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
    public List<TrabajadorDTO> findAllPerform() {
        return dao.getAllPerforms();
    }

    @Override
    public void create(Trabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Trabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Trabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trabajador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trabajador> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Trabajador> findPagination(int start, int limit) {
        return dao.getTrabajadorsPagination(start, limit);
    }

    @Override
    public int totalCount() {
        return dao.getTrabajadorCount();
    }
}
