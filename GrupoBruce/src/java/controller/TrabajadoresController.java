package controller;

import dao.dto.hibernate.Trabajador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import services.hibernate.STrabajador;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class TrabajadoresController {

    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public String vistaEmpleados() {
        System.err.println("Entro a TrabajadoresController");
        return "rrhh/empleados";
    }

    @RequestMapping(value = "/trabajadores", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAllEmployes() {
        System.out.println("getAllEmployes de TrabajadoresController:");
        STrabajador st = new STrabajador();
        Map<String, Object> map = new HashMap<>();
        List<Trabajador> list = st.listarTrabajadores() ? st.getLTrabajador() : new ArrayList<>();
        map.put("status", 200);
        map.put("message", "Datos encontrados");
        map.put("data", list);
        System.err.println("Entro a lista y contiene " +list.size()+ " datos");
        return map;
    }
}
