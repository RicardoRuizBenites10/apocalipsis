/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.implement;

import com.bruce.controller.TrabajadorController;
import com.bruce.dao.design.IAsistenciaDAO;
import com.bruce.dao.design.IMarcaDAO;
import com.bruce.dao.design.ITrabajadorDAO;
import com.bruce.dao.to.Asistencia;
import com.bruce.dao.to.Marca;
import com.bruce.services.design.IMarcaService;
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
public class MarcaService implements IMarcaService {

    @Autowired
    private IMarcaDAO dao;
    @Autowired
    private ITrabajadorDAO daoT;
    @Autowired
    private IAsistenciaDAO daoA;

    @Override
    @Transactional
    public void insert(Marca t) {
        dao.create(t);
    }

    @Override
    @Transactional
    public void update(Marca t) {
        dao.update(t);
    }

    @Override
    @Transactional
    public void delete(Marca t) {
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
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.countByFilter(filters);
    }

    @Override
    @Transactional
    public Marca find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Marca lastByFilter(String filter, String query) {
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
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.lastByFilter(filters);
    }

    @Override
    @Transactional
    public List<Marca> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Marca> getByFilter(int start, int limit, String sort, String filter, String query) {
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
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dao.getByFilter(start, limit, sorts, filters);
    }

    @Override
    @Transactional
    public List<Marca> insertList(List<Marca> marcas) {
        List<Marca> notFound = new ArrayList<>();
        List<FilterPage> filter = new ArrayList<>();
        Asistencia asistencia, lastA;
        Marca lastM;
        String idAsistencia;
        int idLastA, idLastM;
        for (Marca item : marcas) {
            filter.clear();
            if (daoT.get(item.getIdTrabajador()) != null) {
                item.setSituacion(true);
                filter.add(new FilterPage("eq", "idTrabajador", item.getIdTrabajador()));
                filter.add(new FilterPage("eq", "anio", item.getAnio()));
                filter.add(new FilterPage("eq", "mes", item.getMes()));
                filter.add(new FilterPage("eq", "dia", item.getDia()));
                asistencia = daoA.lastByFilter(filter);
                if (asistencia == null) {
                    filter.remove(0);
                    lastA = daoA.lastByFilter(filter);
                    idLastA = lastA != null ? Integer.parseInt(lastA.getIdAsistencia().substring(8)) : 0;
                    idAsistencia = item.getAnio() + item.getMes() + item.getDia() + String.format("%04d", idLastA + 1);
                    daoA.create(new Asistencia(item.getIdTrabajador(), idAsistencia, item.getFecha(), item.getHmarca(), item.getAnio(), item.getMes(), item.getDia()));
                    item.setIdAsistencia(idAsistencia);
                    item.setIdMarca(idAsistencia + "01");
                    System.err.println("idMarca: " + idAsistencia + "01");
                    dao.create(item);
                } else {
                    filter.clear();
                    filter.add(new FilterPage("eq", "idAsistencia", asistencia.getIdAsistencia()));
                    lastM = dao.lastByFilter(filter);
                    idLastM = lastM != null ? Integer.parseInt(lastM.getIdMarca().substring(12)) : 0;
                    item.setIdMarca(asistencia.getIdAsistencia() + String.format("%02d", idLastM + 1));
                    dao.create(item);
                    switch (idLastM + 1) {
                        case 1:
                            asistencia.setMarca1(item.getHmarca());
                            break;
                        case 2:
                            asistencia.setMarca2(item.getHmarca());
                            break;
                        case 3:
                            asistencia.setMarca3(item.getHmarca());
                            break;
                        case 4:
                            asistencia.setMarca4(item.getHmarca());
                            break;
                        case 5:
                            asistencia.setMarca5(item.getHmarca());
                            break;
                        case 6:
                            asistencia.setMarca6(item.getHmarca());
                            break;
                    }
                    daoA.update(asistencia);
                }
                insert(item);
            } else {
                notFound.add(item);
            }
        }
        return notFound;
    }

}
