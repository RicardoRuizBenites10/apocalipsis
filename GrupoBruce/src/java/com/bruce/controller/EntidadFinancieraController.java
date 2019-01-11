/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EntidadFinanciera;
import com.bruce.services.design.IEntidadFinancieraService;
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
 * @author RICARDO
 */
@Controller
public class EntidadFinancieraController {

    @Autowired
    private IEntidadFinancieraService sec;

    @ResponseBody
    @RequestMapping(value = "/entidadFinancieraBySituacion", method = RequestMethod.GET)
    public Map<String, Object> getBySituacion(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        List<EntidadFinanciera> lista = sec.findBySituacion(true);
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", sec.countByFilter(filter, query));
        map.put("total", sec.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEntidadFinanciera", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EntidadFinanciera entidadFinanciera) {
        Map<String, Object> map = new HashMap<>();
        sec.insert(entidadFinanciera);
        map.put("success", true);
        map.put("data", entidadFinanciera);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEntidadFinanciera", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EntidadFinanciera entidadFinanciera) {
        Map<String, Object> map = new HashMap<>();
        sec.update(entidadFinanciera);
        map.put("success", true);
        map.put("data", entidadFinanciera);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEntidadFinanciera", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EntidadFinanciera entidadFinanciera) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sec.delete(entidadFinanciera);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", entidadFinanciera);
        map.put("message", msg);
        return map;
    }

}
