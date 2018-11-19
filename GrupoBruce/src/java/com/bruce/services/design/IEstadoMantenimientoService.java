/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EstadoMantenimiento;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEstadoMantenimientoService extends IEntidadService<EstadoMantenimiento>{
    public List<EstadoMantenimiento> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public EstadoMantenimiento lastByFilter(List<FilterPage> filters);
}
