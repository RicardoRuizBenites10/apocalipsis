package com.bruce.controller;

import com.bruce.dao.to.perform.TrabajadorDTO;
import com.bruce.services.design.ITrabajadorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SISTEMAS
 */
@Controller
@RequestMapping("rrhh")
public class TrabajadoresController {

    @Autowired
    private ITrabajadorService st;

    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public String vistaEmpleados() {
        return "rrhh/empleados";
    }

    @ResponseBody
    @RequestMapping(value = "/trabajadores", method = RequestMethod.POST)
    public Map<String, Object> getAllEmployes() {
        Map<String, Object> map = new HashMap<>();
        List<TrabajadorDTO> list = st.findAllPerform();
        map.put("status", 200);
        map.put("message", "Datos encontrados");
        map.put("data", list);
        return map;
    }
}
