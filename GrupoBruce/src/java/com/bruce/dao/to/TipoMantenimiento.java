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
@Table(name="TIPO_MANTENIMIENTO", schema="dbo", catalog="BDBRUCE")
public class TipoMantenimiento implements java.io.Serializable{
    private int idTmantenimiento;
    private String descripcion;
    private boolean situacion;

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(int idTmantenimiento, String descripcion, boolean situacion) {
        this.idTmantenimiento = idTmantenimiento;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }
    
    @Id
    @Column(name="ID_TMANTENIMIENTO", nullable=false)
    public int getIdTmantenimiento() {
        return idTmantenimiento;
    }

    public void setIdTmantenimiento(int idTmantenimiento) {
        this.idTmantenimiento = idTmantenimiento;
    }

    @Column(name="DESCRIPCION", nullable=false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
