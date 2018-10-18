/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Vacacion;
import com.bruce.services.design.IVacacionService;
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
public class VacacionController {

    @Autowired
    private IVacacionService serv;

    @ResponseBody
    @RequestMapping(value = "/vacacions", method = RequestMethod.GET)
    public Map<String, Object> getByFilter(
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
        List<Vacacion> lista = serv.getByFilter(start, limit, filters);

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", serv.countByFilter(filters));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/insertVacacion", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Vacacion vacacion) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(vacacion);
        map.put("success", true);
        map.put("data", vacacion);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateVacacion", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Vacacion vacacion) {
        Map<String, Object> map = new HashMap<>();
        serv.update(vacacion);
        map.put("success", true);
        map.put("data", vacacion);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteVacacion", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Vacacion vacacion) {
        Map<String, Object> map = new HashMap<>();
        serv.delete(vacacion);
        map.put("success", true);
        map.put("data", vacacion);
        map.put("message", "Eliminación exitosa");
        return map;
    }

}
