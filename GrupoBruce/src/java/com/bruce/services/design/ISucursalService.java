/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Sucursal;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ISucursalService extends IEntidadService<Sucursal>{
    public List<Sucursal> findByEmpresa(String idEmpresa);
}
