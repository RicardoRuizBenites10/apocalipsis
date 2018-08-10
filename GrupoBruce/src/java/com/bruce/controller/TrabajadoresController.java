package com.bruce.controller;

import com.bruce.dao.to.Trabajador;
import com.bruce.dao.to.perform.Aamon;
import com.bruce.dao.to.perform.TrabajadorDTO;
import com.bruce.services.design.ITrabajadorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Map<String, Object> getAllEmployes() {
        Map<String, Object> map = new HashMap<>();
        List<Trabajador> list = st.findAll();
//        List<Aamon> list = new ArrayList<>();
//        list.add(new Aamon(10, "Oscar", "Sistemas"));
//        list.add(new Aamon(20, "Yeghor", "Industrial"));
//        list.add(new Aamon(30, "Sheyimi", "Docente"));
//        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", list);

        return map;
    }
}
