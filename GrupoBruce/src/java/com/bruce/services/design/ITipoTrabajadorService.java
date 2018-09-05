/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.TipoTrabajador;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITipoTrabajadorService extends IEntidadService<TipoTrabajador> {
    public List<TipoTrabajador> findBySituacion(boolean situacion);
}
