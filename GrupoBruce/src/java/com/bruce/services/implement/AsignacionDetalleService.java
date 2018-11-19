/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsignacionDetalleDAO;
import com.bruce.dao.design.IEquipoInformaticoDAO;
import com.bruce.dao.to.AsignacionDetalle;
import com.bruce.dao.to.EquipoInformatico;
import com.bruce.services.design.IAsignacionDetalleService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public List<AsignacionDetalle> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }

    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public AsignacionDetalle lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(AsignacionDetalle t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idAequipo", t.getIdAequipo()));
        AsignacionDetalle last = lastByFilter(filters);
        int idLast = last != null ? Integer.parseInt(last.getIdAdetalle().substring(4)) : 0;
        System.out.println("Ptmr: " + t.getIdAequipo() + String.format("%04d", idLast + 1));
        t.setIdAdetalle(t.getIdAequipo() + String.format("%04d", idLast + 1));
        t.setFecha(new Date());
        t.setAsignado(true);
        dao.create(t);
        
        EquipoInformatico equipo = dao2.find(t.getIdEinformatico());
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
        EquipoInformatico equipo = dao2.find(t.getIdEinformatico());
        equipo.setIdEequipo(Constante.EQUIPO_ESTADO_PORASIGNAR);
        dao2.update(equipo);
    }

    @Override
    @Transactional
    public AsignacionDetalle find(Object id) {
        return dao.find(id);
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

}
