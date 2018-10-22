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
 * @author RICARDO
 */
@Entity
@Table(name = "TIPO_AUSENCIA", schema = "dbo", catalog = "BDBRUCE")
public class TipoAusencia implements java.io.Serializable {

    private int idTausencia;
    private String descripcion;
    private boolean situacion;

    public TipoAusencia() {
    }

    public TipoAusencia(int idTausencia, String descripcion, boolean situacion) {
        this.idTausencia = idTausencia;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_TAUSENCIA", nullable = false)
    public int getIdTausencia() {
        return idTausencia;
    }

    public void setIdTausencia(int idTausencia) {
        this.idTausencia = idTausencia;
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
