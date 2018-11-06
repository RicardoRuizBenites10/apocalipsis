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
@Table(name = "ESTADO_EQUIPO", schema = "dbo", catalog = "BDBRUCE")
public class EstadoEquipo implements java.io.Serializable {

    private int idEequipo;
    private String descripcion;
    private boolean situacion;

    public EstadoEquipo() {
    }

    public EstadoEquipo(int idEequipo, String descripcion, boolean situacion) {
        this.idEequipo = idEequipo;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_EEQUIPO", nullable = false)
    public int getIdEequipo() {
        return idEequipo;
    }

    public void setIdEequipo(int idEequipo) {
        this.idEequipo = idEequipo;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
