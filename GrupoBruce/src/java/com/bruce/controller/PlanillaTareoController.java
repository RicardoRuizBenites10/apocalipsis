/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.PlanillaTareo;
import com.bruce.services.design.IPlanillaTareoService;
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
public class PlanillaTareoController {

    @Autowired
    private IPlanillaTareoService serv;

    @ResponseBody
    @RequestMapping(value = "/planillasTareo", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        int total = serv.countByFilter(filter, query);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", serv.getByFilter(start, total, sort, filter, query));
        map.put("total", total);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiPlanillaTareo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody PlanillaTareo planillaTareo) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(planillaTareo);
        map.put("success", true);
        map.put("data", planillaTareo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuPlanillaTareo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody PlanillaTareo planillaTareo) {
        Map<String, Object> map = new HashMap<>();
        serv.update(planillaTareo);
        map.put("success", true);
        map.put("data", planillaTareo);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuLPlanillaTareo", method = RequestMethod.POST)
    public Map<String, Object> apruebaPlanillaTareo(@RequestBody List<PlanillaTareo> planillasTareo) {
        Map<String, Object> map = new HashMap<>();
        serv.aprobarPTareo(planillasTareo);
        map.put("success", true);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uu2LPlanillaTareo", method = RequestMethod.POST)
    public Map<String, Object> procesaPlanillaTareo(@RequestBody List<PlanillaTareo> planillaTareos) {
        Map<String, Object> map = new HashMap<>();
        serv.procesarPTareo(planillaTareos);
        map.put("success", true);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddPlanillaTareo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody PlanillaTareo planillaTareo) {
        Map<String, Object> map = new HashMap<>();
        serv.delete(planillaTareo);
        map.put("success", true);
        map.put("data", planillaTareo);
        map.put("message", "Eliminación exitosa");
        return map;
    }
}
