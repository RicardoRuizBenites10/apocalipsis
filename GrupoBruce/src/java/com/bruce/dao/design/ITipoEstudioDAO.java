/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.dao.to.TipoEstudio;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ITipoEstudioDAO extends IEntidadDAO<TipoEstudio>{
    public List<TipoEstudio> getByFilter(int start, int limit, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
    public TipoEstudio lastByFilter(List<FilterPage> filters);
}
