/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Usuario;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IUsuarioDAO extends IEntidadDAO<Usuario>{
    public Usuario valida(List<FilterPage> filters);
}
