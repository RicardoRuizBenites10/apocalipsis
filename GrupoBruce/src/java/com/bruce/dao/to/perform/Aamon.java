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
public class Aamon {
    private int codigo;
    private String nombres;
    private String carrera;

    public Aamon() {
    }

    public Aamon(int codigo, String nombres, String carrera) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.carrera = carrera;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
