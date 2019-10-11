/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IActividadDAO;
import com.bruce.dao.to.Actividad;
import com.bruce.services.design.IActividadService;
import com.bruce.util.FilterPage;
import com.bruce.util.Metodo;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class ActividadService implements IActividadService {

    @Autowired
    private IActividadDAO dao;

    @Override
    @Transactional
    public void insert(Actividad t) {
        Actividad last = dao.lastByFilter(new ArrayList<>());
        int idLast = last != null ? last.getIdActividad() : 0;
        t.setIdActividad(idLast + 1);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Actividad t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Actividad t) {
        dao.delete(t);
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
            }
            if (query != null) {
                if (Metodo.isNumeric(query.trim())) {
                    filters.add(new FilterPage("like", "ID_ACTIVIDAD", query));
                } else {
                    filters.add(new FilterPage("like", "NOMBRE", "%" + query + "%"));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ActividadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Actividad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Actividad lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            }
            if (query != null) {
                if (Metodo.isNumeric(query.trim())) {
                    filters.add(new FilterPage("like", "ID_ACTIVIDAD", query));
                } else {
                    filters.add(new FilterPage("like", "NOMBRE", "%" + query + "%"));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ActividadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Actividad> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Actividad> getByFilter(int start, int limit, String sort, String filter, String query) {
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
            }
            if (query != null) {
                if (Metodo.isNumeric(query.trim())) {
                    filters.add(new FilterPage("like", "ID_ACTIVIDAD", query));
                } else {
                    filters.add(new FilterPage("like", "NOMBRE", "%" + query + "%"));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ActividadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

}
