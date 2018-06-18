/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Usuario;

/**
 *
 * @author SISTEMAS
 */
public interface IUsuarioDAO extends IEntidadDAO<Usuario>{
    public Usuario valida(String usu, String pass);
}
