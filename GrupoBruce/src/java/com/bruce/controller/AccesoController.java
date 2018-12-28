/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Acceso;
import com.bruce.services.design.IAccesoService;
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
public class AccesoController {

    @Autowired
    private IAccesoService serv;

    @ResponseBody
    @RequestMapping(value = "/accesosRol", method = RequestMethod.GET)
    public Map<String, Object> getByRol(
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de accesos");
        map.put("data", serv.getByRol(filter));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/uuLAcceso", method = RequestMethod.POST)
    public Map<String, Object> changeByRol(@RequestBody List<Acceso> accesos) {
        Map<String, Object> map = new HashMap<>();
        serv.changeAcceso(accesos);
        map.put("success", true);
        map.put("data", accesos);
        map.put("message", "Accesos actualizados.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiAcceso", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Acceso acceso) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(acceso);
        map.put("success", true);
        map.put("data", acceso);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiLAcceso", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody List<Acceso> acceso) {
        Map<String, Object> map = new HashMap<>();
//        serv.insert(acceso);
        map.put("success", true);
        map.put("data", acceso);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuAcceso", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Acceso acceso) {
        Map<String, Object> map = new HashMap<>();
        serv.update(acceso);
        map.put("success", true);
        map.put("data", acceso);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddAcceso", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Acceso acceso) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(acceso);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", acceso);
        map.put("message", msg);
        return map;
    }

}
