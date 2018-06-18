/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.Periodo;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IPeriodoDAO extends IEntidadDAO<Periodo>{
    public List<Periodo> filterBySituacion(boolean situacion);
    public List<Periodo> filterByTipo(int id_tperiodo);
}
