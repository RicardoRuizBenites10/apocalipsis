/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.TipoEquipo;
import com.bruce.services.design.ITipoEquipoService;
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
public class TipoEquipoController {

    @Autowired
    private ITipoEquipoService sct;

    @ResponseBody
    @RequestMapping(value = "/tiposEquipo", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", sct.getByFilter(start, limit, sort, filter, query));
        map.put("total", sct.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiTipoEquipo", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody TipoEquipo tipoEquipo) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(tipoEquipo);
        map.put("success", true);
        map.put("data", tipoEquipo);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuTipoEquipo", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody TipoEquipo tipoEquipo) {
        Map<String, Object> map = new HashMap<>();
        sct.update(tipoEquipo);
        map.put("success", true);
        map.put("data", tipoEquipo);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddTipoEquipo", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody TipoEquipo tipoEquipo) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(tipoEquipo);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", tipoEquipo);
        map.put("message", msg);
        return map;
    }

}
