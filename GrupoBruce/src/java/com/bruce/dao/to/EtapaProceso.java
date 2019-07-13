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
@Table(name = "ETAPA_PROCESO", schema = "dbo", catalog = "BDBRUCE")
public class EtapaProceso implements java.io.Serializable {
    private int idEproceso;
    private String descripcion;
    private int orden;
    private boolean pasaBus;
    private boolean situacion;

    public EtapaProceso() {
    }

    public EtapaProceso(int idEproceso, String descripcion, int orden, boolean pasaBus, boolean situacion) {
        this.idEproceso = idEproceso;
        this.descripcion = descripcion;
        this.orden = orden;
        this.pasaBus = pasaBus;
        this.situacion = situacion;
    }

    @Id
    @Column(name="ID_EPROCESO", nullable = false)
    public int getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(int idEproceso) {
        this.idEproceso = idEproceso;
    }

    @Column(name="DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="ORDEN", nullable = false)
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Column(name="PASA_BUS", nullable = false)
    public boolean isPasaBus() {
        return pasaBus;
    }

    public void setPasaBus(boolean pasaBus) {
        this.pasaBus = pasaBus;
    }

    @Column(name="SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
