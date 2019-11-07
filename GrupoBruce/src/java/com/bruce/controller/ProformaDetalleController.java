/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ProformaDetalle;
import com.bruce.services.design.IProformaDetalleService;
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
public class ProformaDetalleController {

    @Autowired
    private IProformaDetalleService serv;

    @ResponseBody
    @RequestMapping(value = "/proformaDetalles", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query,
            @RequestParam("newProforma") boolean newProforma) {
        Map<String, Object> map = new HashMap<>();
        List<ProformaDetalle> lista = !newProforma ? serv.getByFilter(start, limit, sort, filter, query) : serv.getByFilterP(start, limit, sort, filter, query);
        map.put("success", true);
        map.put("message", "Lista de proformaDetalle");
        map.put("data", lista);
        map.put("total", 0);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiProformaDetalle", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ProformaDetalle proformaDetalle) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(proformaDetalle);
        map.put("success", true);
        map.put("data", proformaDetalle);
        map.put("message", "Registro exitoso.");
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/iiLProformaDetalle", method = RequestMethod.POST)
    public Map<String, Object> insertL(@RequestBody List<ProformaDetalle> proformaDetalle) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLProformaDetalle(proformaDetalle);
        map.put("success", true);
        map.put("data", proformaDetalle);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuProformaDetalle", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ProformaDetalle proformaDetalle) {
        Map<String, Object> map = new HashMap<>();
        serv.update(proformaDetalle);
        map.put("success", true);
        map.put("data", proformaDetalle);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuLProformaDetalle", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody List<ProformaDetalle> proformaDetalle) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLProformaDetalle(proformaDetalle);
        map.put("success", true);
        map.put("data", proformaDetalle);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddProformaDetalle", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ProformaDetalle proformaDetalle) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(proformaDetalle);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", proformaDetalle);
        map.put("message", msg);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ddLProformaDetalle", method = RequestMethod.POST)
    public Map<String, Object> deleteL(@RequestBody List<ProformaDetalle> proformaDetalle) {
        Map<String, Object> map = new HashMap<>();
        serv.deleteLProformaDetalle(proformaDetalle);
        map.put("success", true);
        map.put("data", proformaDetalle);
        map.put("message", "Eliminacion exitosa.");
        return map;
    }

}
