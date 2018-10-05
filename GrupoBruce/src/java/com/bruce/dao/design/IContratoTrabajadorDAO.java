/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.ContratoTrabajador;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IContratoTrabajadorDAO extends IEntidadDAO<ContratoTrabajador>{
    public List<ContratoTrabajador> filterByTrabajador(int start, int limit, List<FilterPage> filters);
    public int getCountContratos(List<FilterPage> filters);
}
