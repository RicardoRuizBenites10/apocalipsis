/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EquipoInformatico;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IEquipoInformaticoService extends IEntidadService<EquipoInformatico> {

    public List<EquipoInformatico> getByFilter(int start, int limit, List<FilterPage> filters);

    public int countByFilter(List<FilterPage> filters);

    public List<EquipoInformatico> getByPorAsignar(int start, int limit, List<FilterPage> filters);

    public EquipoInformatico lastByFilter(List<FilterPage> filters);

    public String getSerie(String tipo);
}
