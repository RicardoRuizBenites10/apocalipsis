/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsignacionDetalleDAO;
import com.bruce.dao.design.IAsignacionEquipoDAO;
import com.bruce.dao.design.IMantenimientoDAO;
import com.bruce.dao.to.AsignacionEquipo;
import com.bruce.services.design.IAsignacionEquipoService;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class AsignacionEquipoService implements IAsignacionEquipoService {

    @Autowired
    private IAsignacionEquipoDAO dao;
    @Autowired
    private IAsignacionDetalleDAO daoAD;
    @Autowired
    private IMantenimientoDAO daoM;

    @Override
    @Transactional
    public List<AsignacionEquipo> getByFilter(int start, int limit, String sort, String filter, String query) {
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
    public AsignacionEquipo lastByFilter(String filter, String query) {
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
    public void insert(AsignacionEquipo t) {
        AsignacionEquipo last = dao.lastByFilter(new ArrayList<>());
        int idLast = last != null ? Integer.parseInt(last.getIdAequipo()) : 0;
        t.setEstado(true);
        t.setIdAequipo(String.format("%04d", idLast + 1));
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(AsignacionEquipo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(AsignacionEquipo t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public AsignacionEquipo find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<AsignacionEquipo> findAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public Map<String, Object> validaRelacion(AsignacionEquipo asignacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("ID_AEQUIPO", asignacion.getIdAequipo()));
        boolean validacion = false;
        String mensage = "No se puede eliminar ya que tiene registros relacionados";
        Map<String, Object> map = new HashMap<>();
        if (daoAD.lastByFilter(filters) == null && daoM.lastByFilter(filters) == null) {
            mensage = "Asignacion eliminado";
            validacion = true;
        }
        map.put("success", true);
        map.put("validacion", validacion);
        map.put("message", mensage);
        return map;
    }
}
