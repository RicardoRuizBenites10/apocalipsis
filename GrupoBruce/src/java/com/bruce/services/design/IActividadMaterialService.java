/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.ActividadMaterial;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IActividadMaterialService extends IEntidadService<ActividadMaterial>{
    public void changeLActividadMaterial(List<ActividadMaterial> am);
    public void deleteLActividadMaterial(List<ActividadMaterial> am);
}
