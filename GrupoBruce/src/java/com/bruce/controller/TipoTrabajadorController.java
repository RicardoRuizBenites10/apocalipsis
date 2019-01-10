/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.TipoTrabajador;
import com.bruce.services.design.ITipoTrabajadorService;
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
public class TipoTrabajadorController {
    
    @Autowired
    private ITipoTrabajadorService stt;
    
    @ResponseBody
    @RequestMapping(value="/tipoTrabajadorBySituacion", method = RequestMethod.GET)
    public Map<String, Object> getBySituacion(){
        Map<String, Object> map = new HashMap<>();
        List<TipoTrabajador> lista = stt.findBySituacion(true);
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiTipoTrabajador", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody TipoTrabajador tipoTrabajador) {
        Map<String, Object> map = new HashMap<>();
        stt.insert(tipoTrabajador);
        map.put("success", true);
        map.put("data", tipoTrabajador);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuTipoTrabajador", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody TipoTrabajador tipoTrabajador) {
        Map<String, Object> map = new HashMap<>();
        stt.update(tipoTrabajador);
        map.put("success", true);
        map.put("data", tipoTrabajador);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddTipoTrabajador", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody TipoTrabajador tipoTrabajador) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            stt.delete(tipoTrabajador);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", tipoTrabajador);
        map.put("message", msg);
        return map;
    }
    
}
