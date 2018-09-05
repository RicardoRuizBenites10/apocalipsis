/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Empresa;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IEmpresaService extends IEntidadService<Empresa>{
    public List<Empresa> findBySituacion(boolean situacion);
}
