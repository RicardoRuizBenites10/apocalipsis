/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Genero;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IGeneroService extends IEntidadService<Genero> {
    public List<Genero> findBySituacion(boolean situacion);
}
