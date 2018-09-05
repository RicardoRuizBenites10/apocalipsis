/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.RegimenPensionario;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IRegimenPensionarioService extends IEntidadService<RegimenPensionario> {
    public List<RegimenPensionario> findBySituacion(boolean situacion);
}
