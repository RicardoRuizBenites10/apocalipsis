/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.TipoFormacion;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITipoFormacionService extends IEntidadService<TipoFormacion>{
    public List<TipoFormacion> getBySituacion(boolean situacion);
}
