/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.validator;

import com.bruce.dao.to.Usuario;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author SISTEMAS
 */
public class UsuarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Usuario.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuario usuario = (Usuario) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usu", "required.usu", "Usuario es necesario.");
        if (new String(usuario.getClave()).equalsIgnoreCase("")) {
            errors.rejectValue("clave", "clave.incorrect", "Clave es necesaria.");
        }
    }
}
