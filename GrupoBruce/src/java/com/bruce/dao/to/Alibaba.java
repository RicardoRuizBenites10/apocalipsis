/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

/**
 *
 * @author SISTEMAS
 */
public class Alibaba {
    private String idUsuario;
    private String usu;
    private String clave;
    private boolean acceder;
    private String accesos;
    private boolean estado;
    private String trabajador;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isAcceder() {
        return acceder;
    }

    public void setAcceder(boolean acceder) {
        this.acceder = acceder;
    }

    public String getAccesos() {
        return accesos;
    }

    public void setAccesos(String accesos) {
        this.accesos = accesos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public Alibaba(String idUsuario, String usu, String clave, boolean acceder, String accesos, boolean estado, String trabajador) {
        this.idUsuario = idUsuario;
        this.usu = usu;
        this.clave = clave;
        this.acceder = acceder;
        this.accesos = accesos;
        this.estado = estado;
        this.trabajador = trabajador;
    }

    public Alibaba() {
    }
}
