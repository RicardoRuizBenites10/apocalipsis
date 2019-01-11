/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Empresa;
import com.bruce.services.design.IEmpresaService;
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
public class EmpresaController {

    @Autowired
    private IEmpresaService se;

    @ResponseBody
    @RequestMapping(value = "/empresaBySituacion", method = RequestMethod.GET)
    public Map<String, Object> getBySituacion(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        List<Empresa> lista = se.findBySituacion(true);

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEmpresa", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Empresa empresa) {
        Map<String, Object> map = new HashMap<>();
        se.insert(empresa);
        map.put("success", true);
        map.put("data", empresa);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEmpresa", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Empresa empresa) {
        Map<String, Object> map = new HashMap<>();
        se.update(empresa);
        map.put("success", true);
        map.put("data", empresa);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEmpresa", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Empresa empresa) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            se.delete(empresa);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", empresa);
        map.put("message", msg);
        return map;
    }

}
