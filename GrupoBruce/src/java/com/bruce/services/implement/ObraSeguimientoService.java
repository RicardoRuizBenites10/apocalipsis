/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IObraSeguimientoDAO;
import com.bruce.dao.to.ObraSeguimiento;
import com.bruce.services.design.IObraSeguimientoService;
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
public class ObraSeguimientoService implements IObraSeguimientoService{
    
    @Autowired
    private IObraSeguimientoDAO dao;
    
    @Override
    @Transactional
    public void insert(ObraSeguimiento t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(ObraSeguimiento t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(ObraSeguimiento t) {
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
                filters.add(new FilterPage("like", "EP.DESCRIPCION", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(ObraSeguimientoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public ObraSeguimiento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ObraSeguimiento lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "EP.DESCRIPCION", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(ObraSeguimientoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<ObraSeguimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<ObraSeguimiento> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "EP.DESCRIPCION", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(ObraSeguimientoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public void changeLObraSeguimiento(List<ObraSeguimiento> os) {
        os.forEach(item -> {
            dao.update(item);
        });
    }

    @Override
    @Transactional
    public void deleteLObraSeguimiento(List<ObraSeguimiento> os) {
        os.forEach(item -> {
            dao.delete(item);
        });
    }
    
}
