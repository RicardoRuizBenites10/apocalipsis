/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.TipoMantenimiento;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITipoMantenimientoService extends IEntidadService<TipoMantenimiento>{
    public List<TipoMantenimiento> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public TipoMantenimiento lastByFilter(List<FilterPage> filters);
}
