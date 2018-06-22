package controller;

import dao.dto.hibernate.Trabajador;
import java.util.ArrayList;
import java.util.List;
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
public class TrabajadorController {
    
    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public String vistaEmpleados(){
        System.err.println("Entro a lista");
        return "rrhh/empleados";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody List<Trabajador> listaEmpleados(){
        List<Trabajador> list = new ArrayList<>();
        STrabajador st = new STrabajador();
        if(st.listarTrabajadores()) list = st.getLTrabajador();
        System.err.println("Entro a lista");
        return list;
    }
    
}
