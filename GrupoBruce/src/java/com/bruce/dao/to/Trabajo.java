/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "TRABAJO", schema = "dbo", catalog = "BDBRUCE")
public class Trabajo implements java.io.Serializable {

    private int idTrabajo;
    private Date fecha;
    private String denominacion;
    private float costoRealizacion;
    private float costoMaterial;
    private boolean situacion;
    private int idEproceso;
    private String idMoneda;

    public Trabajo() {
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false)
    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "DENOMINACION", nullable = false)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Column(name = "COSTO_REALIZACION", nullable = false)
    public float getCostoRealizacion() {
        return costoRealizacion;
    }

    public void setCostoRealizacion(float costoRealizacion) {
        this.costoRealizacion = costoRealizacion;
    }

    @Column(name = "COSTO_MATERIAL", nullable = false)
    public float getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(float costoMaterial) {
        this.costoMaterial = costoMaterial;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "ID_EPROCESO", nullable = false)
    public int getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(int idEproceso) {
        this.idEproceso = idEproceso;
    }

    @Column(name = "ID_MONEDA", nullable = false)
    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }
}
