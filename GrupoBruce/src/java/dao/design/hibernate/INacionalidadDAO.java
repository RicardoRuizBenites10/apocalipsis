/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Nacionalidad;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface INacionalidadDAO extends IEntidadDAO<Nacionalidad>{
    public List<Nacionalidad> filterBySituacion(boolean situacion);
}
