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
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
        String idMarca = String.valueOf(t.getAnio()) + String.format("%02d", t.getMes()) + String.format("%02d", t.getDia());
        List<FilterPage> filter = new ArrayList<>();
        filter.add(new FilterPage("eq", "idTrabajador", t.getIdTrabajador()));
        filter.add(new FilterPage("eq", "fecha", t.getFecha()));
        Marca lastM = dao.lastByFilter(filter);
        int idLastM = lastM != null ? Integer.parseInt(lastM.getIdMarca().substring(8)) : 0;
        t.setIdMarca(idMarca + String.format("%02d", idLastM + 1));
        t.setAutomatico(false);
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
        Asistencia asistencia;
        Marca marca, lastM;
        String idMarca;
        int idLastM;
        for (Marca item : marcas) {
            if (daoT.get(item.getIdTrabajador()) != null) {
                filter.add(new FilterPage("eq", "ID_TRABAJADOR", item.getIdTrabajador()));
                filter.add(new FilterPage("eq", "ANIO", item.getAnio()));
                filter.add(new FilterPage("eq", "MES", item.getMes()));
                filter.add(new FilterPage("eq", "DIA", item.getDia()));
                asistencia = daoA.lastByFilter(filter);
                idMarca = String.valueOf(item.getAnio()) + String.format("%02d", item.getMes()) + String.format("%02d", item.getDia());
                if (asistencia == null) {
                    daoA.create(new Asistencia(item.getIdTrabajador(), item.getFecha(), item.getHmarca(), item.getAnio(), item.getMes(), item.getDia(), Constante.ASISTENCIA_AUSENCIA_ASISTIO, true));
                    item.setIdMarca(idMarca + "01");
                    dao.create(item);
                } else {
                    filter.clear();
                    filter.add(new FilterPage("eq", "hmarca", item.getHmarca()));
                    filter.add(new FilterPage("eq", "idTrabajador", asistencia.getIdTrabajador()));
                    filter.add(new FilterPage("eq", "fecha", asistencia.getFecha()));
                    marca = dao.lastByFilter(filter);
                    if (marca == null) {
                        filter.remove(0);
                        lastM = dao.lastByFilter(filter);
                        idLastM = lastM != null ? Integer.parseInt(lastM.getIdMarca().substring(8)) : 0;
                        item.setIdMarca(idMarca + String.format("%02d", idLastM + 1));
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
                        asistencia.setMarca7(item.getHmarca());
                        daoA.update(asistencia);
                    }
                }
                filter.clear();
            } else {
                notFound.add(item);
            }
        }
        return notFound;
    }

}
