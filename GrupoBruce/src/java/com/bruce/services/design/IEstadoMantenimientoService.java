/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EstadoMantenimiento;
import java.util.Map;

/**
 *
 * @author SISTEMAS
 */
public interface IEstadoMantenimientoService extends IEntidadService<EstadoMantenimiento>{
    public Map<String, Object> validaRelacion(EstadoMantenimiento estado);
}
