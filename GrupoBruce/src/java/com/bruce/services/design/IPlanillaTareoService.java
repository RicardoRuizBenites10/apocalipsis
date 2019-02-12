/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.PlanillaTareo;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IPlanillaTareoService extends IEntidadService<PlanillaTareo>{
    public void procesarPTareo(List<PlanillaTareo> asistencias);
}
