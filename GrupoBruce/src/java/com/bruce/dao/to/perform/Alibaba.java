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
public class Alibaba {
    
    private int idUsuario;
    private Genero genero;
    private String usu;
    private byte[] diClave;
    private boolean estado;
    private boolean acceder;
    
    private String clave;

    public Alibaba() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public byte[] getDiClave() {
        return diClave;
    }

    public void setDiClave(byte[] diClave) {
        this.diClave = diClave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isAcceder() {
        return acceder;
    }

    public void setAcceder(boolean acceder) {
        this.acceder = acceder;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Alibaba{" + "idUsuario=" + idUsuario + ", genero=" + genero + ", usu=" + usu + ", clave=" + clave + ", estado=" + estado + ", acceder=" + acceder + '}';
    }
}
