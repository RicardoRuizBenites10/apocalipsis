/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EstadoEstudio;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IEstadoEstudioService extends IEntidadService<EstadoEstudio>{
    public List<EstadoEstudio> getBySituacion(boolean situacion);
}
