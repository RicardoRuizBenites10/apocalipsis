/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IMaterialDAO;
import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.to.Material;
import com.bruce.dao.to.Sucursal;
import com.bruce.services.design.IMaterialService;
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
public class MaterialService implements IMaterialService{
    
    @Autowired
    private IMaterialDAO dao;
    @Autowired
    private ISucursalDAO dao2;
    
    @Override
    @Transactional
    public void insert(Material t) {
        Material last = dao.lastByFilter(new ArrayList<>());
        int idLast = last != null ? last.getIdMaterial() : 0 ;
        t.setIdMaterial(idLast + 1);
        dao.create(t);
        
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("eq", "idEmpresa", t.getIdEmpresa()));
        filters.add(new FilterPage("nin", "idSucursal", t.getIdSucursal()));
        List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
        
        sucursals.forEach(item -> {
            Material mat = new Material();
            mat.setIdEmpresa(item.getIdEmpresa());
            mat.setIdSucursal(item.getIdSucursal());
            mat.setIdMaterial(t.getIdMaterial());
            mat.setIdFamilia(t.getIdFamilia());
            mat.setIdSubfamilia(t.getIdSubfamilia());
            mat.setIdUsuario(t.getIdUsuario());
            mat.setNombre(t.getNombre());
            mat.setPrecio(t.getPrecio());
            mat.setStock(t.getStock());
            mat.setStockMinimo(t.getStockMinimo());
            mat.setStockMaximo(t.getStockMaximo());
            mat.setCantIngreso(t.getCantIngreso());
            mat.setCantSalida(t.getCantSalida());
            mat.setAutoparte(t.isAutoparte());
            mat.setSegCalidad(t.isSegCalidad());
            mat.setSituacion(t.isSituacion());
            dao.create(mat);
        });
    }

    @Override
    @Transactional
    public void update(Material t) {
        dao.update(t);
        
        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("eq", "idEmpresa", t.getIdEmpresa()));
        filters.add(new FilterPage("nin", "idSucursal", t.getIdSucursal()));
        List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
        sucursals.forEach(item -> {
            Material mat = new Material();
            mat.setIdEmpresa(item.getIdEmpresa());
            mat.setIdSucursal(item.getIdSucursal());
            mat.setIdMaterial(t.getIdMaterial());
            mat.setIdFamilia(t.getIdFamilia());
            mat.setIdSubfamilia(t.getIdSubfamilia());
            mat.setIdUsuario(t.getIdUsuario());
            mat.setNombre(t.getNombre());
            mat.setPrecio(t.getPrecio());
            mat.setStock(t.getStock());
            mat.setStockMinimo(t.getStockMinimo());
            mat.setStockMaximo(t.getStockMaximo());
            mat.setCantIngreso(t.getCantIngreso());
            mat.setCantSalida(t.getCantSalida());
            mat.setAutoparte(t.isAutoparte());
            mat.setSegCalidad(t.isSegCalidad());
            mat.setSituacion(t.isSituacion());
            dao.create(mat);
        });
    }

    @Override
    @Transactional
    public void delete(Material t) {
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
                filters.add(new FilterPage("like", "nombre", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(MaterialService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Material find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Material lastByFilter(String filter, String query) {
        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            if (filter != null) {
                filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
                });
            } else if (query != null) {
                filters.add(new FilterPage("like", "nombre", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(MaterialService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Material> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Material> getByFilter(int start, int limit, String sort, String filter, String query) {
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
            }
            if (query != null) {
                filters.add(new FilterPage("like", "nombre", "%" + query + "%"));
            }
        } catch (IOException ex) {
            Logger.getLogger(MaterialService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }
    
}
