/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Comisionrp;
import com.bruce.services.design.IComisionrpService;
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
public class ComisionrpController {

    @Autowired
    private IComisionrpService se;

    @ResponseBody
    @RequestMapping(value = "/comisionrps", method = RequestMethod.GET)
    public Map<String, Object> getByFilter(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", se.getByFilter(start, limit, sort, filter, query));
        map.put("total", se.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/comisionrpAll", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        List<Comisionrp> lista = se.findAll();

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiComisionrp", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Comisionrp comisionrp) {
        Map<String, Object> map = new HashMap<>();
        se.insert(comisionrp);
        map.put("success", true);
        map.put("data", comisionrp);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuComisionrp", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Comisionrp comisionrp) {
        Map<String, Object> map = new HashMap<>();
        se.update(comisionrp);
        map.put("success", true);
        map.put("data", comisionrp);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddComisionrp", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Comisionrp comisionrp) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            se.delete(comisionrp);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", comisionrp);
        map.put("message", msg);
        return map;
    }

}
