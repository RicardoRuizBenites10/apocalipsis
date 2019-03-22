/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Planilla;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IPlanillaService extends IEntidadService<Planilla>{
    public void procesarPlanilla(List<Planilla> planillas);
    public byte[] reportCuadroPlanilla(int idPplanilla);
}
