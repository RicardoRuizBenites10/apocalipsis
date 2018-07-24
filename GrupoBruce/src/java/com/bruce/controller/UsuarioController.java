/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Usuario;
import com.bruce.dao.validator.UsuarioValidator;
import com.bruce.services.design.IUsuarioService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author RICARDO
 */
@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService su;
    
    private final UsuarioValidator validator;

    public UsuarioController() {
        this.validator = new UsuarioValidator();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView accediendo() {
        return new ModelAndView("intranet/login", "usuario", new Usuario());
    }

//    @RequestMapping(value = "/validate", method = RequestMethod.POST)
//    public String validarUsuario(HttpServletRequest request, @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
//        String urlResult = "intranet/login";
//        validator.validate(usuario, result);
//        if (!result.hasErrors()) {
//            usuario = su.accesoUsuario(usuario.getUsu(), new String(usuario.getClave()));
//            if (usuario!=null) {
//                model.addAttribute("usuario", usuario);
//                //DECLARACIÓN DE SESIÓN
//                HttpSession sesion = request.getSession();
//                sesion.setAttribute("ssUsuario", usuario);
//                Date fs = new Date();
//                sesion.setAttribute("ssFechaHora", fs);
//                sesion.setMaxInactiveInterval(3 * 60);
//                urlResult = "redirect:inicio";
//            }
//        }
//        return urlResult;
//    }
    
    @ResponseBody
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public Map<String,Object> validarUsuario(Usuario usuario) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("Usuario: -----------------" + usuario.toString());
        Usuario logUsuario = su.accesoUsuario("46099060", "Nakamas123");
        System.out.println("Usuario 2: " + logUsuario.toString());
        if (usuario!=null) {
            System.out.println("Validando...");
//            //DECLARACIÓN DE SESIÓN
//            HttpSession sesion = request.getSession();
//            sesion.setAttribute("ssUsuario", usuario);
//            Date fs = new Date();
//            sesion.setAttribute("ssFechaHora", fs);
//            sesion.setMaxInactiveInterval(3 * 60);
            map.put("status", 200);
            map.put("message", "Datos encontrados");
            map.put("data", logUsuario);
        }else{
            System.err.println("Rechazado...");
            map.put("status", 400);
            map.put("message", "Datos no encontrados");
        }

        return map;
    }
    
    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String inicioUsuario() {
        return "intranet/inicio";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String salirUsuario(HttpServletRequest request) {
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("ssUsuario");
        sesion.invalidate();
        return "redirect:login";
    }
}
