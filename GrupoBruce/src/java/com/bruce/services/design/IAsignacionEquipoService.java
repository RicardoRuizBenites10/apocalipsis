/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.AsignacionEquipo;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IAsignacionEquipoService extends IEntidadService<AsignacionEquipo>{
    public List<AsignacionEquipo> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public AsignacionEquipo lastByFilter(List<FilterPage> filters);
}
