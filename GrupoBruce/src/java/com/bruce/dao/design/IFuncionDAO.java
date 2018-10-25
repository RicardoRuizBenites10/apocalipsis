/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Funcion;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IFuncionDAO extends IEntidadDAO<Funcion>{
    public List<Funcion> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public Funcion lastByFilter(List<FilterPage> filters);
}
