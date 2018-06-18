/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.hibernate;

import dao.dto.hibernate.Usuario;
import factory.hibernate.FactoryDAO;

/**
 *
 * @author SISTEMAS
 */
public class SUsuario {

    private Usuario usuario;

    public SUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean validarUsuario(String usu, String pass) {
        usuario = FactoryDAO.getInstance().getUsuarioDAO().valida(usu, pass);
        return (usuario != null);
    }
    
}
