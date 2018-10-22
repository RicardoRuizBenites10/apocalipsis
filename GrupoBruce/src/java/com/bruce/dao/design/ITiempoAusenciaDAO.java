/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.TiempoAusencia;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITiempoAusenciaDAO extends IEntidadDAO<TiempoAusencia>{
    public List<TiempoAusencia> getBySituacion(boolean situacion);
}
