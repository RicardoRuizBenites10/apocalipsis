/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IColorFormulaDAO;
import com.bruce.dao.to.ColorFormula;
import com.bruce.services.design.IColorFormulaService;
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
public class ColorFormulaService implements IColorFormulaService {

    @Autowired
    private IColorFormulaDAO dao;

    @Override
    @Transactional
    public void insert(ColorFormula t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(ColorFormula t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(ColorFormula t) {
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
                filters.add(new FilterPage("like", "-MATERIAL", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ChasisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public ColorFormula find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ColorFormula lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "-MATERIAL", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ChasisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<ColorFormula> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<ColorFormula> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "-MATERIAL", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ChasisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public void changeLColorFormula(List<ColorFormula> cf) {
        cf.forEach(item -> {
            dao.update(item);
        });
    }

    @Override
    @Transactional
    public void deleteLColorFormula(List<ColorFormula> cf) {
        cf.forEach(item -> {
            dao.delete(item);
        });
    }

}
