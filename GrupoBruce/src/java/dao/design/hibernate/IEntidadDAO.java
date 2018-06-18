/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design.hibernate;

import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IEntidadDAO<T> {
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public T find(Object idT);
    public List<T> findAll();
}
