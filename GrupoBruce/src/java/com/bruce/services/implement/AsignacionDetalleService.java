/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.IAsignacionDetalleDAO;
import com.bruce.dao.design.IEquipoInformaticoDAO;
import com.bruce.dao.to.AsignacionDetalle;
import com.bruce.dao.to.EquipoInformatico;
import com.bruce.services.design.IAsignacionDetalleService;
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
public class AsignacionDetalleService implements IAsignacionDetalleService {

    @Autowired
    private IAsignacionDetalleDAO dao;
    @Autowired
    private IEquipoInformaticoDAO dao2;

    @Override
    @Transactional
    public List<AsignacionDetalle> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", Metodo.isNumeric(query.trim()) ? "idAequipo" : "einformatico", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
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
                filters.add(new FilterPage("like", "einformatico", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(AsignacionDetalle t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("ID_AEQUIPO", t.getIdAequipo()));
        AsignacionDetalle last = dao.lastByFilter(filters);
        int idLast = last != null ? Integer.parseInt(last.getIdAdetalle().substring(4)) : 0;
        t.setIdAdetalle(t.getIdAequipo() + String.format("%04d", idLast + 1));
        t.setFecha(new Date());
        t.setAsignado(true);
        dao.create(t);

        EquipoInformatico equipo = dao2.get(t.getIdEinformatico());
        equipo.setIdEequipo(Constante.EQUIPO_ESTADO_ASIGNADO);
        dao2.update(equipo);
    }

    @Override
    @Transactional
    public void update(AsignacionDetalle t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(AsignacionDetalle t) {
        dao.delete(t);
        EquipoInformatico equipo = dao2.get(t.getIdEinformatico());
        equipo.setIdEequipo(Constante.EQUIPO_ESTADO_PORASIGNAR);
        dao2.update(equipo);
    }

    @Override
    @Transactional
    public AsignacionDetalle find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<AsignacionDetalle> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public boolean validaREquipoAsignacion(AsignacionDetalle asignacionDetalle) {
        return dao.validaREquipoAsignacion(asignacionDetalle);
    }

    @Override
    @Transactional
    public AsignacionDetalle lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "einformatico", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

}
