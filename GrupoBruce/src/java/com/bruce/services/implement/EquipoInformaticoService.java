/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEquipoInformaticoDAO;
import com.bruce.dao.to.EquipoInformatico;
import com.bruce.services.design.IEquipoInformaticoService;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class EquipoInformaticoService implements IEquipoInformaticoService {

    @Autowired
    private IEquipoInformaticoDAO dao;

    @Override
    @Transactional
    public List<EquipoInformatico> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EquipoInformatico lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(EquipoInformatico t) {
        EquipoInformatico last = dao.lastByFilter(null);
        int idLast = last != null ? Integer.parseInt(last.getIdEinformatico()) : 0;
        t.setIdEinformatico(String.format("%06d", idLast + 1));
        t.setFechaCreate(new Date());
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(EquipoInformatico t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EquipoInformatico t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EquipoInformatico find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<EquipoInformatico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public String getSerie(String tipo) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTequipo", tipo));
        EquipoInformatico last = dao.lastByFilter(filters);
        Calendar cal = Calendar.getInstance();
        String after, before;
        int idLast = last != null ? Integer.parseInt(last.getIdEinformatico()) : 0;
        after = String.format("%04d", idLast + 1);
        before = String.valueOf(cal.get(Calendar.YEAR)).substring(2) + String.format("%02d", cal.get(Calendar.MONTH) + 1);
        return before + after;
    }

}
