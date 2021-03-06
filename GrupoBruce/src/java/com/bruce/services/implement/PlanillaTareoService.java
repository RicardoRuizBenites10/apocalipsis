/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IPlanillaTareoDAO;
import com.bruce.dao.to.PlanillaTareo;
import com.bruce.services.design.IPlanillaTareoService;
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
public class PlanillaTareoService implements IPlanillaTareoService {

    @Autowired
    private IPlanillaTareoDAO dao;

    @Override
    @Transactional
    public void procesarPTareo(List<PlanillaTareo> planillasTareo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void insert(PlanillaTareo t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(PlanillaTareo t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(PlanillaTareo t) {
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
            Logger.getLogger(PlanillaTareoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cc = dao.countByFilter(filters);
        cc = cc == 0 ? dao.countByCFilter(filters) : cc;
        return cc;
    }

    @Override
    @Transactional
    public PlanillaTareo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public PlanillaTareo lastByFilter(String filter, String query) {
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
            Logger.getLogger(PlanillaTareoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<PlanillaTareo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<PlanillaTareo> getByFilter(int start, int limit, String sort, String filter, String query) {
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
            Logger.getLogger(PlanillaTareoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cc = dao.countByFilter(filters);
        return cc == 0 ? dao.getByCFilter(start, limit, sorts, filters) : dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public void aprobarPTareo(List<PlanillaTareo> planillasTareo) {
        if (planillasTareo.size() > 0) {
            planillasTareo.forEach(item -> {
                dao.update(item);
            });
        }
    }

}
