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
    public List<Asistencia> insertList(List<Asistencia> list) {
        List<Asistencia> notFound = new ArrayList<>();
        list.forEach(item -> {
            if (daoT.get(item.getIdTrabajador()) != null) {
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
        System.err.println("idLast: " + idLast);
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
