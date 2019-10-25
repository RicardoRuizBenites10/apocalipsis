/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEspecificacionDAO;
import com.bruce.dao.to.Especificacion;
import com.bruce.services.design.IEspecificacionService;
import com.bruce.util.FilterPage;
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
public class EspecificacionService implements IEspecificacionService{
    
    @Autowired
    private IEspecificacionDAO dao;
    
    @Override
    @Transactional
    public void insert(Especificacion t) {
        Especificacion last = dao.lastByFilter(new ArrayList<>());
        int idLast = last != null ? last.getIdEspecificacion() : 0;
        t.setIdEspecificacion(idLast + 1);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Especificacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Especificacion t) {
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
            } else if (query != null) {
                filters.add(new FilterPage("like", "descripcion", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Especificacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Especificacion lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "descripcion", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Especificacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Especificacion> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "descripcion", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public List<Especificacion> getByFilterSelects(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "descripcion", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilterSelects(start, limit, sorts, filters);
    }
    
}
