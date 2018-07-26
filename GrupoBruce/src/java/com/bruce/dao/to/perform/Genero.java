/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to.perform;

/**
 *
 * @author SISTEMAS
 */
public class Genero {
    private int idGenero;
    private String descripcion;

    public Genero(int idGenero, String descripcion) {
        this.idGenero = idGenero;
        this.descripcion = descripcion;
    }

    public Genero() {
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
