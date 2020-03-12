/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Requerimiento;
import com.bruce.services.design.IRequerimientoService;
import java.util.HashMap;
import java.util.List;
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
public class RequerimientoController {
    
    @Autowired
    private IRequerimientoService serv;

    @ResponseBody
    @RequestMapping(value = "/requerimientos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de requerimiento");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiRequerimiento", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Requerimiento requerimiento) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(requerimiento);
        map.put("success", true);
        map.put("data", requerimiento);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiLRequerimiento", method = RequestMethod.POST)
    public Map<String, Object> insertL(@RequestBody List<Requerimiento> requerimiento) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLRequerimiento(requerimiento);
        map.put("success", true);
        map.put("data", requerimiento);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuRequerimiento", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Requerimiento requerimiento) {
        Map<String, Object> map = new HashMap<>();
        serv.update(requerimiento);
        map.put("success", true);
        map.put("data", requerimiento);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuLRequerimiento", method = RequestMethod.POST)
    public Map<String, Object> updateL(@RequestBody List<Requerimiento> requerimiento) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLRequerimiento(requerimiento);
        map.put("success", true);
        map.put("data", requerimiento);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddRequerimiento", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Requerimiento requerimiento) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(requerimiento);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", requerimiento);
        map.put("message", msg);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddLRequerimiento", method = RequestMethod.POST)
    public Map<String, Object> deleteL(@RequestBody List<Requerimiento> requerimiento) {
        Map<String, Object> map = new HashMap<>();
        serv.deleteLRequerimiento(requerimiento);
        map.put("success", true);
        map.put("data", requerimiento);
        map.put("message", "Eliminación exitosa");
        return map;
    }
    
}
