/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EstadoEquipo;
import com.bruce.services.design.IEstadoEquipoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author RICARDO
 */
@Controller
public class EstadoEquipoController {

    @Autowired
    private IEstadoEquipoService sct;

    @ResponseBody
    @RequestMapping(value = "/estadosEquipo", method = RequestMethod.GET)
    public Map<String, Object> getByFilters() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", sct.getByFilter(0, 100, null));
        map.put("total", sct.countByFilter(null));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEstadoEquipo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EstadoEquipo estadoEquipo) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(estadoEquipo);
        map.put("success", true);
        map.put("data", estadoEquipo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEstadoEquipo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EstadoEquipo estadoEquipo) {
        Map<String, Object> map = new HashMap<>();
        sct.update(estadoEquipo);
        map.put("success", true);
        map.put("data", estadoEquipo);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEstadoEquipo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EstadoEquipo estadoEquipo) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(estadoEquipo);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", estadoEquipo);
        map.put("message", msg);
        return map;
    }

    
}
