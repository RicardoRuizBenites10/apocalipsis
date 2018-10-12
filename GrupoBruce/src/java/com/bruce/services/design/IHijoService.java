/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Hijo;
import com.bruce.util.FilterPage;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RICARDO
 */
public interface IHijoService extends IEntidadService<Hijo>{
    public List<Hijo> getByFilter (int start, int limit, List<FilterPage> filters);
    public int countFilter(List<FilterPage> filters);
    public Map<String, Object> last(String idTrabajador);
}
