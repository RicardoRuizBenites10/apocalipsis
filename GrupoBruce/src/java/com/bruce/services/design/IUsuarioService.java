/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Usuario;

/**
 *
 * @author RICARDO
 */
public interface IUsuarioService extends IEntidadService<Usuario>{
    public Usuario accesoUsuario(String usu, String pass);
}
