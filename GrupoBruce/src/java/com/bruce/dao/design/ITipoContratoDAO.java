/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.TipoContrato;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITipoContratoDAO extends IEntidadDAO<TipoContrato>{
    public List<TipoContrato> filterBySituacion(boolean situacion);
}
