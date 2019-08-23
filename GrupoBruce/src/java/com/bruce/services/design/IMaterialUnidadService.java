/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.MaterialUnidad;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IMaterialUnidadService extends IEntidadService<MaterialUnidad> {

    public void changeMaterialUnidad(List<MaterialUnidad> mu);
    
}
