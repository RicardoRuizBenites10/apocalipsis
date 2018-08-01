/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to.perform;

import com.bruce.dao.to.Acceso;
import com.bruce.dao.to.Trabajador;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SISTEMAS
 */
public class Alibaba {
    
    private String idUsuario;
    private Trabajador trabajador;
    private String usu;
    private byte[] clave;
    private boolean estado;
    private boolean acceder;
    private Set<Acceso> accesos = new HashSet<Acceso>(0);

    private String deClave;

    public Alibaba() {
    }

    public Alibaba(String idUsuario, Trabajador trabajador, String usu, byte[] clave, boolean estado, boolean acceder, String deClave) {
        this.idUsuario = idUsuario;
        this.trabajador = trabajador;
        this.usu = usu;
        this.clave = clave;
        this.estado = estado;
        this.acceder = acceder;
        this.deClave = deClave;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public byte[] getClave() {
        return clave;
    }

    public void setClave(byte[] clave) {
        this.clave = clave;
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

    public Set<Acceso> getAccesos() {
        return accesos;
    }

    public void setAccesos(Set<Acceso> accesos) {
        this.accesos = accesos;
    }

    public String getDeClave() {
        return deClave;
    }

    public void setDeClave(String deClave) {
        this.deClave = deClave;
    }

}
