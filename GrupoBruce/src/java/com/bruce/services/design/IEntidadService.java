/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.services.design;

import java.util.List;

/**
 *
 * @author RICARDO
 */
public interface IEntidadService<T> {
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
    public int  countByFilter(String filter, String query);
    public T find(Object id);
    public T lastByFilter(String filter, String query);
    public List<T> findAll();
    public List<T> getByFilter(int start, int limit, String sort, String filter, String query);
}
