/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IHijoDAO;
import com.bruce.dao.to.Hijo;
import com.bruce.services.design.IHijoService;
import com.bruce.util.FilterPage;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class HijoService implements IHijoService {

    @Autowired
    private IHijoDAO dao;

    @Override
    @Transactional
    public List<Hijo> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.filterByPadre(start, limit, filters);
    }

    @Override
    @Transactional
    public int countFilter(List<FilterPage> filters) {
        return dao.countHijos(filters);
    }

    @Override
    @Transactional
    public Map<String, Object> last(String idTrabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void insert(Hijo currentHijo) {
        Hijo lastHijo = dao.lastHijo(currentHijo.getIdTrabajador());
        int idLast = 0;
        if (lastHijo != null) {
            idLast = lastHijo.getIdHijo();
        }
        currentHijo.setIdHijo(idLast + 1);
        dao.create(currentHijo);
    }

    @Override
    @Transactional
    public void update(Hijo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Hijo t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Hijo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Hijo> findAll() {
        return dao.findAll();
    }

}
