/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dto.hibernate.Dabadabadu;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value="/test")
public class PruebitaController {
    
    @RequestMapping(value="/testa", method = RequestMethod.GET)
    public ModelAndView prueba1(){
        return new ModelAndView("intranet/test");
    }
    
    @RequestMapping(value="/testa2", method = RequestMethod.GET)
    public @ResponseBody Dabadabadu prueba2(){
        return new Dabadabadu(10, "Amor propio");
    }
    
    @RequestMapping(value="/testa3", method = RequestMethod.GET)
    public ResponseEntity<Dabadabadu> getDabadabadu() {
        System.out.println("Ingreso a metodo json");
        Dabadabadu user = new Dabadabadu(10, "Amor propio");
        return new ResponseEntity<Dabadabadu>(user, HttpStatus.OK);
    }
    
}
