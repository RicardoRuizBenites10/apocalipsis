/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Dabadabadu;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SISTEMAS
 */
@Controller
public class PruebitaController {
    
    @RequestMapping(value="/testa1", method = RequestMethod.GET)
    public ModelAndView prueba1(){
        return new ModelAndView("intranet/test");
    }
    
    @RequestMapping(value="/testa2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Dabadabadu prueba2(){
        return new Dabadabadu(10, "Factoria Bruce S.A.");
    }
    
}
