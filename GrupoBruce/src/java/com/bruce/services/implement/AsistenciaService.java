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
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
    public List<Asistencia> getByFilter(int start, int limit, String sort, String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<SortPage> sorts = new ArrayList<>();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (sort != null) {
                sorts = mapper.readValue(sort, new TypeReference<List<SortPage>>() {
                });
            }
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "nomUsu", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        Asistencia lastDay = dao.lastByFilter(filters);
        if(lastDay==null || !lastDay.isProcesado()){
            filters.get(0).setInWhere(false);
            filters.add(new FilterPage("EQ", "T.ID_ETRABAJADOR", true, true, true));
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public int countByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "nomUsu", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        Asistencia lastDay = dao.lastByFilter(filters);
        if(lastDay==null || !lastDay.isProcesado()){
            filters.get(0).setInWhere(false);
            filters.add(new FilterPage("EQ", "T.ID_ETRABAJADOR", true, true, true));
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Asistencia lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "nomUsu", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Asistencia t) {
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

    @Override
    @Transactional
    public void procesarAsistencia(List<Asistencia> asistencias) {
        if(!asistencias.isEmpty()){
            asistencias.forEach(item -> {
                if(!item.isAsistio()){
                    item.setMarca1("");
                    item.setMarca7("");
                }
                dao.update(item);
            });
        }
    }

}
