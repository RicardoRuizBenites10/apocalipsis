/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Proceso;
import com.bruce.services.design.IProcesoService;
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
 * @author RICARDO
 */
@Controller
public class ProcesoController {

    @Autowired
    private IProcesoService sct;

    @ResponseBody
    @RequestMapping(value = "/procesos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de proceso");
        map.put("data", sct.getByFilter(start, limit, sort, filter, query));
        map.put("total", sct.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiProceso", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Proceso proceso) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(proceso);
        map.put("success", true);
        map.put("data", proceso);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuProceso", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Proceso proceso) {
        Map<String, Object> map = new HashMap<>();
        sct.update(proceso);
        map.put("success", true);
        map.put("data", proceso);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddProceso", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Proceso proceso) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(proceso);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", proceso);
        map.put("message", msg);
        return map;
    }
  
}