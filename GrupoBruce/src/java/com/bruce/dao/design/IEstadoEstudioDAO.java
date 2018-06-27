/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.EstadoEstudio;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEstadoEstudioDAO extends IEntidadDAO<EstadoEstudio>{
    public List<EstadoEstudio> filterBySituacion(boolean situacion);
}
