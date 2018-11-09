/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.EquipoInformatico;
import com.bruce.services.design.IEquipoInformaticoService;
import com.bruce.util.FilterPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EquipoInformaticoController {

    @Autowired
    private IEquipoInformaticoService sct;

    @ResponseBody
    @RequestMapping(value = "/equiposInformatico", method = RequestMethod.GET)
    public Map<String, Object> getByFilters() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", sct.getByFilter(0, 100, null));
        map.put("total", sct.countByFilter(null));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiEquipoInformatico", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody EquipoInformatico equipoInformatico) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(equipoInformatico);
        map.put("success", true);
        map.put("data", equipoInformatico);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuEquipoInformatico", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody EquipoInformatico equipoInformatico) {
        Map<String, Object> map = new HashMap<>();
        sct.update(equipoInformatico);
        map.put("success", true);
        map.put("data", equipoInformatico);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddEquipoInformatico", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody EquipoInformatico equipoInformatico) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            sct.delete(equipoInformatico);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", equipoInformatico);
        map.put("message", msg);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/generateSerie", method = RequestMethod.POST)
    public Map<String, Object> generateSerie(@RequestParam("tipo")String tipo) {

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("serie", sct.getSerie(tipo));
        map.put("message", "Validación exitosa.");
        
        return map;
    }

}
