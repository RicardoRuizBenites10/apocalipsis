/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Especificacion;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEspecificacionService extends IEntidadService<Especificacion>{
    public List<Especificacion> getByFilterSelects(int start, int limit, String sort, String filter, String query);
}
