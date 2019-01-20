/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ConceptoAsignado;
import com.bruce.services.design.IConceptoAsignadoService;
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
 * @author RICARDO
 */
@Controller
public class ConceptoAsignadoController {
    @Autowired
    private IConceptoAsignadoService serv;

    @ResponseBody
    @RequestMapping(value = "/conceptosAsignado", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de conceptoAsignado");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiConceptoAsignado", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ConceptoAsignado conceptoAsignado) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(conceptoAsignado);
        map.put("success", true);
        map.put("data", conceptoAsignado);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuConceptoAsignado", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ConceptoAsignado conceptoAsignado) {
        Map<String, Object> map = new HashMap<>();
        serv.update(conceptoAsignado);
        map.put("success", true);
        map.put("data", conceptoAsignado);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddConceptoAsignado", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ConceptoAsignado conceptoAsignado) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(conceptoAsignado);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", conceptoAsignado);
        map.put("message", msg);
        return map;
    }
}
