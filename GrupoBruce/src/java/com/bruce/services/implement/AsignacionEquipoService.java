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
public class AsignacionEquipoService implements IAsignacionEquipoService{
    
    @Autowired
    private IAsignacionEquipoDAO dao;
    @Autowired
    private IAsignacionDetalleDAO daoAD;
    @Autowired
    private IMantenimientoDAO daoM;

    @Override
    @Transactional
    public List<AsignacionEquipo> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public AsignacionEquipo lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(AsignacionEquipo t) {
        AsignacionEquipo last = dao.lastByFilter(null);
        int idLast = last != null ? Integer.parseInt(last.getIdAequipo()) : 0;
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
        return dao.find(id);
    }

    @Override
    @Transactional
    public List<AsignacionEquipo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Map<String, Object> validaRelacion(AsignacionEquipo asignacion) {
        List<FilterPage> filters = new ArrayList<>(), filtersMD = new ArrayList<>();
        filters.add(new FilterPage("idAequipo", asignacion.getIdAequipo()));
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
