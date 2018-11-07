/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EstadoEquipo;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IEstadoEquipoService extends IEntidadService<EstadoEquipo>{
    public List<EstadoEquipo> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public EstadoEquipo lastByFilter(List<FilterPage> filters);
}
