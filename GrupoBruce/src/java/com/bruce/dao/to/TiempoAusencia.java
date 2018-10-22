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
@Table(name = "TIEMPO_AUSENCIA", schema = "dbo", catalog = "BDBRUCE")
public class TiempoAusencia implements java.io.Serializable {

    private int idTmausencia;
    private String descripcion;
    private boolean horas;
    private boolean situacion;

    public TiempoAusencia() {
    }

    public TiempoAusencia(int idTmausencia, String descripcion, boolean horas, boolean situacion) {
        this.idTmausencia = idTmausencia;
        this.descripcion = descripcion;
        this.horas = horas;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_TMAUSENCIA", nullable = false)
    public int getIdTmausencia() {
        return idTmausencia;
    }

    public void setIdTmausencia(int idTmausencia) {
        this.idTmausencia = idTmausencia;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "HORAS", nullable = false)
    public boolean isHoras() {
        return horas;
    }

    public void setHoras(boolean horas) {
        this.horas = horas;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
