/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Marca;
import com.bruce.dao.to.Marca;
import com.bruce.services.design.IMarcaService;
import com.bruce.util.Constante;
import com.bruce.util.FilterPage;
import com.bruce.util.Metodo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author RICARDO
 */
@Controller
public class MarcaController {
    
    @Autowired
    private IMarcaService serv;
    
    @ResponseBody
    @RequestMapping(value = "/imports", method = RequestMethod.GET)
    public Map<String, Object> getImport(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map<String, Object> map = new HashMap<>();
        List<Marca> lista = (filters.size() > 0 && filters.get(0).getValue() != null) ? Metodo.Importar(new File(Constante.DIRECTORY_ASISTENCIA + filters.get(0).getValue())) : new ArrayList<>();

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", lista.size());
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/marcas", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiMarca", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Marca marca) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(marca);
        map.put("success", true);
        map.put("data", marca);
        map.put("message", "Registro exitoso.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/iiMarcaList", method = RequestMethod.POST)
    public Map<String, Object> insertList(@RequestBody List<Marca> marca) {
        Map<String, Object> map = new HashMap<>();
        marca = serv.insertList(marca);
        map.put("success", true);
        map.put("data", marca);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuMarca", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Marca marca) {
        Map<String, Object> map = new HashMap<>();
        serv.update(marca);
        map.put("success", true);
        map.put("data", marca);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddMarca", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Marca marca) {
        Map<String, Object> map = new HashMap<>();
        serv.delete(marca);
        map.put("success", true);
        map.put("data", marca);
        map.put("message", "Eliminación exitosa");
        return map;
    }
}
