/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import com.bruce.dao.to.Menu;
import com.bruce.util.FilterPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IMenuService extends IEntidadService<Menu>{
    public List<Menu> getByFilter(int start, int limit, String sort, String filter, String query);
    public int countByFilter(String filter, String query);
    public Menu lastByFilter(List<FilterPage> filters);
}
