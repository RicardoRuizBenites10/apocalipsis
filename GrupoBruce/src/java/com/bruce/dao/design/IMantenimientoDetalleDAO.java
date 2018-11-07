/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.MantenimientoDetalle;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IMantenimientoDetalleDAO extends IEntidadDAO<MantenimientoDetalle>{
    public List<MantenimientoDetalle> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public MantenimientoDetalle lastByFilter(List<FilterPage> filters);
}
