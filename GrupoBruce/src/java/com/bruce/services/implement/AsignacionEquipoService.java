/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsignacionEquipoDAO;
import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.AsignacionEquipo;
import com.bruce.dao.to.Trabajador;
import com.bruce.services.design.IAsignacionEquipoService;
import com.bruce.util.FilterPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class AsignacionEquipoService implements IAsignacionEquipoService{
    
    @Autowired
    private IAsignacionEquipoDAO dao;
    @Autowired
    private ITrabajadorDAO dao2;

    @Override
    @Transactional
    public List<AsignacionEquipo> getByFilter(int start, int limit, List<FilterPage> filters) {
        List<AsignacionEquipo> list = dao.getByFilter(start, limit, filters);
        list.forEach(item -> {
            item.setRecepcionador((dao2.find(item.getIdRecepcionador())).getNombresCompletos());
        });
        return list;
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public AsignacionEquipo lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(AsignacionEquipo t) {
        AsignacionEquipo last = dao.lastByFilter(null);
        int idLast = last != null ? last.getIdAequipo() : 0;
        t.setIdAequipo(idLast + 1);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(AsignacionEquipo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(AsignacionEquipo t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public AsignacionEquipo find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<AsignacionEquipo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
