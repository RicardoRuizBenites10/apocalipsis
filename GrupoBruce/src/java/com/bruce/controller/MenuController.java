/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Menu;
import com.bruce.services.design.IMenuService;
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
public class MenuController {

    @Autowired
    private IMenuService sct;

    @ResponseBody
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de datos");
        map.put("data", sct.getByFilter(start, limit, sort, filter, query));
        map.put("total", sct.countByFilter(filter, query));
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/maccesos", method = RequestMethod.GET)
    public Map<String, Object> getByUsuario(
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de datos");
        map.put("data", sct.findAll());
        map.put("total", 1000);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiMenu", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Menu menu) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(menu);
        map.put("success", true);
        map.put("data", menu);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuMenu", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Menu menu) {
        Map<String, Object> map = new HashMap<>();
        sct.update(menu);
        map.put("success", true);
        map.put("data", menu);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddMenu", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Menu menu) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(menu);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", menu);
        map.put("message", msg);
        return map;
    }

}
