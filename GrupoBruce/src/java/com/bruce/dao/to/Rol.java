/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ROL", schema = "dbo", catalog = "BDBRUCE")
public class Rol implements java.io.Serializable {

    private String idRol;
    private String denominacion;
    private boolean situacion;

    public Rol() {
    }

    public Rol(String idRol, String denominacion, boolean situacion) {
        this.idRol = idRol;
        this.denominacion = denominacion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_ROL", nullable = false)
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    @Column(name = "DENOMINACION", nullable = false)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

}
