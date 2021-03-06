/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EquipoInformatico;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
public interface IEquipoInformaticoService extends IEntidadService<EquipoInformatico> {
    public List<EquipoInformatico> getByPorAsignar(int start, int limit, String sort, String filter, String query);
    public String getSerie(String tipo);
    public Map<String, Object> validaRelacion(EquipoInformatico equipo);
}
