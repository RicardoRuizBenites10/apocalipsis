/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.PeriodoPlanilla;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IPeriodoPlanillaDAO extends IEntidadDAO<PeriodoPlanilla>{
    public List<PeriodoPlanilla> filterBySituacion(boolean situacion);
    public List<PeriodoPlanilla> filterByTipo(int id_tperiodo);
}
