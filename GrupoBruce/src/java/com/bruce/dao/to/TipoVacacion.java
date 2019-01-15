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
@Table(name = "TIPO_VACACION", schema = "dbo", catalog = "BDBRUCE")
public class TipoVacacion implements java.io.Serializable {

    private int idTVacacion;
    private String descripcion;
    private boolean ausencia;
    private boolean situacion;

    public TipoVacacion() {
    }

    public TipoVacacion(int idTVacacion, String descripcion, boolean ausencia, boolean situacion) {
        this.idTVacacion = idTVacacion;
        this.descripcion = descripcion;
        this.ausencia = ausencia;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_TVACACION", nullable = false)
    public int getIdTVacacion() {
        return idTVacacion;
    }

    public void setIdTVacacion(int idTVacacion) {
        this.idTVacacion = idTVacacion;
    }

    @Column(name = "DESCRIPCION", nullable = false, length = 25)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "AUSENCIA", nullable = false)
    public boolean isAusencia() {
        return ausencia;
    }

    public void setAusencia(boolean ausencia) {
        this.ausencia = ausencia;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

}
