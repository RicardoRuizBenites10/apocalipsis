/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Empresa;
import com.bruce.dao.to.EstadoTrabajador;
import com.bruce.services.design.IEmpresaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value="/empresaBySituacion", method = RequestMethod.GET)
    public Map<String, Object> getBySituacion(){
        Map<String, Object> map = new HashMap<>();
        List<Empresa> lista = se.findBySituacion(true);
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }
    
}
