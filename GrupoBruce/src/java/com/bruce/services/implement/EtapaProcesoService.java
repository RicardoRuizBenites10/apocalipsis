/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEtapaProcesoDAO;
import com.bruce.dao.to.EtapaProceso;
import com.bruce.services.design.IEtapaProcesoService;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class EtapaProcesoService implements IEtapaProcesoService {

    @Autowired
    private IEtapaProcesoDAO dao;

    @Override
    @Transactional
    public void insert(EtapaProceso t) {
        EtapaProceso last = dao.lastByFilter(new ArrayList<>()), sup = dao.get(t.getIdSupeproceso());
        int idLast = last != null ? Integer.parseInt(last.getIdEproceso()) : 0;
        t.setIdEproceso(String.format("%04d", idLast + 1));
        dao.create(t);
        if(sup!=null){
            sup.setLeaf(false);
            dao.update(sup);
        }
    }

    @Override
    @Transactional
    public void update(EtapaProceso t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EtapaProceso t) {
        List<FilterPage> filters = new ArrayList<>(), filters2 = new ArrayList<>();
        EtapaProceso sup = dao.get(t.getIdSupeproceso());
        filters.add(new FilterPage("idSupeproceso", t.getIdEproceso()));
        filters2.add(new FilterPage("idSupeproceso", t.getIdSupeproceso()));
        int childs = dao.countByFilter(filters);
        if (childs > 0) {
            throw new RuntimeException("El menú no debe contener submenus.");
        } else {
            dao.delete(t);
            if (sup != null) {
                sup.setLeaf(dao.countByFilter(filters2)==0);
                dao.update(sup);
            }
        }
        dao.delete(t);
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
                filters.add(new FilterPage("like", "descripcion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(EtapaProcesoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EtapaProceso find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public EtapaProceso lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "descripcion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(EtapaProcesoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<EtapaProceso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<EtapaProceso> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "descripcion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(EtapaProcesoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

}
