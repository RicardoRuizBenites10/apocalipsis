/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.controller;

import com.bruce.dao.to.Usuario;
import com.bruce.dao.validator.UsuarioValidator;
import com.bruce.services.design.ITrabajadorService;
import com.bruce.services.design.IUsuarioService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author RICARDO
 */
@Controller
@SessionAttributes
public class UsuarioController {

    @Autowired
    private IUsuarioService su;
    @Autowired
    private ITrabajadorService st;

    private final UsuarioValidator validator;

    public UsuarioController() {
        this.validator = new UsuarioValidator();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView accediendo() {
//        return new ModelAndView("intranet/login", "usuario", new Usuario());
//    }
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
    public Map<String, Object> validarUsuario(@RequestBody Usuario usuario, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Usuario usu = su.accesoUsuario(usuario.getUsu(), usuario.getDeClave());
        if (usu != null) {
            
            //DECLARACIÓN DE SESIÓN
            HttpSession sesion = request.getSession();
            sesion.setAttribute("ssUsuario", usuario);
            Date fs = new Date();
            sesion.setAttribute("ssFechaHora", fs);
            sesion.setMaxInactiveInterval(3 * 60);
            
            map.put("success", true);
            map.put("message", "Usuario validado.");
            map.put("data", st.find(usu.getIdUsuario()));
        } else {
            map.put("success", false);
            map.put("message", "El usuario y/o contraseña no coinciden.");
        }
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/vvSession", method = RequestMethod.POST)
    public Map<String, Object> validarSession(@RequestBody Usuario usuario, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public Map<String, Object> getByFilters(
            @RequestParam("page") int page,
            @RequestParam("start") int start,
            @RequestParam("limit") int limit,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "filter") String filter,
            @RequestParam(required = false, value = "query") String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "Lista de áreas");
        map.put("data", su.getByFilter(start, limit, sort, filter, query));
        map.put("total", su.countByFilter(filter, query));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/iiUsuario", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Usuario usuario) {
        Map<String, Object> map = new HashMap<>();
        su.insert(usuario);
        map.put("success", true);
        map.put("data", usuario);
        map.put("message", "Registro exitoso.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uuUsuario", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Usuario usuario) {
        Map<String, Object> map = new HashMap<>();
        su.update(usuario);
        map.put("success", true);
        map.put("data", usuario);
        map.put("message", "Actualización exitosa.");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/ddUsuario", method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Usuario usuario) {
        Map<String, Object> map = new HashMap<>();
        boolean success = false;
        String msg = "Operacion exitosa";
        try {
            su.delete(usuario);
            success = true;
        } catch (Exception e) {
            msg = e.getMessage();
        }
        map.put("success", success);
        map.put("data", usuario);
        map.put("message", msg);
        return map;
    }
    

//    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
//    public String inicioUsuario() {
//        return "intranet/inicio";
//    }
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String salirUsuario(HttpServletRequest request) {
//        HttpSession sesion = request.getSession();
//        sesion.removeAttribute("ssUsuario");
//        sesion.invalidate();
//        return "redirect:login";
//    }
}
