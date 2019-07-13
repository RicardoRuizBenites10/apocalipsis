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
@Table(name = "UNIDAD_MEDIDA", schema = "dbo", catalog = "BDBRUCE")
public class UnidadMedida implements java.io.Serializable {

    private String idUmedida;
    private String denominacion;
    private float equivalencia;
    private boolean situacion;

    public UnidadMedida() {
    }

    @Id
    @Column(name = "ID_UMEDIDA", nullable = false)
    public String getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(String idUmedida) {
        this.idUmedida = idUmedida;
    }

    @Column(name = "DENOMINACION", nullable = false)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Column(name = "EQUIVALENCIA", nullable = false)
    public float getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(float equivalencia) {
        this.equivalencia = equivalencia;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
