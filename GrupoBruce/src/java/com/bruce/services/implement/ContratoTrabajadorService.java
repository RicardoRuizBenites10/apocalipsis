/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IContratoTrabajadorDAO;
import com.bruce.dao.to.ContratoTrabajador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruce.services.design.IContratoTrabajadorService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
@Service
public class ContratoTrabajadorService implements IContratoTrabajadorService {

    @Autowired
    private IContratoTrabajadorDAO dao;

    @Override
    public List<ContratoTrabajador> findByTrabajador(int start, int limit, List<FilterPage> filters) {
        return dao.filterByTrabajador(start, limit, filters);
    }

    @Override
    public void insert(ContratoTrabajador newContrato) {
        dao.create(newContrato);
    }

    @Override
    public void update(ContratoTrabajador oldContrato) {
        dao.update(oldContrato);
    }

    @Override
    public void delete(ContratoTrabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ContratoTrabajador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContratoTrabajador> findAll() {
        return dao.findAll();
    }

    @Override
    public int totalCount(List<FilterPage> filters) {
        return dao.getCountContratos(filters);
    }

    @Override
    public Map<String, Object> last(String idTrabajador) {
        Map<String, Object> map = new HashMap<>();
        ContratoTrabajador lastContrato = dao.filterLastContrato(idTrabajador);
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
