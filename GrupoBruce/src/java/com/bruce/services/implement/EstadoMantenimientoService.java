/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IEstadoMantenimientoDAO;
import com.bruce.dao.design.IMenuDAO;
import com.bruce.dao.to.EstadoMantenimiento;
import com.bruce.dao.to.Menu;
import com.bruce.services.design.IEstadoMantenimientoService;
import com.bruce.services.design.IMenuService;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class EstadoMantenimientoService implements IEstadoMantenimientoService {

    @Autowired
    private IEstadoMantenimientoDAO dao;
    @Autowired
    private IMenuDAO daoMenu;
    @Autowired
    private IMenuService servMenu;

    @Override
    @Transactional
    public List<EstadoMantenimiento> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "DESCRIPCION", "%" + query));
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
                filters.add(new FilterPage("like", "DESCRIPCION", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public EstadoMantenimiento lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "DESCRIPCION", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(EstadoMantenimiento t) {
        EstadoMantenimiento last = dao.lastByFilter(new ArrayList<>());
        int idLast = last != null ? Integer.parseInt(last.getIdEstado()) : 0;
        t.setIdEstado(String.format("%03d", idLast + 1));
        t.setSituacion(true);
        dao.create(t);
        /*Referente al menu*/
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("codProceso", t.getIdProceso()));
        filters.add(new FilterPage("codEtapa", ""));
        Menu parent = daoMenu.lastByFilter(filters), submenu;
        if (parent != null) {
            submenu = new Menu();
            submenu.setIconCls("x-fa fa-cog");
            submenu.setText(t.getDescripcion());
            submenu.setHandler("GrupoBruce.view.mantenimientoproceso.MantenimientoProceso");
            submenu.setIdSupmenu(parent.getIdMenu());
            submenu.setCodProceso(t.getIdProceso());
            submenu.setCodEtapa(t.getIdEstado());
            submenu.setLeaf(true);
            servMenu.insert(submenu);
            
            parent.setLeaf(false);
            servMenu.update(parent);
        }
    }

    @Override
    @Transactional
    public void update(EstadoMantenimiento t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(EstadoMantenimiento t) {
        dao.delete(t);
    }

    @Override
    @Transactional
    public EstadoMantenimiento find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<EstadoMantenimiento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
