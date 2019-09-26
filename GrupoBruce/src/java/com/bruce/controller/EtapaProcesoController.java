/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EtapaProceso;
import com.bruce.services.design.IEtapaProcesoService;
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
public class EtapaProcesoController {

    @Autowired
    private IEtapaProcesoService serv;

    @ResponseBody
    @RequestMapping(value = "/etapaProcesos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam(required = false, value = "page") Integer page,
            @RequestParam(required = false, value = "start") Integer start,
            @RequestParam(required = false, value = "limit") Integer limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de etapaProceso");
        map.put("data", serv.getByFilter(0, 10000, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEtapaProceso", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EtapaProceso etapaProceso) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(etapaProceso);
        map.put("success", true);
        map.put("data", etapaProceso);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEtapaProceso", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EtapaProceso etapaProceso) {
        Map<String, Object> map = new HashMap<>();
        serv.update(etapaProceso);
        map.put("success", true);
        map.put("data", etapaProceso);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEtapaProceso", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EtapaProceso etapaProceso) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(etapaProceso);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", etapaProceso);
        map.put("message", msg);
        return map;
    }
}
