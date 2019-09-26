/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ActividadMaterial;
import com.bruce.services.design.IActividadMaterialService;
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
public class ActividadMaterialController {

    @Autowired
    private IActividadMaterialService serv;

    @ResponseBody
    @RequestMapping(value = "/actividadMaterials", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de actividadMaterial");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiActividadMaterial", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ActividadMaterial actividadMaterial) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(actividadMaterial);
        map.put("success", true);
        map.put("data", actividadMaterial);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiLActividadMaterial", method = RequestMethod.POST)
    public Map<String, Object> insertL(@RequestBody List<ActividadMaterial> actividadMaterial) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLActividadMaterial(actividadMaterial);
        map.put("success", true);
        map.put("data", actividadMaterial);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuActividadMaterial", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ActividadMaterial actividadMaterial) {
        Map<String, Object> map = new HashMap<>();
        serv.update(actividadMaterial);
        map.put("success", true);
        map.put("data", actividadMaterial);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuLActividadMaterial", method = RequestMethod.POST)
    public Map<String, Object> updateL(@RequestBody List<ActividadMaterial> actividadMaterial) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLActividadMaterial(actividadMaterial);
        map.put("success", true);
        map.put("data", actividadMaterial);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddActividadMaterial", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ActividadMaterial actividadMaterial) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(actividadMaterial);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", actividadMaterial);
        map.put("message", msg);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddLActividadMaterial", method = RequestMethod.POST)
    public Map<String, Object> deleteL(@RequestBody List<ActividadMaterial> actividadMaterial) {
        Map<String, Object> map = new HashMap<>();
        serv.deleteLActividadMaterial(actividadMaterial);
        map.put("success", true);
        map.put("data", actividadMaterial);
        map.put("message", "Eliminación exitosa");
        return map;
    }
}
