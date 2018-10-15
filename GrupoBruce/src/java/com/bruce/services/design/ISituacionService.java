/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Situacion;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ISituacionService extends IEntidadService<Situacion>{
    public Situacion last(String idTrabajador);
    public int countByFilter(List<FilterPage> filters);
}
