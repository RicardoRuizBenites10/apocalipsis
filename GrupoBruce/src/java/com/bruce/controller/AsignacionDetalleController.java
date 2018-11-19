/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.AsignacionDetalle;
import com.bruce.services.design.IAsignacionDetalleService;
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
public class AsignacionDetalleController {

    @Autowired
    private IAsignacionDetalleService sct;

    @ResponseBody
    @RequestMapping(value = "/asignacionsDetalle", method = RequestMethod.GET)
    public Map<String, Object> getByFilters() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", sct.getByFilter(0, 100, null));
        map.put("total", sct.countByFilter(null));
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/validaRAsignacionEquipo", method = RequestMethod.POST)
    public Map<String, Object> validaRAsignacion(@RequestBody AsignacionDetalle asignacionDetalle) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("validado", sct.validaREquipoAsignacion(asignacionDetalle));
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiAsignacionDetalle", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody AsignacionDetalle asignacionDetalle) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(asignacionDetalle);
        map.put("success", true);
        map.put("data", asignacionDetalle);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuAsignacionDetalle", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody AsignacionDetalle asignacionDetalle) {
        Map<String, Object> map = new HashMap<>();
        sct.update(asignacionDetalle);
        map.put("success", true);
        map.put("data", asignacionDetalle);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddAsignacionDetalle", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody AsignacionDetalle asignacionDetalle) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(asignacionDetalle);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", asignacionDetalle);
        map.put("message", msg);
        return map;
    }

}
