/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.EntidadFinanciera;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IEntidadFinancieraService extends IEntidadService<EntidadFinanciera> {
    public List<EntidadFinanciera> findBySituacion( boolean situacion);
}
