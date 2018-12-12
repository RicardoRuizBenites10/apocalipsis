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
import java.util.ArrayList;
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
    public List<ContratoTrabajador> findByTrabajador(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, null, filters);
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
        trabajador.setMontoBase(newContrato.getMontoContrato());
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
    public int totalCount(List<FilterPage> filters) {
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

}
