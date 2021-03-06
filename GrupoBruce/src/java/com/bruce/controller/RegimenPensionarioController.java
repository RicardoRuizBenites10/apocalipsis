/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Ecivil;
import com.bruce.dao.to.RegimenPensionario;
import com.bruce.dao.to.RegimenPensionario;
import com.bruce.services.design.IECivilService;
import com.bruce.services.design.IRegimenPensionarioService;
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
public class RegimenPensionarioController {
    
    @Autowired
    private IRegimenPensionarioService srp;
    
    @ResponseBody
    @RequestMapping(value="/regimenPensionarioBySituacion", method = RequestMethod.GET)
    public Map<String, Object> getBySituacion(){
        Map<String, Object> map = new HashMap<>();
        List<RegimenPensionario> lista = srp.findBySituacion(true);
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiRegimenPensionario", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody RegimenPensionario regimenPensionario) {
        Map<String, Object> map = new HashMap<>();
        srp.insert(regimenPensionario);
        map.put("success", true);
        map.put("data", regimenPensionario);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuRegimenPensionario", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody RegimenPensionario regimenPensionario) {
        Map<String, Object> map = new HashMap<>();
        srp.update(regimenPensionario);
        map.put("success", true);
        map.put("data", regimenPensionario);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddRegimenPensionario", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody RegimenPensionario regimenPensionario) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            srp.delete(regimenPensionario);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", regimenPensionario);
        map.put("message", msg);
        return map;
    }
    
}
