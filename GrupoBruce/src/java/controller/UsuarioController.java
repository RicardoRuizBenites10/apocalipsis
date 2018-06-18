/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RICARDO
 */
@Controller
public class UsuarioController {
    
    @RequestMapping("login.htm")
    public ModelAndView accediendo(){
        ModelAndView mv = new ModelAndView("intranet/login");
        return mv;
    }
}
