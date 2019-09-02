/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.dao.design.IMaterialUnidadDAO;
import com.bruce.dao.design.ISucursalDAO;
import com.bruce.dao.to.MaterialUnidad;
import com.bruce.dao.to.Sucursal;
import com.bruce.services.design.IMaterialUnidadService;
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
public class MaterialUnidadService implements IMaterialUnidadService {

    @Autowired
    private IMaterialUnidadDAO dao;
    @Autowired
    private ISucursalDAO dao2;

    @Override
    @Transactional
    public void insert(MaterialUnidad t) {
        dao.create(t);

        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("eq", "idEmpresa", t.getIdEmpresa()));
        filters.add(new FilterPage("nin", "idSucursal", t.getIdSucursal()));
        List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
        sucursals.forEach(item -> {

            MaterialUnidad mu = new MaterialUnidad();
            mu.setIdEmpresa(item.getIdEmpresa());
            mu.setIdSucursal(item.getIdSucursal());
            mu.setIdMaterial(t.getIdMaterial());
            mu.setIdUmedida(t.getIdUmedida());
            mu.setEquivalencia(t.getEquivalencia());
            mu.setPrecio(t.getPrecio());
            mu.setBase(t.isBase());
            dao.create(mu);
        });
    }

    @Override
    @Transactional
    public void update(MaterialUnidad t) {
        dao.update(t);

        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("eq", "idEmpresa", t.getIdEmpresa()));
        filters.add(new FilterPage("nin", "idSucursal", t.getIdSucursal()));
        List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
        sucursals.forEach(item -> {
            MaterialUnidad mu = new MaterialUnidad();
            mu.setIdEmpresa(item.getIdEmpresa());
            mu.setIdSucursal(item.getIdSucursal());
            mu.setIdMaterial(t.getIdMaterial());
            mu.setIdUmedida(t.getIdUmedida());
            mu.setEquivalencia(t.getEquivalencia());
            mu.setPrecio(t.getPrecio());
            mu.setBase(t.isBase());
            dao.update(mu);
        });
    }

    @Override
    @Transactional
    public void delete(MaterialUnidad t) {
        dao.delete(t);

        List<FilterPage> filters = new ArrayList<>();
        filters.add(new FilterPage("eq", "idEmpresa", t.getIdEmpresa()));
        filters.add(new FilterPage("nin", "idSucursal", t.getIdSucursal()));
        List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
        sucursals.forEach(item -> {
            MaterialUnidad mu = new MaterialUnidad();
            mu.setIdEmpresa(item.getIdEmpresa());
            mu.setIdSucursal(item.getIdSucursal());
            mu.setIdMaterial(t.getIdMaterial());
            mu.setIdUmedida(t.getIdUmedida());
            mu.setEquivalencia(t.getEquivalencia());
            mu.setPrecio(t.getPrecio());
            mu.setBase(t.isBase());
            dao.delete(mu);
        });
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
            Logger.getLogger(MaterialUnidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public MaterialUnidad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public MaterialUnidad lastByFilter(String filter, String query) {
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
            Logger.getLogger(MaterialUnidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<MaterialUnidad> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<MaterialUnidad> getByFilter(int start, int limit, String sort, String filter, String query) {
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
            Logger.getLogger(MaterialUnidadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public void changeLMaterialUnidad(List<MaterialUnidad> mun) {
        if (!mun.isEmpty()) {
            List<FilterPage> filters = new ArrayList<>();
            filters.add(new FilterPage("eq", "idEmpresa", mun.get(0).getIdEmpresa()));
            filters.add(new FilterPage("nin", "idSucursal", mun.get(0).getIdSucursal()));
            List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
            mun.forEach(t -> {
                dao.create(t);
                sucursals.forEach(item -> {
                    MaterialUnidad mu = new MaterialUnidad();
                    mu.setIdEmpresa(item.getIdEmpresa());
                    mu.setIdSucursal(item.getIdSucursal());
                    mu.setIdMaterial(t.getIdMaterial());
                    mu.setIdUmedida(t.getIdUmedida());
                    mu.setEquivalencia(t.getEquivalencia());
                    mu.setPrecio(t.getPrecio());
                    mu.setBase(t.isBase());
                    dao.create(mu);
                });
            });
        }
    }

    @Override
    @Transactional
    public void deleteLMaterialUnidad(List<MaterialUnidad> mun) {
        if (!mun.isEmpty()) {
            List<FilterPage> filters = new ArrayList<>();
            filters.add(new FilterPage("eq", "idEmpresa", mun.get(0).getIdEmpresa()));
            filters.add(new FilterPage("nin", "idSucursal", mun.get(0).getIdSucursal()));
            List<Sucursal> sucursals = dao2.getByFilter(0, 0, new ArrayList<>(), filters);
            mun.forEach(t -> {
                dao.delete(t);
                sucursals.forEach(item -> {
                    MaterialUnidad mu = new MaterialUnidad();
                    mu.setIdEmpresa(item.getIdEmpresa());
                    mu.setIdSucursal(item.getIdSucursal());
                    mu.setIdMaterial(t.getIdMaterial());
                    mu.setIdUmedida(t.getIdUmedida());
                    mu.setEquivalencia(t.getEquivalencia());
                    mu.setPrecio(t.getPrecio());
                    mu.setBase(t.isBase());
                    dao.delete(mu);
                });
            });
        }
    }

}
