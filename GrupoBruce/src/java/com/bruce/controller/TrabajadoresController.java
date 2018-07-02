package com.bruce.controller;

import com.bruce.dao.to.Alibaba;
import com.bruce.dao.to.Trabajador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bruce.services.STrabajador;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class TrabajadoresController {

    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public String vistaEmpleados() {
        return "rrhh/empleados";
    }

    @RequestMapping(value = "/trabajadores", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAllEmployes() {
        STrabajador st = new STrabajador();
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> mapita = st.listarTrabajadoresPerformance();
        List<Trabajador> list = st.listarTrabajadores() ? st.getLTrabajador() : new ArrayList<>();
        map.put("status", 200);
        map.put("message", "Datos encontrados");
        map.put("data", mapita);
        return map;
    }
}
