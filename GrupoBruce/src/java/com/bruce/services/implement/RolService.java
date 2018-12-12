/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IRolDAO;
import com.bruce.dao.to.Rol;
import com.bruce.services.design.IRolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class RolService implements IRolService{
    
    @Autowired
    private IRolDAO dao;

    @Override
    @Transactional
    public void insert(Rol t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Rol t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Rol t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Rol find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<Rol> findAll() {
        return dao.getAll();
    }
    
}
