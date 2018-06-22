/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dto.hibernate.Usuario;
import dao.validator.hibernate.UsuarioValidator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.hibernate.SUsuario;

/**
 *
 * @author RICARDO
 */
@Controller
public class UsuarioController {

    private final UsuarioValidator validator;

    public UsuarioController() {
        this.validator = new UsuarioValidator();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView accediendo() {
        return new ModelAndView("intranet/login", "usuario", new Usuario());
    }

    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String inicioAP() {
        return "intranet/inicio";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validarUsuario(HttpServletRequest request, @ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        String urlResult = "intranet/login";
        validator.validate(usuario, result);
        if (!result.hasErrors()) {
            SUsuario su = new SUsuario();
            if (su.validarUsuario(usuario.getUsu(), new String(usuario.getClave()))) {
                usuario = su.getUsuario();
                model.addAttribute("usuario", usuario);

                //DECLARACIÓN DE SESIÓN
                HttpSession sesion = request.getSession();
                sesion.setAttribute("ssUsuario", usuario);
                Date fs = new Date();
                sesion.setAttribute("ssFechaHora", fs);
//                sesion.setMaxInactiveInterval(3 * 60);

                urlResult = "redirect:inicio.htm";
            }
        }
        return urlResult;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String salirUsuario(HttpServletRequest request) {
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("ssUsuario");
        sesion.invalidate();
        System.err.println("Cerrando sesión.");
        return "redirect:login.htm";
    }
}
