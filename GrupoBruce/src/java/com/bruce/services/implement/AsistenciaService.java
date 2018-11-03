/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.services.design.IAsistenciaService;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class AsistenciaService implements IAsistenciaService {

    @Autowired
    private IAsistenciaDAO dao;
    @Autowired
    private ITrabajadorDAO daoT;

    @Override
    @Transactional
    public List<Asistencia> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Asistencia lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Asistencia> insertList(List<Asistencia> list) {
        List<Asistencia> notFound = new ArrayList<>();
        list.forEach(item -> {
            if (daoT.find(item.getIdTrabajador()) != null) {
                insert(item);
            } else {
                notFound.add(item);
            }
        });
        return notFound;
    }

    @Override
    @Transactional
    public void insert(Asistencia t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("anio", t.getAnio()));
        filters.add(new FilterPage("mes", t.getMes()));
        filters.add(new FilterPage("dia", t.getDia()));
        Asistencia last = dao.lastByFilter(filters);

        int idLast = last != null ? Integer.parseInt(last.getIdAsistencia().substring(8)) : 0;
        String idAsistencia = String.valueOf(t.getAnio()) + String.format("%02d", t.getMes()) + String.format("%02d", t.getDia()) + String.format("%04d", idLast + 1);
        t.setIdAsistencia(idAsistencia);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Asistencia t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Asistencia t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Asistencia find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Asistencia> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
