/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dto.hibernate.Usuario;
import dao.validator.hibernate.UsuarioValidator;
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

    @RequestMapping(value = "/validaAcceso", method = RequestMethod.POST)
    public String validaAcceso(@ModelAttribute("usuario") Usuario usuario, BindingResult result, ModelMap model) {
        String urlResult = "intranet/login";
        validator.validate(usuario, result);
        if (!result.hasErrors()) {
            SUsuario su = new SUsuario();
            if (su.validarUsuario(usuario.getUsu(), new String(usuario.getClave()))) {
                usuario = su.getUsuario();
                model.addAttribute("usuario", usuario);
                System.out.println("My avatar_: "+usuario.getTrabajador().getPersona().getAvatarB64());
                urlResult = "intranet/inicio";
            }
        }
        return urlResult;
    }
}
