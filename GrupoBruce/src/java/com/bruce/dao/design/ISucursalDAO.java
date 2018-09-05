/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Sucursal;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ISucursalDAO extends IEntidadDAO<Sucursal>{
    public List<Sucursal> filterBySituacion(boolean situacion);
    public List<Sucursal> filterByEmpresa(String idEmpresa);
}
