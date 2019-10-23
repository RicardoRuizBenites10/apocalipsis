/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EspecificacionActividad;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEspecificacionActividadService extends IEntidadService<EspecificacionActividad>{
    public void changeLEspecificacionActividad(List<EspecificacionActividad> ea);
    public void deleteLEspecificacionActividad(List<EspecificacionActividad> ea);
}
