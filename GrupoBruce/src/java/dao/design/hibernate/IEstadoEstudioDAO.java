/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import dao.dto.hibernate.EstadoEstudio;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEstadoEstudioDAO extends IEntidadDAO<EstadoEstudio>{
    public List<EstadoEstudio> filterBySituacion(boolean situacion);
}
