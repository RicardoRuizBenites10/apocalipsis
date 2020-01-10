/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ColorDiseno;
import com.bruce.services.design.IColorDisenoService;
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
public class ColorDisenoController {
    
    @Autowired
    private IColorDisenoService serv;

    @ResponseBody
    @RequestMapping(value = "/colorDisenos", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam(required = false, value = "page") Integer page,
            @RequestParam(required = false, value = "start") Integer start,
            @RequestParam(required = false, value = "limit") Integer limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de colores");
        map.put("data", serv.getByFilter(0, 1000, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiColorDiseno", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ColorDiseno colorDiseno) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(colorDiseno);
        map.put("success", true);
        map.put("data", colorDiseno);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuColorDiseno", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ColorDiseno colorDiseno) {
        Map<String, Object> map = new HashMap<>();
        serv.update(colorDiseno);
        map.put("success", true);
        map.put("data", colorDiseno);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddColorDiseno", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody ColorDiseno colorDiseno) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(colorDiseno);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", colorDiseno);
        map.put("message", msg);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/llColorDiseno", method = RequestMethod.POST)
    public Map<String, Object> last(
            @RequestParam(required = false, value = "property") String property,
            @RequestParam(required = false, value = "operator") String operator,
            @RequestParam(required = false, value = "value") Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", serv.llColorDiseno(property, operator, value));
        map.put("message", "Actualización exitosa.");
        return map;
    }
}
