/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoAusenciaDAO;
import com.bruce.dao.to.TipoAusencia;
import com.bruce.services.design.ITipoAusenciaService;
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
public class TipoAusenciaService implements ITipoAusenciaService{

    @Autowired
    private ITipoAusenciaDAO dao;
    
    @Override
    @Transactional
    public List<TipoAusencia> getBySituacion(boolean situacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("situacion", situacion));
        return dao.getByFilter(0, 100, null, filters);
    }

    @Override
    @Transactional
    public void insert(TipoAusencia t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(TipoAusencia t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(TipoAusencia t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public TipoAusencia find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<TipoAusencia> findAll() {
        return dao.getAll();
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
    public TipoAusencia lastByFilter(String filter, String query) {
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
    public List<TipoAusencia> getByFilter(int start, int limit, String sort, String filter, String query) {
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
    
}
