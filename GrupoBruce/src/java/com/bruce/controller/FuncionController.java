/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Funcion;
import com.bruce.services.design.IFuncionService;
import com.bruce.util.FilterPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FuncionController {

    @Autowired
    private IFuncionService sct;

    @ResponseBody
    @RequestMapping(value = "/funcions", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", sct.getByFilter(start, limit, sort, filter, query));
        map.put("total", sct.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiFuncion", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Funcion funcion) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(funcion);
        map.put("success", true);
        map.put("data", funcion);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuFuncion", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Funcion funcion) {
        Map<String, Object> map = new HashMap<>();
        sct.update(funcion);
        map.put("success", true);
        map.put("data", funcion);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddFuncion", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Funcion funcion) {
        Map<String, Object> map = new HashMap<>();
        sct.delete(funcion);
        map.put("success", true);
        map.put("data", funcion);
        map.put("message", "Eliminación exitosa");
        return map;
    }

}
