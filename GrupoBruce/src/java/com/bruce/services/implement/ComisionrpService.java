/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IComisionrpDAO;
import com.bruce.dao.to.Comisionrp;
import com.bruce.services.design.IComisionrpService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class ComisionrpService implements IComisionrpService{
    
    @Autowired
    private IComisionrpDAO dao;
    
    @Override
    public void create(Comisionrp t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Comisionrp t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Comisionrp t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comisionrp find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comisionrp> findAll() {
        return dao.findAll();
    }
    
    @Override
    public List<Comisionrp> findByRPensionario(String idRPensionario) {
        return dao.findByRPensionario(idRPensionario);
    }
}