/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Asistencia;
import com.bruce.services.design.IAsistenciaService;
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
public class AsistenciaController {

    @Autowired
    private IAsistenciaService sct;

    @ResponseBody
    @RequestMapping(value = "/asistencias", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", sct.getByFilter(start, limit, sort, filter, query));
        map.put("total", sct.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiAsistencia", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Asistencia asistencia) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(asistencia);
        map.put("success", true);
        map.put("data", asistencia);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiAsistenciaList", method = RequestMethod.POST)
    public Map<String, Object> insertList(@RequestBody List<Asistencia> asistencia) {
        Map<String, Object> map = new HashMap<>();

        asistencia = sct.insertList(asistencia);
        map.put("success", true);
        map.put("data", asistencia);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuAsistencia", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Asistencia asistencia) {
        Map<String, Object> map = new HashMap<>();
        sct.update(asistencia);
        map.put("success", true);
        map.put("data", asistencia);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddAsistencia", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Asistencia asistencia) {
        Map<String, Object> map = new HashMap<>();
        sct.delete(asistencia);
        map.put("success", true);
        map.put("data", asistencia);
        map.put("message", "Eliminación exitosa");
        return map;
    }

}
