/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.PeriodoVacacion;
import com.bruce.services.design.IPeriodoVacacionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author RICARDO
 */
@Controller
public class PeriodoVacacionController {
    
    @Autowired
    private IPeriodoVacacionService serv;
    
    @ResponseBody
    @RequestMapping(value="/periodosVacacion", method = RequestMethod.GET)
    public Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<PeriodoVacacion> lista = serv.getBySituacion(true);
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value="/insertPeriodoVacacion", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody PeriodoVacacion pvacacion){
        Map<String, Object> map = new HashMap<>();
        String msg = "Operación exitosa.";
        serv.insert(pvacacion);
        map.put("success", true);
        map.put("message", msg);
        map.put("data", pvacacion);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value="/updatePeriodoVacacion", method = RequestMethod.POST)
    public Map<String, Object> edit(@RequestBody PeriodoVacacion pvacacion){
        Map<String, Object> map = new HashMap<>();
        String msg = "Operación exitosa.";
        serv.update(pvacacion);
        map.put("success", true);
        map.put("message", msg);
        map.put("data", pvacacion);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value="/deletePeriodoVacacion", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody PeriodoVacacion pvacacion){
        Map<String, Object> map = new HashMap<>();
        serv.delete(pvacacion);
        map.put("success", true);
        map.put("message", "Operación exitosa.");
        map.put("data", pvacacion);
        return map;
    }
    
}