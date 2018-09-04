/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoDocumentoDAO;
import com.bruce.dao.to.TipoDocumento;
import com.bruce.services.design.ITipoDocumentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SISTEMAS
 */
@Service
public class TipoDocumentoService implements ITipoDocumentoService{
    
    @Autowired
    private ITipoDocumentoDAO dao;
    
    @Override
    public void create(TipoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(TipoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TipoDocumento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoDocumento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> findAll() {
        return dao.findAll();
    }
    
    @Override
    public List<TipoDocumento> findBySituacion(boolean situacion) {
        return dao.filterBySituacion(situacion);
    }
}
