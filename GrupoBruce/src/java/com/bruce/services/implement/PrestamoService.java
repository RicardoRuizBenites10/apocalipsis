/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IPrestamoDAO;
import com.bruce.dao.to.Prestamo;
import com.bruce.services.design.IPrestamoService;
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
public class PrestamoService implements IPrestamoService {

    @Autowired
    private IPrestamoDAO dao;

    @Override
    @Transactional
    public void insert(Prestamo t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("eq", "idTrabajador", t.getIdTrabajador()));
        Prestamo last = dao.lastByFilter(filters);
        int idLast = last != null ? Integer.parseInt(last.getIdPrestamo().substring(8)) : 0;
        t.setIdPrestamo(t.getIdTrabajador().trim() + String.format("%04d", idLast + 1));
        t.setPagado(false);
        t.setMpagado(0);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Prestamo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Prestamo t) {
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
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(PrestamoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Prestamo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Prestamo lastByFilter(String filter, String query) {
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
            Logger.getLogger(PrestamoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Prestamo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Prestamo> getByFilter(int start, int limit, String sort, String filter, String query) {
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
            Logger.getLogger(PrestamoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

}
