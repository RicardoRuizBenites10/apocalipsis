/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.TipoAusencia;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITipoAusenciaService  extends IEntidadService<TipoAusencia>{
    public List<TipoAusencia> getBySituacion(boolean situacion);
    
}
