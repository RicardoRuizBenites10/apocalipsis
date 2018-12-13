/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.IMantenimientoDAO;
import com.bruce.dao.design.IMantenimientoProcesoDAO;
import com.bruce.dao.to.Mantenimiento;
import com.bruce.dao.to.MantenimientoProceso;
import com.bruce.services.design.IMantenimientoService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.Metodo;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class MantenimientoService implements IMantenimientoService {

    @Autowired
    private IMantenimientoDAO dao;
    @Autowired
    private IMantenimientoProcesoDAO daoProceso;

    @Override
    @Transactional
    public List<Mantenimiento> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", Metodo.isNumeric(query.trim()) ? "idMantenimiento" : "observacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit,null, filters);
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
                filters.add(new FilterPage("like", "observacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Mantenimiento lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "observacion", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Mantenimiento t) {
        Mantenimiento last = dao.lastByFilter(null);
        int idLast = last != null ? Integer.parseInt(last.getIdMantenimiento().substring(4)) : 0;
        t.setIdMantenimiento(t.getIdAequipo() + String.format("%04d", idLast + 1));
        t.setIdEmantenimiento(Constante.MANTENIMIENTO_ESTADO_REQUERIDO);
        t.setFecha(new Date());
        dao.create(t);
        
        MantenimientoProceso mp = new MantenimientoProceso();
        mp.setIdAequipo(t.getIdAequipo());
        mp.setIdMantenimiento(t.getIdMantenimiento());
        mp.setIdMproceso(t.getIdMantenimiento() + t.getIdEmantenimiento());
        mp.setFecha(new Date());
        mp.setObservacion(t.getObservacion());
        mp.setIdGenerador(t.getIdGenerador());
        mp.setIdEmantenimiento(Constante.MANTENIMIENTO_ESTADO_REQUERIDO);
        daoProceso.create(mp);
    }

    @Override
    @Transactional
    public void update(Mantenimiento t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Mantenimiento t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Mantenimiento find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<Mantenimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
