/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Concepto;
import com.bruce.services.design.IConceptoService;
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
 * @author RICARDO
 */
@Controller
public class ConceptoContreller {

    @Autowired
    private IConceptoService serv;

    @ResponseBody
    @RequestMapping(value = "/conceptos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de concepto");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiConcepto", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Concepto concepto) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(concepto);
        map.put("success", true);
        map.put("data", concepto);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuConcepto", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Concepto concepto) {
        Map<String, Object> map = new HashMap<>();
        serv.update(concepto);
        map.put("success", true);
        map.put("data", concepto);
        map.put("message", "Actualización exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ccLConcepto", method = RequestMethod.POST)
    public Map<String, Object> copy(@RequestBody List<Concepto> conceptos) {
        Map<String, Object> map = new HashMap<>();
        serv.copy(conceptos);
        map.put("success", true);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddConcepto", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Concepto concepto) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(concepto);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", concepto);
        map.put("message", msg);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/validaNconcepto", method = RequestMethod.POST)
    public Map<String, Object> validaAdd(@RequestBody Concepto concepto) {
        return serv.validaAdd(concepto);
    }
}
