/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Especificacion;
import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEspecificacionDAO extends IEntidadDAO<Especificacion>{
    public List<Especificacion> getByFilterSelects(int start, int limit, List<SortPage> sorts, List<FilterPage> filters);
}
