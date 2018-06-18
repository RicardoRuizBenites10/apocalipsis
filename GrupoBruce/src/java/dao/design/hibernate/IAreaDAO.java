/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Area;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IAreaDAO extends IEntidadDAO<Area>{
    public List<Area> filterByNombre(String nombre);
    public List<Area> filterBySituacion(boolean situacion);
}
