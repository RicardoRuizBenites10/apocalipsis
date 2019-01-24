/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Almuerzo;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IAlmuerzoService extends IEntidadService<Almuerzo>{
    public void procesarAlmuerzos(List<Almuerzo> almuerzos);
}
