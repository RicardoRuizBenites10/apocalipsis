/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IVacacionDAO;
import com.bruce.dao.to.Vacacion;
import com.bruce.services.design.IVacacionService;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class VacacionService implements IVacacionService{
    
    @Autowired
    private IVacacionDAO dao;
    
    @Override
    @Transactional
    public List<Vacacion> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public void insert(Vacacion currentVacacion) {
//        List<FilterPage> filters = new ArrayList<>();
//        filters.add(new FilterPage("idTrabajador",currentVacacion.getIdTrabajador()));
//        Vacacion last = last(filters);
//        int idLast = last == null ? 1 : last.getIdPVacacion() + 1;
//        currentVacacion.setIdPVacacion(idLast);
        dao.create(currentVacacion);
    }

    @Override
    @Transactional
    public void update(Vacacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Vacacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Vacacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Vacacion> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Vacacion last(List<FilterPage> filters) {
        return dao.last(filters);
    }
    
}
