/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.services.design.IAsistenciaService;
import com.bruce.util.FilterPage;
import java.text.SimpleDateFormat;
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
public class AsistenciaService implements IAsistenciaService {
    
    @Autowired
    private IAsistenciaDAO dao;
    
    @Override
    @Transactional
    public List<Asistencia> getByFilter(int start, int limit, List<FilterPage> filters) {
        return dao.getByFilter(start, limit, filters);
    }
    
    @Override
    @Transactional
    public int countByFilter(List<FilterPage> filters) {
        return dao.countByFilter(filters);
    }
    
    @Override
    @Transactional
    public Asistencia lastByFilter(List<FilterPage> filters) {
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Asistencia> insertList(List<Asistencia> list) {
        list.forEach(item -> {
            insert(item);
        });
        return list;
    }
    
    @Override
    @Transactional
    public void insert(Asistencia t) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        String prefix = formatoFecha.format(new Date()).replace("/", "");
        
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("anio", Integer.parseInt(prefix.substring(0, 4))));
        filters.add(new FilterPage("mes", Integer.parseInt(prefix.substring(4, 6))));
        filters.add(new FilterPage("dia", Integer.parseInt(prefix.substring(6, 8))));
        Asistencia last = dao.lastByFilter(filters);
        
        int idLast = last != null ? Integer.parseInt(last.getIdAsistencia().substring(8)) : 0;
        t.setIdAsistencia(prefix + String.format("%04d", idLast + 1));
        
        dao.create(t);
    }
    
    @Override
    @Transactional
    public void update(Asistencia t) {
        dao.update(t);
    }
    
    @Override
    @Transactional
    public void delete(Asistencia t) {
        dao.delete(t);
    }
    
    @Override
    @Transactional
    public Asistencia find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Transactional
    public List<Asistencia> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
