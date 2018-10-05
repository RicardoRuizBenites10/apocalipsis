/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.to.ContratoTrabajador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruce.services.design.IContratoTrabajadorService;
import com.bruce.util.FilterPage;

/**
 *
 * @author RICARDO
 */
@Service
public class ContratoTrabajadorService implements IContratoTrabajadorService {
    
    @Autowired
    private IContratoTrabajadorDAO dao;

    @Override
    public List<ContratoTrabajador> findByTrabajador(int start, int limit, List<FilterPage> filters) {
        return dao.filterByTrabajador(start,limit,filters);
    }

    @Override
    public void insert(ContratoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ContratoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ContratoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContratoTrabajador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContratoTrabajador> findAll() {
        return dao.findAll();
    }

    @Override
    public int totalCount(List<FilterPage> filters) {
        return dao.getCountContratos(filters);
    }


}
