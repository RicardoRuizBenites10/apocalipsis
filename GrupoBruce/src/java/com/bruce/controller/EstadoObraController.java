/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EstadoObra;
import com.bruce.services.design.IEstadoObraService;
import java.util.HashMap;
import java.util.Map;
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
public class EstadoObraController {
    
    @Autowired
    private IEstadoObraService serv;

    @ResponseBody
    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam(required = false, value = "page") Integer page,
            @RequestParam(required = false, value = "start") Integer start,
            @RequestParam(required = false, value = "limit") Integer limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de estados");
        map.put("data", serv.getByFilter(0, 1000, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEstadoObra", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EstadoObra area) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(area);
        map.put("success", true);
        map.put("data", area);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEstadoObra", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EstadoObra area) {
        Map<String, Object> map = new HashMap<>();
        serv.update(area);
        map.put("success", true);
        map.put("data", area);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEstadoObra", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EstadoObra area) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(area);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", area);
        map.put("message", msg);
        return map;
    }
}
