/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEspecificacionCategoriaDAO;
import com.bruce.dao.to.EspecificacionCategoria;
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
import com.bruce.services.design.IEspecificacionCategoriaService;

/**
 *
 * @author SISTEMAS
 */
@Service
public class EspecificacionCategoriaService implements IEspecificacionCategoriaService {

    @Autowired
    private IEspecificacionCategoriaDAO dao;

    @Override
    @Transactional
    public void insert(EspecificacionCategoria t) {
        EspecificacionCategoria last = dao.lastByFilter(null), sup = dao.get(t.getIdSupecategoria());
        int idLast = last != null ? Integer.parseInt(last.getIdEcategoria()) : 0;
        t.setIdEcategoria(String.format("%04d", idLast + 1));
        dao.create(t);
        if (sup != null) {
            sup.setLeaf(false);
            dao.update(sup);
        }
    }

    @Override
    @Transactional
    public void update(EspecificacionCategoria t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EspecificacionCategoria t) {
        List<FilterPage> filters = new ArrayList<>(), filters2 = new ArrayList<>();
        EspecificacionCategoria sup = dao.get(t.getIdSupecategoria());
        filters.add(new FilterPage("eq","idSupecategoria", t.getIdEcategoria()));
        filters2.add(new FilterPage("eq","idSupecategoria", t.getIdSupecategoria()));
        
        int childs = dao.countByFilter(filters);
        if (childs > 0) {
            throw new RuntimeException("La categoria no debe contener subcategoría.");
        } else {
            dao.delete(t);
            if (sup != null) {
                sup.setLeaf(dao.countByFilter(filters2) == 0);
                dao.update(sup);
            }
        }
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
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionCategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EspecificacionCategoria find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public EspecificacionCategoria lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionCategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<EspecificacionCategoria> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<EspecificacionCategoria> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(EspecificacionCategoriaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

}
