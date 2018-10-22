/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.TipoAusencia;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITipoAusenciaDAO extends IEntidadDAO<TipoAusencia>{
    public List<TipoAusencia> getBySituacion(boolean situacion);
}
