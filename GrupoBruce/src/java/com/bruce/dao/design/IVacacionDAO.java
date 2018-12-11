/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Vacacion;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IVacacionDAO extends IEntidadDAO<Vacacion>{    
    public List<Vacacion> filterYAByPeriodo(int idPeriodo);
    public List<Vacacion> filterNAByPeriodo(int idPeriodo);
}
