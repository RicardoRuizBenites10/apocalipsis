/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ObraTipo;
import com.bruce.services.design.IObraTipoService;
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
public class ObraTipoController {
    @Autowired
    private IObraTipoService serv;

    @ResponseBody
    @RequestMapping(value = "/obratipos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de obraTipo");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiObraTipo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ObraTipo obraTipo) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(obraTipo);
        map.put("success", true);
        map.put("data", obraTipo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuObraTipo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ObraTipo obraTipo) {
        Map<String, Object> map = new HashMap<>();
        serv.update(obraTipo);
        map.put("success", true);
        map.put("data", obraTipo);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddObraTipo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ObraTipo obraTipo) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(obraTipo);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", obraTipo);
        map.put("message", msg);
        return map;
    }

}
