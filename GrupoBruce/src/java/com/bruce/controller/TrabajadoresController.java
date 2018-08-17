package com.bruce.controller;

import com.bruce.dao.to.Trabajador;
import com.bruce.services.design.ITrabajadorService;
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
//@RequestMapping("rrhh")
public class TrabajadoresController {

    @Autowired
    private ITrabajadorService st;

//    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
//    public String vistaEmpleados() {
//        return "rrhh/empleados";
//    }
    @ResponseBody
    @RequestMapping(value = "/trabajadores", method = RequestMethod.GET)
    public Map<String, Object> getAllEmployes(@RequestParam int page, @RequestParam int start, @RequestParam int limit) {

        Map<String, Object> map = new HashMap<>();
        List<Trabajador> lista = st.findPagination(start, limit);

        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", st.totalCount());
        return map;

    }
}
