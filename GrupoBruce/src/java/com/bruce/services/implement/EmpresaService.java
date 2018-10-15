/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEmpresaDAO;
import com.bruce.dao.to.Empresa;
import com.bruce.services.design.IEmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class EmpresaService implements IEmpresaService {
    
    @Autowired
    private IEmpresaDAO dao;

    @Override
    @Transactional
    public void insert(Empresa t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void delete(Empresa t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Empresa find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Empresa> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<Empresa> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    @Transactional
    public void update(Empresa t) {
        dao.update(t);
    }
    
}
