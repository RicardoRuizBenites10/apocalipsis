/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Trabajador;
import com.bruce.dao.to.perform.TrabajadorDTO;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITrabajadorService extends IEntidadService<Trabajador>{
    public List<TrabajadorDTO> findAllPerform();
    public List<Trabajador> findPagination(int page, int limit);
}
