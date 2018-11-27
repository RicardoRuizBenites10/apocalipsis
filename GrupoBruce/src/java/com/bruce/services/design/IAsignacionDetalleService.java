/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.AsignacionDetalle;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IAsignacionDetalleService extends IEntidadService<AsignacionDetalle>{
    public List<AsignacionDetalle> getByFilter(int start, int limit, String sort, String filter, String query);
    public int countByFilter(String filter, String query);
    public AsignacionDetalle lastByFilter(List<FilterPage> filters);
    public boolean validaREquipoAsignacion(AsignacionDetalle asignacionDetalle);
}
