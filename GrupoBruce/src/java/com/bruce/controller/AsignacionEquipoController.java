/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.AsignacionEquipo;
import com.bruce.services.design.IAsignacionEquipoService;
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
public class AsignacionEquipoController {

    @Autowired
    private IAsignacionEquipoService sct;

    @ResponseBody
    @RequestMapping(value = "/asignacionsEquipo", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", sct.getByFilter(start, limit, sort, filter, query));
        map.put("total", sct.countByFilter(filter, query));
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/relacionAsignacionEquipo", method = RequestMethod.POST)
    public Map<String, Object> validaRelacion(@RequestBody AsignacionEquipo asignacionEquipo) {
        return sct.validaRelacion(asignacionEquipo);
    }

    @ResponseBody
    @RequestMapping(value = "/iiAsignacionEquipo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody AsignacionEquipo asignacionEquipo) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(asignacionEquipo);
        map.put("success", true);
        map.put("data", asignacionEquipo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuAsignacionEquipo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody AsignacionEquipo asignacionEquipo) {
        Map<String, Object> map = new HashMap<>();
        sct.update(asignacionEquipo);
        map.put("success", true);
        map.put("data", asignacionEquipo);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddAsignacionEquipo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody AsignacionEquipo asignacionEquipo) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(asignacionEquipo);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", asignacionEquipo);
        map.put("message", msg);
        return map;
    }

}
