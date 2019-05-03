/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Contratista;
import com.bruce.services.design.IContratistaService;
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
public class ContratistaController {
    @Autowired
    private IContratistaService serv;

    @ResponseBody
    @RequestMapping(value = "/contratistas", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de contratista");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiContratista", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Contratista contratista) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(contratista);
        map.put("success", true);
        map.put("data", contratista);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuContratista", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Contratista contratista) {
        Map<String, Object> map = new HashMap<>();
        serv.update(contratista);
        map.put("success", true);
        map.put("data", contratista);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddContratista", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Contratista contratista) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(contratista);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", contratista);
        map.put("message", msg);
        return map;
    }
}
