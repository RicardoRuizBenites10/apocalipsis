/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEstadoTrabajadorDAO;
import com.bruce.dao.to.EstadoTrabajador;
import com.bruce.services.design.IEstadoTrabajadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RICARDO
 */
@Service
public class EstadoTrabajadorService implements IEstadoTrabajadorService {
    
    @Autowired
    private IEstadoTrabajadorDAO dao;

    @Override
    public void insert(EstadoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EstadoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoTrabajador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstadoTrabajador> findAll() {
        return dao.findAll();
    }

    @Override
    public List<EstadoTrabajador> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }

    @Override
    public void update(EstadoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
