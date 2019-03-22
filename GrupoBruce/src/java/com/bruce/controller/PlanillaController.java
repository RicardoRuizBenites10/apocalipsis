/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Planilla;
import com.bruce.services.design.IPlanillaService;
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
public class PlanillaController {

    @Autowired
    private IPlanillaService serv;

    @ResponseBody
    @RequestMapping(value = "/planillas", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de planilla");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiPlanilla", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Planilla planilla) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(planilla);
        map.put("success", true);
        map.put("data", planilla);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuPlanilla", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Planilla planilla) {
        Map<String, Object> map = new HashMap<>();
        serv.update(planilla);
        map.put("success", true);
        map.put("data", planilla);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuLPlanilla", method = RequestMethod.POST)
    public Map<String, Object> procesarPlanilla(@RequestBody List<Planilla> planillas) {
        Map<String, Object> map = new HashMap<>();
        serv.procesarPlanilla(planillas);
        map.put("success", true);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddPlanilla", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Planilla planilla) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(planilla);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", planilla);
        map.put("message", msg);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/RCplanilla", method = RequestMethod.GET)
    public Map<String, Object> reportCuadroPlanilla(
            @RequestParam("idPplanilla") int idPplanilla) {
        Map<String, Object> map = new HashMap<>();
        serv.reportCuadroPlanilla(idPplanilla);
        map.put("success", true);
        map.put("message", "Lista de planilla");
        return map;
    }
}
