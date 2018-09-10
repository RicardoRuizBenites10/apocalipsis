/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface ITrabajadorService extends IEntidadService<Trabajador>{
    public List<Trabajador> findPagination(int start, int limit, List<SortPage> sorts);
    public int  totalCount();
}
