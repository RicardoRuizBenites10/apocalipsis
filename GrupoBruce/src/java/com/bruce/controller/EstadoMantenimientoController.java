/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EstadoMantenimiento;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bruce.services.design.IEstadoMantenimientoService;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class EstadoMantenimientoController {

    @Autowired
    private IEstadoMantenimientoService sct;

    @ResponseBody
    @RequestMapping(value = "/estadosMantenimiento", method = RequestMethod.GET)
    public Map<String, Object> getByFilters() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", sct.getByFilter(0, 100, null));
        map.put("total", sct.countByFilter(null));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEstadoMantenimiento", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EstadoMantenimiento estadoMantenimiento) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(estadoMantenimiento);
        map.put("success", true);
        map.put("data", estadoMantenimiento);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEstadoMantenimiento", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EstadoMantenimiento estadoMantenimiento) {
        Map<String, Object> map = new HashMap<>();
        sct.update(estadoMantenimiento);
        map.put("success", true);
        map.put("data", estadoMantenimiento);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEstadoMantenimiento", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EstadoMantenimiento estadoMantenimiento) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(estadoMantenimiento);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", estadoMantenimiento);
        map.put("message", msg);
        return map;
    }

}
