/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.IMenuDAO;
import com.bruce.dao.to.Menu;
import org.springframework.stereotype.Service;
import com.bruce.services.design.IMenuService;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SISTEMAS
 */
@Service
public class MenuService implements IMenuService{
    
    @Autowired
    private IMenuDAO dao;
    
    @Override
    @Transactional
    public List<Menu> getByFilter(int start, int limit, String sort, String filter, String query) {
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
                filters.add(new FilterPage("like", "denominacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, null,  filters);
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
                filters.add(new FilterPage("like", "denominacion", "%" + query));
            }
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Menu lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "denominacion", "%" + query));
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public void insert(Menu t) {
        Menu last = dao.lastByFilter(null), sup = dao.get(t.getIdSupmenu());
        int idLast = last == null ? 0 : Integer.parseInt(last.getIdMenu());
        t.setIdMenu(String.format("%04d", idLast + 1));
        dao.create(t);
        if (sup != null) {
            sup.setLeaf(false);
            dao.update(sup);
        }
    }

    @Override
    @Transactional
    public void update(Menu t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Menu t) {
        List<FilterPage> filters = new ArrayList<>(), filters2 = new ArrayList<>();
        Menu sup = dao.get(t.getIdSupmenu());
        filters.add(new FilterPage("idSupmenu", t.getIdMenu()));
        filters2.add(new FilterPage("idSupmenu", t.getIdSupmenu()));
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
    }

    @Override
    @Transactional
    public Menu find(Object id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return dao.getAll();
    }
    
}
