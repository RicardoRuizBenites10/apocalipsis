/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import com.bruce.services.design.ITrabajadorService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.Metodo;
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
public class TrabajadorService implements ITrabajadorService {

    @Autowired
    private ITrabajadorDAO dao;

    @Override
    @Transactional
    public void insert(Trabajador newTrabajador) {
        newTrabajador.setIdEtrabajador(Constante.TRABAJADOR_ESTADO_ACTIVO);
        dao.create(newTrabajador);
    }

    @Override
    @Transactional
    public void delete(Trabajador t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Trabajador find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<Trabajador> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public List<Trabajador> findPagination(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", Metodo.isNumeric(query) ? "idTrabajador" : "nombres", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getTrabajadorsPagination(start, limit, sorts, filters);
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
                filters.add(new FilterPage("like", "nombres", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public void update(Trabajador t) {
        dao.update(t);
    }
}
