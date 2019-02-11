/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.design.ISituacionDAO;
import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.ContratoTrabajador;
import com.bruce.dao.to.Situacion;
import com.bruce.dao.to.Trabajador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruce.services.design.IContratoTrabajadorService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author RICARDO
 */
@Service
public class ContratoTrabajadorService implements IContratoTrabajadorService {

    @Autowired
    private IContratoTrabajadorDAO dao;
    @Autowired
    private ISituacionDAO dao2;
    @Autowired
    private ITrabajadorDAO dao3;

    @Override
    @Transactional
    public List<ContratoTrabajador> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "idTrabajador", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public void insert(ContratoTrabajador newContrato) {
        int idCLast = 0;
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTrabajador", newContrato.getIdTrabajador()));
        ContratoTrabajador lastContrato = dao.lastByFilter(filters);
        if (lastContrato != null) {
            idCLast = lastContrato.getIdContrato();
            if (lastContrato.getIdEcontrato() == Constante.CONTRATO_ESTADO_VIGENTE) {
                lastContrato.setIdEcontrato(Constante.CONTRATO_ESTADO_RENOVADO);
                dao.update(lastContrato);
            }
        }
        newContrato.setIdContrato(idCLast + 1);
        newContrato.setIdEcontrato(Constante.CONTRATO_ESTADO_VIGENTE);
        dao.create(newContrato);
        /*---actualizacion en situacion y trabajador----*/
        Situacion lastSituacion = dao2.lastByFilter(filters);
        Trabajador trabajador = dao3.get(newContrato.getIdTrabajador());
        int idSLast = lastSituacion != null ? lastSituacion.getIdSituacion() : 0;
        if (lastSituacion == null || (!lastSituacion.isActiva())) {
            dao2.create(new Situacion(newContrato.getIdTrabajador(), idSLast + 1, newContrato.getFechaInicio(), newContrato.getIdContrato(), true));
            trabajador.setUltimaAlta(newContrato.getFechaInicio());
        }
        trabajador.setHaberBasico(newContrato.getMontoContrato());
        dao3.update(trabajador);

    }

    @Override
    @Transactional
    public void update(ContratoTrabajador oldContrato) {
        dao.update(oldContrato);
    }

    @Override
    @Transactional
    public void delete(ContratoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ContratoTrabajador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<ContratoTrabajador> findAll() {
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
                filters.add(new FilterPage("like", "idTrabajador", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Map<String, Object> validaAdd(String idTrabajador) {
        Map<String, Object> map = new HashMap<>();

        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTrabajador", idTrabajador));
        ContratoTrabajador lastContrato = dao.lastByFilter(filters);
        boolean success = true;
        Date inicio = null;
        if (lastContrato != null) {
            success = lastContrato.getIdEcontrato() != Constante.CONTRATO_ESTADO_VIGENTE || (lastContrato.getIdEcontrato() == Constante.CONTRATO_ESTADO_VIGENTE && lastContrato.getFechaFin() != null);
            inicio = lastContrato.getFechaFin();
        }
        map.put("success", success);
        map.put("inicio", inicio);
        map.put("message", "Validación exitosa.");
        return map;
    }

    @Override
    @Transactional
    public ContratoTrabajador lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "idTrabajador", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void endContrato(ContratoTrabajador contrato) {
        List<FilterPage> filters = new ArrayList<>();
        Calendar cal = Calendar.getInstance(), cal2 = Calendar.getInstance();
        cal.setTime(contrato.getFechaFin());
        cal2.setTime(contrato.getFechaCese());
        contrato.setIdEcontrato(cal.compareTo(cal2) == 0 ? Constante.CONTRATO_ESTADO_TERMINADO : Constante.CONTRATO_ESTADO_CANCELADO);
        dao.update(contrato);

        Trabajador trabajador = dao3.get(contrato.getIdTrabajador());
        trabajador.setIdEtrabajador(Constante.TRABAJADOR_ESTADO_BAJA);
        dao3.update(trabajador);

        filters.add(new FilterPage("idTrabajador", contrato.getIdTrabajador()));
        filters.add(new FilterPage("activa", true));
        Situacion lastSituacion = dao2.lastByFilter(filters);
        lastSituacion.setFechaBaja(contrato.getFechaCese());
        lastSituacion.setContratoBaja(contrato.getIdContrato());
        lastSituacion.setActiva(false);
        dao2.update(lastSituacion);
    }

}
