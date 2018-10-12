/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Hijo;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IHijoDAO extends IEntidadDAO<Hijo>{
    public List<Hijo> filterByPadre(int start, int limit, List<FilterPage> filters);
    public int countHijos(List<FilterPage> filters);
    public Hijo lastHijo(String idTrabajador);
}
