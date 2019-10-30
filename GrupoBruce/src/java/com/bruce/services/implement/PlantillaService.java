/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IPlantillaDAO;
import com.bruce.dao.to.Plantilla;
import com.bruce.services.design.IPlantillaService;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class PlantillaService implements IPlantillaService {

    @Autowired
    private IPlantillaDAO dao;

    @Override
    @Transactional
    public void insert(Plantilla t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Plantilla t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Plantilla t) {
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
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(PlantillaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Plantilla find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Plantilla lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(PlantillaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Plantilla> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Plantilla> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "nombre", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(PlantillaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public void changeLPlantilla(List<Plantilla> plantillas, String categorias, String idCarroceria, String idUsuario) {
        List<FilterPage> filters = new ArrayList<>();
        String especificaciones = "";
        filters.add(new FilterPage("eq", "ID_CARROCERIA", idCarroceria));
        if (categorias != null && !categorias.trim().equals("")) {
            filters.add(new FilterPage("in", "EC.ID_ECATEGORIA", categorias));
        }
        if (!plantillas.isEmpty()) {
            for (Plantilla item : plantillas) {
                especificaciones = especificaciones + "," + item.getIdEspecificacion();
                dao.create(item);
            }
            especificaciones = especificaciones.substring(1);
        }
        filters.add(new FilterPage("nin", "ID_ESPECIFICACION", especificaciones));
        List<Plantilla> actuales = dao.getByFilter(0, 0, new ArrayList<>(), filters);
        if (!actuales.isEmpty()) {
            actuales.forEach(item -> {
                item.setAsignado(false);
                item.setFechaUpdate(new Date());
                item.setUsuUpdate(idUsuario);
                dao.update(item);
            });
        }
    }

}
