/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.IEstadoMantenimientoDAO;
import com.bruce.dao.design.IMantenimientoDAO;
import com.bruce.dao.design.IMantenimientoProcesoDAO;
import com.bruce.dao.to.EstadoMantenimiento;
import com.bruce.dao.to.Mantenimiento;
import com.bruce.dao.to.MantenimientoId;
import com.bruce.dao.to.MantenimientoProceso;
import com.bruce.util.FilterPage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bruce.services.design.IMantenimientoProcesoService;
import com.bruce.util.Metodo;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RICARDO
 */
@Service
public class MantenimientoProcesoService implements IMantenimientoProcesoService {

    @Autowired
    private IEstadoMantenimientoDAO dao3;
    @Autowired
    private IMantenimientoDAO dao2;
    @Autowired
    private IMantenimientoProcesoDAO dao;

    @Override
    @Transactional
    public List<MantenimientoProceso> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", Metodo.isNumeric(query.trim()) ? "idEmantenimiento" : "descripcion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, null, filters);
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
                filters.add(new FilterPage("like", "descripcion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public MantenimientoProceso lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "descripcion", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(MantenimientoProceso t) {
        t.setIdMproceso(t.getIdMantenimiento() + t.getIdEmantenimiento());
        dao.create(t);
        /*Actualiza mantenimiento*/
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("ID_ESTADO", t.getIdEmantenimiento()));
        EstadoMantenimiento estado = dao3.lastByFilter(filters);
        Mantenimiento mantenimiento = dao2.get(new MantenimientoId(t.getIdAequipo(), t.getIdMantenimiento()));
        mantenimiento.setIdEmantenimiento(t.getIdEmantenimiento());
        if (estado.isUltimo()) {
            mantenimiento.setFechaAtendido(new Date());
        }
        dao2.update(mantenimiento);
    }

    @Override
    @Transactional
    public void update(MantenimientoProceso t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(MantenimientoProceso t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public MantenimientoProceso find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<MantenimientoProceso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
