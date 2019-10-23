/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EspecificacionActividad;
import com.bruce.services.design.IEspecificacionActividadService;
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
public class EspecificacionActividadController {
    @Autowired
    private IEspecificacionActividadService serv;

    @ResponseBody
    @RequestMapping(value = "/especificacionActividads", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de especificacionActividad");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEspecificacionActividad", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EspecificacionActividad especificacionActividad) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(especificacionActividad);
        map.put("success", true);
        map.put("data", especificacionActividad);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiLEspecificacionActividad", method = RequestMethod.POST)
    public Map<String, Object> insertL(@RequestBody List<EspecificacionActividad> especificacionActividad) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLEspecificacionActividad(especificacionActividad);
        map.put("success", true);
        map.put("data", especificacionActividad);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEspecificacionActividad", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EspecificacionActividad especificacionActividad) {
        Map<String, Object> map = new HashMap<>();
        serv.update(especificacionActividad);
        map.put("success", true);
        map.put("data", especificacionActividad);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuLEspecificacionActividad", method = RequestMethod.POST)
    public Map<String, Object> updateL(@RequestBody List<EspecificacionActividad> especificacionActividad) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLEspecificacionActividad(especificacionActividad);
        map.put("success", true);
        map.put("data", especificacionActividad);
        map.put("message", "Actualización exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ddEspecificacionActividad", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EspecificacionActividad especificacionActividad) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(especificacionActividad);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", especificacionActividad);
        map.put("message", msg);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ddLEspecificacionActividad", method = RequestMethod.POST)
    public Map<String, Object> deleteL(@RequestBody List<EspecificacionActividad> especificacionActividad) {
        Map<String, Object> map = new HashMap<>();
        serv.deleteLEspecificacionActividad(especificacionActividad);
        map.put("success", true);
        map.put("data", especificacionActividad);
        map.put("message", "Eliminación exitosa");
        return map;
    }
}
