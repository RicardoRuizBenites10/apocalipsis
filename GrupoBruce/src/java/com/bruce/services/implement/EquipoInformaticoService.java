/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.IAsignacionDetalleDAO;
import com.bruce.dao.design.IEquipoInformaticoDAO;
import com.bruce.dao.design.IMantenimientoDetalleDAO;
import com.bruce.dao.to.EquipoInformatico;
import com.bruce.services.design.IEquipoInformaticoService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.Metodo;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class EquipoInformaticoService implements IEquipoInformaticoService {

    @Autowired
    private IEquipoInformaticoDAO dao;
    @Autowired
    private IAsignacionDetalleDAO daoAD;
    @Autowired
    private IMantenimientoDetalleDAO daoMD;

    @Override
    @Transactional
    public List<EquipoInformatico> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "denominacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public List<EquipoInformatico> getByPorAsignar(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "denominacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        filters.add(new FilterPage("eq", "idEequipo", Constante.EQUIPO_ESTADO_PORASIGNAR));
        return dao.getByFilter(start, limit, filters);
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
                filters.add(new FilterPage("like", "denominacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EquipoInformatico lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(EquipoInformatico t) {
        EquipoInformatico last = dao.lastByFilter(null);
        int idLast = last != null ? Integer.parseInt(last.getIdEinformatico()) : 0;
        t.setIdEinformatico(String.format("%06d", idLast + 1));
        t.setFechaUpdate(new Date());
        t.setIdEequipo(Constante.EQUIPO_ESTADO_PORASIGNAR);
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(EquipoInformatico t) {
        t.setFechaUpdate(new Date());
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EquipoInformatico t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EquipoInformatico find(Object id) {
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<EquipoInformatico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public String getSerie(String tipo) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTequipo", tipo));
        EquipoInformatico last = dao.lastByFilter(filters);
        Calendar cal = Calendar.getInstance();
        String after, before;
        int idLast = last != null ? Integer.parseInt(last.getIdEinformatico()) : 0;
        after = String.format("%04d", idLast + 1);
        before = String.valueOf(cal.get(Calendar.YEAR)).substring(2) + String.format("%02d", cal.get(Calendar.MONTH) + 1);
        return before + tipo + after;
    }

    @Override
    @Transactional
    public Map<String, Object> validaRelacion(EquipoInformatico equipo) {
        List<FilterPage> filters = new ArrayList<>(), filtersMD = new ArrayList<>();
        filters.add(new FilterPage("idEinformatico", equipo.getIdEinformatico()));
        boolean validacion = false;
        String mensage = "No se puede eliminar ya que tiene registros relacionados";
        Map<String, Object> map = new HashMap<>();
        if (daoAD.lastByFilter(filters) == null && daoMD.lastByFilter(filters) == null) {
            mensage = "Equipo eliminado";
            validacion = true;
        }
        map.put("success", true);
        map.put("validacion", validacion);
        map.put("message", mensage);
        return map;
    }

}
