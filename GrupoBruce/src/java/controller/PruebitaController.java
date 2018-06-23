/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SISTEMAS
 */
@Controller
@RequestMapping(value="/test")
public class PruebitaController {
    
    @RequestMapping(value="/testa", method = RequestMethod.GET)
    public ModelAndView prueba1(){
        return new ModelAndView("intranet/test");
    }
    
}
