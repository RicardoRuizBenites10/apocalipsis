/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.design;

import com.bruce.util.FilterPage;
import com.bruce.util.SortPage;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEntidadDAO<T> {
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public T get(Object idT);
    public T lastByFilter(List<FilterPage> filters);
    public List<T> getAll();
    public List<T> getByFilter(int start, int limit, List<SortPage> sorts, List<FilterPage> filters);
    public int countByFilter(List<FilterPage> filters);
}
