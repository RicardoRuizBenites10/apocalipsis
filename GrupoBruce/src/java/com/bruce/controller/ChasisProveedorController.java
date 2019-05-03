/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ChasisProveedor;
import com.bruce.services.design.IChasisProveedorService;
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
public class ChasisProveedorController {
    @Autowired
    private IChasisProveedorService serv;

    @ResponseBody
    @RequestMapping(value = "/chasisProveedors", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de chasisProveedor");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiChasisProveedor", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ChasisProveedor chasisProveedor) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(chasisProveedor);
        map.put("success", true);
        map.put("data", chasisProveedor);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuChasisProveedor", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ChasisProveedor chasisProveedor) {
        Map<String, Object> map = new HashMap<>();
        serv.update(chasisProveedor);
        map.put("success", true);
        map.put("data", chasisProveedor);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddChasisProveedor", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ChasisProveedor chasisProveedor) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(chasisProveedor);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", chasisProveedor);
        map.put("message", msg);
        return map;
    }
}
