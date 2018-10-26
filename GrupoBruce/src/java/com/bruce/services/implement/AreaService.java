/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAreaDAO;
import com.bruce.dao.to.Area;
import com.bruce.services.design.IAreaService;
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
public class AreaService implements IAreaService {

    @Autowired
    private IAreaDAO dao;

    @Override
    @Transactional
    public List<Area> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Area lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Area t) {
        Area last = dao.lastByFilter(null), sup = dao.find(t.getIdSuparea());
        int idLast = last != null ? Integer.parseInt(last.getIdArea()) : 0;
        t.setIdArea(String.format("%05d", idLast + 1));
        if (sup != null) {
            sup.setLeaf(false);
            dao.update(sup);
        }
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Area t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Area t) {
        List<FilterPage> filters = new ArrayList<>(), filters2 = new ArrayList<>();
        Area sup = dao.find(t.getIdSuparea());
        filters.add(new FilterPage("idSuparea", t.getIdArea()));
        filters2.add(new FilterPage("idSuparea", t.getIdSuparea()));
        int childs = dao.countByFilter(filters);
        if (childs > 0) {
            throw new RuntimeException("El área no debe contener subareas.");
        } else {
            dao.delete(t);
            if (sup != null) {
                sup.setLeaf(dao.countByFilter(filters2)==0);
                dao.update(sup);
            }
        }
    }

    @Override
    @Transactional
    public Area find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<Area> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
