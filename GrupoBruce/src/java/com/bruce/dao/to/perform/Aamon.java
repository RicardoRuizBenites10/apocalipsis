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
    private String profecion;
    private int edad;
    private boolean estado;

    public Aamon(int codigo, String nombres, String profecion, int edad, boolean estado) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.profecion = profecion;
        this.edad = edad;
        this.estado = estado;
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

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
