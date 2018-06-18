/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Acceso;

/**
 *
 * @author SISTEMAS
 */
public interface IAccesoDAO extends IEntidadDAO<Acceso>{
    public Acceso filterByID(String idUsuario, int idMenu);
}
