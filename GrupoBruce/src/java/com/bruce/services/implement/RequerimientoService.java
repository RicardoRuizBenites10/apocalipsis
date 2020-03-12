/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IRequerimientoDAO;
import com.bruce.dao.to.Requerimiento;
import com.bruce.services.design.IRequerimientoService;
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
public class RequerimientoService implements IRequerimientoService {
    
    @Autowired
    private IRequerimientoDAO dao;
    
    @Override
    @Transactional
    public void insert(Requerimiento t) {
        dao.create(t);
    }
    
    @Override
    @Transactional
    public void update(Requerimiento t) {
        dao.update(t);
    }
    
    @Override
    @Transactional
    public void delete(Requerimiento t) {
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
                filters.add(new FilterPage("like", "actividad", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(RequerimientoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }
    
    @Override
    @Transactional
    public Requerimiento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional
    public Requerimiento lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "actividad", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(RequerimientoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }
    
    @Override
    @Transactional
    public List<Requerimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional
    public List<Requerimiento> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "actividad", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(RequerimientoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }
    
    @Override
    @Transactional
    public void changeLRequerimiento(List<Requerimiento> rr) {
        if (!rr.isEmpty()) {
            rr.forEach(item -> {
                Requerimiento last = dao.lastByFilter(new ArrayList<>());
                int idLast = last != null ? last.getIdRequerimiento() : 0;
                item.setIdRequerimiento(idLast + 1);
                dao.create(item);
            });
        }
    }
    
    @Override
    @Transactional
    public void deleteLRequerimiento(List<Requerimiento> rr) {
        rr.forEach(item -> {
            dao.delete(item);
        });
    }
    
}
