/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IConceptoAsignadoDAO;
import com.bruce.dao.to.ConceptoAsignado;
import com.bruce.services.design.IConceptoAsignadoService;
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
 * @author RICARDO
 */
@Service
public class ConceptoAsignadoService implements IConceptoAsignadoService {
    
    @Autowired
    private IConceptoAsignadoDAO dao;
    
    @Override
    @Transactional
    public void insert(ConceptoAsignado t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("EQ", "ID_TTRABAJADOR", t.getIdTtrabajador()));
        filters.add(new FilterPage("EQ", "ID_TPLANILLA", t.getIdTplanilla()));
        ConceptoAsignado last = dao.lastByFilter(filters);
        int ordenLast = last != null ? last.getOrden() : 0;
        t.setOrden(ordenLast + 1);
        dao.create(t);
    }
    
    @Override
    @Transactional
    public void update(ConceptoAsignado t) {
        dao.update(t);
    }
    
    @Override
    @Transactional
    public void delete(ConceptoAsignado t) {
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
                filters.add(new FilterPage("like", "idCasignado", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(ConceptoAsignadoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }
    
    @Override
    @Transactional
    public ConceptoAsignado find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional
    public ConceptoAsignado lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "idCasignado", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(ConceptoAsignadoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }
    
    @Override
    @Transactional
    public List<ConceptoAsignado> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional
    public List<ConceptoAsignado> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "idCasignado", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(ConceptoAsignadoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }
    
}
