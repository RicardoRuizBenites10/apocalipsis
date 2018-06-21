/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author SISTEMAS
 */

@Controller
public class TrabajadorController {
    
    @RequestMapping(value = "/empleados", method = RequestMethod.GET)
    public String empleado(){
        return "rrhh/empleados";
    }
    
}
