/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Comisionrp;
import com.bruce.services.design.IComisionrpService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class ComisionrpController {
    
    @Autowired
    private IComisionrpService se;
    
    @ResponseBody
    @RequestMapping(value="/comisionrpByRPensionario", method = RequestMethod.GET)
    public Map<String, Object> getByRPensionario(@RequestParam("idRPensionario") String idRPensionario){
        Map<String, Object> map = new HashMap<>();
        List<Comisionrp> lista = se.findByRPensionario(idRPensionario);
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value="/comisionrpAll", method = RequestMethod.GET)
    public Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap<>();
        List<Comisionrp> lista = se.findAll();
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }
    
}
