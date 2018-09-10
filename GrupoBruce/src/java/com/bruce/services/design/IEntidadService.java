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
    public T find(Object id);
    public List<T> findAll();
}
