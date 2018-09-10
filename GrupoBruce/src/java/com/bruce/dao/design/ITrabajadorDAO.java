/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.Trabajador;
import com.bruce.util.SortPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ITrabajadorDAO extends IEntidadDAO<Trabajador>{
    public List<Trabajador> getTrabajadorsPagination(int start, int limit, List<SortPage> sorts);
    public int getTrabajadorCount();
}
