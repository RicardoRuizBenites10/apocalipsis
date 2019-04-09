/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Concepto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
public interface IConceptoService extends IEntidadService<Concepto>{
    public Map<String, Object> validaAdd(Concepto concepto);
    public void copy(List<Concepto> conceptos);
}
