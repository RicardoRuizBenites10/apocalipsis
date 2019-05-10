/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Carroceria;
import com.bruce.services.design.ICarroceriaService;
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
public class CarroceriaController {

    @Autowired
    private ICarroceriaService serv;

    @ResponseBody
    @RequestMapping(value = "/carrocerias", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de carroceria");
        map.put("data", serv.getByFilter(start, limit, sort, filter, query));
        map.put("total", serv.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/carroceriaLast", method = RequestMethod.POST)
    public Map<String, Object> getByLastFilters(
            @RequestParam("ID_CARMOD") String idCarmod,
            @RequestParam("ID_CARTIP") String idCartip,
            @RequestParam("ID_CARFAL") String idCarfal) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de carroceria");
        map.put("data", serv.generateCode(idCarmod, idCartip, idCarfal));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiCarroceria", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Carroceria carroceria) {
        Map<String, Object> map = new HashMap<>();
        serv.insert(carroceria);
        map.put("success", true);
        map.put("data", carroceria);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuCarroceria", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Carroceria carroceria) {
        Map<String, Object> map = new HashMap<>();
        serv.update(carroceria);
        map.put("success", true);
        map.put("data", carroceria);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddCarroceria", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Carroceria carroceria) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            serv.delete(carroceria);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", carroceria);
        map.put("message", msg);
        return map;
    }

}
