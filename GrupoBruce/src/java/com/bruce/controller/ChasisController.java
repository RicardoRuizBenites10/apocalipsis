/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Chasis;
import com.bruce.services.design.IChasisService;
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
public class ChasisController {
    @Autowired
    private IChasisService serv;

    @ResponseBody
    @RequestMapping(value = "/chasiss", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de chasis");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiChasis", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Chasis chasis) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(chasis);
        map.put("success", true);
        map.put("data", chasis);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuChasis", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Chasis chasis) {
        Map<String, Object> map = new HashMap<>();
        serv.update(chasis);
        map.put("success", true);
        map.put("data", chasis);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddChasis", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Chasis chasis) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(chasis);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", chasis);
        map.put("message", msg);
        return map;
    }

}
