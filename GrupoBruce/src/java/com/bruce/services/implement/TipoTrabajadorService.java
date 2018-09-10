/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoTrabajadorDAO;
import com.bruce.dao.to.TipoTrabajador;
import com.bruce.services.design.ITipoTrabajadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class TipoTrabajadorService implements ITipoTrabajadorService{

    @Autowired
    private ITipoTrabajadorDAO dao;

    @Override
    public void insert(TipoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TipoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoTrabajador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoTrabajador> findAll() {
        return dao.findAll();
    }
    
    @Override
    public List<TipoTrabajador> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    public void update(TipoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
