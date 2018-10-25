/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Cargo;
import com.bruce.services.design.ICargoService;
import com.bruce.util.FilterPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * @author SISTEMAS
 */
@Controller
public class CargoController {

    @Autowired
    private ICargoService sct;

    @ResponseBody
    @RequestMapping(value = "/cargos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam("filter") String filter) {

        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map<String, Object> map = new HashMap<>();
        List<Cargo> lista = sct.getByFilter(start, limit, filters);

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", sct.countByFilter(filters));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiCargo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Cargo cargo) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(cargo);
        map.put("success", true);
        map.put("data", cargo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuCargo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Cargo cargo) {
        Map<String, Object> map = new HashMap<>();
        sct.update(cargo);
        map.put("success", true);
        map.put("data", cargo);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddCargo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Cargo cargo) {
        Map<String, Object> map = new HashMap<>();
        sct.delete(cargo);
        map.put("success", true);
        map.put("data", cargo);
        map.put("message", "Eliminación exitosa");
        return map;
    }

}
