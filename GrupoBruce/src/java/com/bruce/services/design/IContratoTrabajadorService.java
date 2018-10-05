/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ContratoTrabajador;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IContratoTrabajadorService extends IEntidadService<ContratoTrabajador>{
    public List<ContratoTrabajador> findByTrabajador(int start, int limit, List<FilterPage> filters);
    public int totalCount(List<FilterPage> filters);
}
