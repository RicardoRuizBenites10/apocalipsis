/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.PeriodoVacacion;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IPeriodoVacacionService extends IEntidadService<PeriodoVacacion>{
    public List<PeriodoVacacion> getBySituacion(boolean situacion);
}
