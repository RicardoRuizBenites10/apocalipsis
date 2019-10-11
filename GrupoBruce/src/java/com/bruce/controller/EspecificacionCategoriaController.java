/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EspecificacionCategoria;
import com.bruce.services.design.IEspecificacionCategoriaService;
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
public class EspecificacionCategoriaController {
    
    @Autowired
    private IEspecificacionCategoriaService serv;

    @ResponseBody
    @RequestMapping(value = "/especificacionCategorias", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam(required = false, value = "page") Integer page,
            @RequestParam(required = false, value = "start") Integer start,
            @RequestParam(required = false, value = "limit") Integer limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de especificación categoria");
        map.put("data", serv.getByFilter(0, 1000, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEspecificacionCategoria", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EspecificacionCategoria especificacionCategoria) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(especificacionCategoria);
        map.put("success", true);
        map.put("data", especificacionCategoria);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEspecificacionCategoria", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EspecificacionCategoria especificacionCategoria) {
        Map<String, Object> map = new HashMap<>();
        serv.update(especificacionCategoria);
        map.put("success", true);
        map.put("data", especificacionCategoria);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEspecificacionCategoria", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EspecificacionCategoria especificacionCategoria) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(especificacionCategoria);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("success", success);
        map.put("data", especificacionCategoria);
        map.put("message", msg);
        return map;
    }

}
