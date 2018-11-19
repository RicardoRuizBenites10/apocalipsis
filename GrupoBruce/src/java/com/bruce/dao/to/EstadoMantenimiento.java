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
@Table(name = "ESTADO_MANTENIMIENTO", schema = "dbo", catalog = "BDBRUCE")
public class EstadoMantenimiento implements java.io.Serializable {

    private String idEmantenimiento;
    private String descripcion;
    private boolean situacion;

    public EstadoMantenimiento() {
    }

    public EstadoMantenimiento(String idEmantenimiento, String descripcion, boolean situacion) {
        this.idEmantenimiento = idEmantenimiento;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_EMANTENIMIENTO", nullable = false)
    public String getIdEmantenimiento() {
        return idEmantenimiento;
    }

    public void setIdEmantenimiento(String idEmantenimiento) {
        this.idEmantenimiento = idEmantenimiento;
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
