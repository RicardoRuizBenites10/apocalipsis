/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Area;
import com.bruce.services.design.IAreaService;
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
public class AreaController {

    @Autowired
    private IAreaService sct;

    @ResponseBody
    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public Map<String, Object> getByFilters() {

        Map<String, Object> map = new HashMap<>();
        List<Area> lista = sct.getByFilter(0, 100, null);
        
        map.put("data", lista);
//        map.put("total", sct.countByFilter(null));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiArea", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        sct.insert(area);
        map.put("success", true);
        map.put("data", area);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuArea", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        sct.update(area);
        map.put("success", true);
        map.put("data", area);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddArea", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        sct.delete(area);
        map.put("success", true);
        map.put("data", area);
        map.put("message", "Eliminación exitosa");
        return map;
    }

}
