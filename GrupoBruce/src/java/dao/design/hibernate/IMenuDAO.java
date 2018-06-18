/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Menu;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IMenuDAO extends IEntidadDAO<Menu>{
    public List<Menu> filterBySituacion(boolean situacion);
}
