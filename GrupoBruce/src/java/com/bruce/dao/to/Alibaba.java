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
    private String usu;
    private String clave;

    public Alibaba() {
    }

    public Alibaba(String usu, String clave) {
        this.usu = usu;
        this.clave = clave;
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

    @Override
    public String toString() {
        return "Alibaba{" + "usu=" + usu + ", clave=" + clave + '}';
    }
    
}
