/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.TipoDocumento;
import com.bruce.dao.to.TipoEstudio;
import com.bruce.services.design.ITipoDocumentoService;
import com.bruce.services.design.ITipoEstudioService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class TipoEstudioController {

    @Autowired
    private ITipoEstudioService std;

    @ResponseBody
    @RequestMapping(value = "/tiposEstudio", method = RequestMethod.GET)
    public Map<String, Object> getByFilter(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam("filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        ObjectMapper mapper = new ObjectMapper();
        List<FilterPage> filters = new ArrayList<>();
        try {
            filters = mapper.readValue(filter, new TypeReference<List<FilterPage>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(TrabajadorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (query != null && !query.equalsIgnoreCase("")) {
            filters.add(new FilterPage("like", "descripcion", query));
        }
        Map<String, Object> map = new HashMap<>();
        List<TipoEstudio> lista = std.getByFilter(start, limit, filters);

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        return map;
    }
}
