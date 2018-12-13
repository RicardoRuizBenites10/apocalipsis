/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.AsignacionDetalle;

/**
 *
 * @author RICARDO
 */
public interface IAsignacionDetalleService extends IEntidadService<AsignacionDetalle>{
    public boolean validaREquipoAsignacion(AsignacionDetalle asignacionDetalle);
}
