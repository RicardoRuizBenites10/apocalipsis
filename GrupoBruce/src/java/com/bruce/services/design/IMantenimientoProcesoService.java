/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.MantenimientoProceso;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IMantenimientoProcesoService extends IEntidadService<MantenimientoProceso>{
    public List<MantenimientoProceso> getByFilter(int start, int limit, String sort, String filter, String query);
    public int countByFilter(String filter, String query);
    public MantenimientoProceso lastByFilter(List<FilterPage> filters);
}
