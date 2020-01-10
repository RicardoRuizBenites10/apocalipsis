/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ColorFormula;
import com.bruce.services.design.IColorFormulaService;
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
public class ColorFormulaController {
    
    @Autowired
    private IColorFormulaService serv;

    @ResponseBody
    @RequestMapping(value = "/colorFormulas", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de fórmulas");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiColorFormula", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ColorFormula colorFormula) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(colorFormula);
        map.put("success", true);
        map.put("data", colorFormula);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiLColorFormula", method = RequestMethod.POST)
    public Map<String, Object> insertL(@RequestBody List<ColorFormula> colorFormula) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLColorFormula(colorFormula);
        map.put("success", true);
        map.put("data", colorFormula);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuColorFormula", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ColorFormula colorFormula) {
        Map<String, Object> map = new HashMap<>();
        serv.update(colorFormula);
        map.put("success", true);
        map.put("data", colorFormula);
        map.put("message", "Actualización exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/uuLColorFormula", method = RequestMethod.POST)
    public Map<String, Object> updateL(@RequestBody List<ColorFormula> colorFormula) {
        Map<String, Object> map = new HashMap<>();
        serv.changeLColorFormula(colorFormula);
        map.put("success", true);
        map.put("data", colorFormula);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddColorFormula", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ColorFormula colorFormula) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(colorFormula);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", colorFormula);
        map.put("message", msg);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddLColorFormula", method = RequestMethod.POST)
    public Map<String, Object> deleteL(@RequestBody List<ColorFormula> colorFormula) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.deleteLColorFormula(colorFormula);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", colorFormula);
        map.put("message", msg);
        return map;
    }
}
