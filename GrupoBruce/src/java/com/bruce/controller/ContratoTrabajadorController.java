/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.ContratoTrabajador;
import com.bruce.services.design.IContratoTrabajadorService;
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
public class ContratoTrabajadorController {

    @Autowired
    private IContratoTrabajadorService sct;

    @ResponseBody
    @RequestMapping(value = "/contratos", method = RequestMethod.GET)
    public Map<String, Object> getByTrabajador(
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
    @RequestMapping(value = "/iiContrato", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody ContratoTrabajador contrato) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(contrato);
        map.put("success", true);
        map.put("data", contrato);
        map.put("message", "Actualización exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/uuContrato", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody ContratoTrabajador contrato) {
        Map<String, Object> map = new HashMap<>();
        sct.update(contrato);
        map.put("success", true);
        map.put("data", contrato);
        map.put("message", "Actualización exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/endContrato", method = RequestMethod.POST)
    public Map<String, Object> finalizar(@RequestBody ContratoTrabajador contrato) {
        Map<String, Object> map = new HashMap<>();
        sct.endContrato(contrato);
        map.put("success", true);
        map.put("data", contrato);
        map.put("message", "Finalizacion exitosa.");
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/validaRContrato", method = RequestMethod.POST)
    public Map<String, Object> last(@RequestBody ContratoTrabajador contrato) {
        return sct.validaAdd(contrato.getIdTrabajador());
    }
}
