/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ContratoTrabajador;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
public interface IContratoTrabajadorService extends IEntidadService<ContratoTrabajador> {
    public Map<String, Object> validaAdd(String idTrabajador);
    public void endContrato(ContratoTrabajador contrato);
}
