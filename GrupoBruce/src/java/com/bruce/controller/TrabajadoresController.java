package com.bruce.controller;

import com.bruce.dao.to.Trabajador;
import com.bruce.dao.to.perform.Aamon;
import com.bruce.services.design.ITrabajadorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
//        List<Trabajador> lista = st.findPagination(start, limit);
        
        List<Aamon> lista = new ArrayList<>();
        lista.add(new Aamon(1, "Ricardo ruiz", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(2, "Ramon ruiz", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(3, "Pedro ruiz", "Ingeniero de sistemas", 18, true));
        lista.add(new Aamon(4, "Anastacia", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(5, "Ricardo ruiz", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(6, "Dayana", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(7, "Yeghor", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(8, "Jojolete", "Ingeniero de sistemas", 15, true));
        lista.add(new Aamon(9, "Caramandunga", "Ingeniero de sistemas", 28, true));
        lista.add(new Aamon(10, "Brtuce", "Ingeniero de sistemas", 28, true));
        
        map.put("success", true);
        map.put("message", "Datos encontrados");
        map.put("data", lista);
        map.put("total", 10);
        return map;
        
    }
}
