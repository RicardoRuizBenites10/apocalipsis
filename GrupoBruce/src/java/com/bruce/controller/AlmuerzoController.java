/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Almuerzo;
import com.bruce.services.design.IAlmuerzoService;
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
public class AlmuerzoController {
    
    @Autowired
    private IAlmuerzoService serv;

    @ResponseBody
    @RequestMapping(value = "/almuerzos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        int total = serv.countByFilter(filter, query);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de almuerzo");
        map.put("data", serv.getByFilter(start, total, sort, filter, query));
        map.put("total", total);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiAlmuerzo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Almuerzo almuerzo) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(almuerzo);
        map.put("success", true);
        map.put("data", almuerzo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuAlmuerzo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Almuerzo almuerzo) {
        Map<String, Object> map = new HashMap<>();
        serv.update(almuerzo);
        map.put("success", true);
        map.put("data", almuerzo);
        map.put("message", "Actualización exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/uuLAlmuerzo", method = RequestMethod.POST)
    public Map<String, Object> procesarAlmuerzos(@RequestBody List<Almuerzo> almuerzos) {
        Map<String, Object> map = new HashMap<>();
        serv.procesarAlmuerzos(almuerzos);
        map.put("success", true);
        map.put("message", "Almuerzos actualizados.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddAlmuerzo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Almuerzo almuerzo) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(almuerzo);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", almuerzo);
        map.put("message", msg);
        return map;
    }
}
