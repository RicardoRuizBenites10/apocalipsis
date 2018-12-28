/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Usuario;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
public interface IUsuarioService extends IEntidadService<Usuario>{
    public Usuario accesoUsuario(Usuario usuario);
    public Map<String,Object> validaNUsuario(Usuario usuario);
}
