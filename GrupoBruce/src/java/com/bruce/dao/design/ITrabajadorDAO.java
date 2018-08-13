/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Trabajador;
import com.bruce.dao.to.perform.TrabajadorDTO;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ITrabajadorDAO extends IEntidadDAO<Trabajador>{
    public List<TrabajadorDTO> getAllPerforms();
    public List<Trabajador> getTrabajadorsPagination(int start, int limit);
    public int getTrabajadorCount();
}
