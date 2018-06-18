/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dto.hibernate.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView accediendo() {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("intranet/login");
//        mv.addObject("usuario", new Usuario());
        return new ModelAndView("intranet/login", "usuario", new Usuario());
    }
    
    @RequestMapping(value="/validaAcceso", method = RequestMethod.POST)
    public String validaAcceso(@ModelAttribute("usuario")Usuario usuario, ModelMap model){
        String urlResult = "intranet/login";
        SUsuario su = new SUsuario();
        if(su.validarUsuario(usuario.getUsu(), new String(usuario.getClave()))){
            usuario = su.getUsuario();
            model.addAttribute("usuario", usuario);
            urlResult = "intranet/result";
        }        
        return urlResult;
    }
}
