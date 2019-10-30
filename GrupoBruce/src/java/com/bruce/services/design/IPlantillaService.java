/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Plantilla;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IPlantillaService extends IEntidadService<Plantilla>{
    public void changeLPlantilla(List<Plantilla> plantillas, String categorias, String idCarroceria, String idUsuario);
}
