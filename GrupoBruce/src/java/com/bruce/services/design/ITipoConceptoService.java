/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.TipoConcepto;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
public interface ITipoConceptoService extends IEntidadService<TipoConcepto>{
    public Map<String, Object>  validaAdd(String idTipo);
}
