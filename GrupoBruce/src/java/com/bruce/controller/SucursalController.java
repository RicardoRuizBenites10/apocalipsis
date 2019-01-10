/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Sucursal;
import com.bruce.services.design.ISucursalService;
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
public class SucursalController {
    
    @Autowired
    private ISucursalService se;
    
    @ResponseBody
    @RequestMapping(value="/sucursals", method = RequestMethod.GET)
    public Map<String, Object> getByFilter(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query){
        
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", se.getByFilter(start, limit, sort, filter, query));
        map.put("total", se.countByFilter(filter, query));
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value="/sucursalAll", method = RequestMethod.GET)
    public Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<Sucursal> lista = se.findAll();
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiSucursal", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Sucursal sucursal) {
        Map<String, Object> map = new HashMap<>();
        se.insert(sucursal);
        map.put("success", true);
        map.put("data", sucursal);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuSucursal", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Sucursal sucursal) {
        Map<String, Object> map = new HashMap<>();
        se.update(sucursal);
        map.put("success", true);
        map.put("data", sucursal);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddSucursal", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Sucursal sucursal) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            se.delete(sucursal);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", sucursal);
        map.put("message", msg);
        return map;
    }
    
}
