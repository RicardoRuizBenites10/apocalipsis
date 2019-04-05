/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.design.IAusenciaDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.dao.to.Ausencia;
import com.bruce.services.design.IAsistenciaService;
import com.bruce.services.design.IAusenciaService;
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
 * @author RICARDO
 */
@Service
public class AusenciaService implements IAusenciaService {

    @Autowired
    private IAusenciaDAO dao;
    @Autowired
    private IAsistenciaDAO daoA;
    @Autowired
    private IAsistenciaService serv;

    @Override
    @Transactional
    public List<Ausencia> getByFilter(int start, int limit, String sort, String filter, String query) {
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
    public Ausencia lastByFilter(String filter, String query) {
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

    @Override
    @Transactional
    public void insert(Ausencia t) {
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("idTrabajador", t.getIdTrabajador()));
        Ausencia last = dao.lastByFilter(filters);
        int idLast = last != null ? last.getIdAusencia() : 0;
        t.setIdAusencia(idLast + 1);
        t.setFecha(new Date());
        if (t.getIdTmausencia() == Constante.AUSENCIA_TIEMPO_HORAS) {
            t.setFechaFin(t.getFechaInicio());
        }
        dao.create(t);
        /*Registro en asistencia*/
        Date fechaTemp;
        Asistencia asistencia;
        Calendar cal = Calendar.getInstance(), cal2 = Calendar.getInstance();
        cal.setTime(t.getFechaInicio());
        cal2.setTime(t.getFechaFin());
        List<FilterPage> filtersA = new ArrayList<>();
        do {
            fechaTemp = cal.getTime();
            filtersA.clear();
            filtersA.add(new FilterPage("ID_TRABAJADOR", t.getIdTrabajador()));
            filtersA.add(new FilterPage("FECHA", fechaTemp));
            asistencia = daoA.lastByFilter(filtersA);
            if(asistencia!=null){
                asistencia.setAusencia(Constante.ASISTENCIA_AUSENCIA_PERMISO);
                dao.update(t);
            }else{
                serv.insert(new Asistencia(t.getIdTrabajador(), fechaTemp, "", "", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE), Constante.ASISTENCIA_AUSENCIA_PERMISO, false));
            }
            cal.add(Calendar.DATE, +1);
        } while (cal.before(cal2));

    }

    @Override
    @Transactional
    public void update(Ausencia t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Ausencia t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public Ausencia find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Ausencia> findAll() {
        return dao.getAll();
    }

}
