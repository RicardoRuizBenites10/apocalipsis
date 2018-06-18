/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Subarea;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ISubareaDAO extends IEntidadDAO<Subarea>{
    public List<Subarea> filterByArea(int idArea);
    public List<Subarea> filterBySituacion(boolean situacion);
}
