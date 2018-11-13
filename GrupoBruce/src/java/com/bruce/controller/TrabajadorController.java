package com.bruce.controller;

import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import com.bruce.services.design.ITrabajadorService;
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
 * @author SISTEMAS
 */
@Controller
//@RequestMapping("rrhh")
public class TrabajadorController {

    @Autowired
    private ITrabajadorService st;

//    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
//    public String vistaEmpleados() {
//        return "rrhh/empleados";
//    }
    @ResponseBody
    @RequestMapping(value = "/trabajadors", method = RequestMethod.GET)
    public Map<String, Object> getAllEmployes(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {

        Map<String, Object> map = new HashMap<>();
        List<Trabajador> lista = st.findPagination(start, limit, sort, filter, query);

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", st.countByFilter(filter));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateTrabajador", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Trabajador trabajador) {
        Map<String, Object> map = new HashMap<>();
        st.update(trabajador);
        map.put("success", true);
        map.put("data", trabajador);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/insertTrabajador", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Trabajador trabajador) {
        Map<String, Object> map = new HashMap<>();
        st.insert(trabajador);
        map.put("success", true);
        map.put("data", trabajador);
        map.put("message", "Actualización exitosa.");
        return map;
    }
}
