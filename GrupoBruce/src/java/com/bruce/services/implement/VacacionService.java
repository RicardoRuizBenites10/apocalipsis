/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.ITipoVacacionDAO;
import com.bruce.dao.design.IVacacionDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.dao.to.TipoVacacion;
import com.bruce.dao.to.Vacacion;
import com.bruce.services.design.IAsistenciaService;
import com.bruce.services.design.IVacacionService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class VacacionService implements IVacacionService {

    @Autowired
    private IVacacionDAO dao;
    @Autowired
    private ITipoVacacionDAO daoTV;
    @Autowired
    private IAsistenciaService serv;

    @Override
    @Transactional
    public List<Vacacion> getByFilter(int start, int limit, String sort, String filter, String query) {
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
    public void insert(Vacacion currentVacacion) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("ID_TRABAJADOR", currentVacacion.getIdTrabajador()));
        filters.add(new FilterPage("ID_PVACACION", currentVacacion.getIdPVacacion()));
        Vacacion last = dao.lastByFilter(filters);
        int idLast = last == null ? 0 : Integer.parseInt(last.getIdVacacion().substring(4));
        currentVacacion.setIdVacacion(String.valueOf(currentVacacion.getIdPVacacion()) + String.valueOf(idLast + 1));
        dao.create(currentVacacion);
        /*Registrar ausencia en asistencia*/
        List<FilterPage> filter = new ArrayList<>();
        filter.add(new FilterPage("eq", "idTVacacion", currentVacacion.getIdTVacacion()));
        TipoVacacion tv = daoTV.lastByFilter(filter);
        if (tv.isAusencia()) {
            Date fechaTemp;
            Calendar cal = Calendar.getInstance(), cal2 = Calendar.getInstance();
            cal.setTime(currentVacacion.getFechaSalida());
            cal2.setTime(currentVacacion.getFechaRetorno());
            do {
                fechaTemp = cal.getTime();
                serv.insert(new Asistencia(currentVacacion.getIdTrabajador(), fechaTemp, "", "", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE), Constante.ASISTENCIA_AUSENCIA_VACACION));
                cal.add(Calendar.DATE, +1);
            } while (cal.before(cal2));
        }
    }

    @Override
    @Transactional
    public void update(Vacacion t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Vacacion t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Vacacion find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Vacacion> findAll() {
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
                filters.add(new FilterPage("like", "nomUsu", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Vacacion lastByFilter(String filter, String query) {
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

}
