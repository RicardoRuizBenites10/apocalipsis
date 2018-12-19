/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Acceso;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IAccesoService extends IEntidadService<Acceso>{
    public List<Acceso> getByRol(String filter);
    public void changeAcceso(List<Acceso> accesos);
}
