/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Obra;

/**
 *
 * @author SISTEMAS
 */
public interface IObraService extends IEntidadService<Obra>{
    public Obra llObra(String idObrtip);
}
