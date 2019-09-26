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
import javax.persistence.Transient;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ETAPA_PROCESO", schema = "dbo", catalog = "BDBRUCE")
public class EtapaProceso implements java.io.Serializable {
    private String idEproceso;
    private String descripcion;
    private int nivel;
    private int orden;
    private boolean pasaBus;
    private boolean situacion;
    private boolean leaf;
    private String idSupeproceso;
    
    private String parentId;
    private String lastParentId;

    public EtapaProceso() {
    }

    public EtapaProceso(String idEproceso, String descripcion, int orden, boolean pasaBus, boolean situacion) {
        this.idEproceso = idEproceso;
        this.descripcion = descripcion;
        this.orden = orden;
        this.pasaBus = pasaBus;
        this.situacion = situacion;
    }

    @Id
    @Column(name="ID_EPROCESO", nullable = false)
    public String getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(String idEproceso) {
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

    @Column(name="NIVEL", nullable = false)
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Column(name="LEAF", nullable = false)
    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Column(name="ID_SUPEPROCESO", nullable = false)
    public String getIdSupeproceso() {
        return idSupeproceso;
    }

    public void setIdSupeproceso(String idSupeproceso) {
        this.idSupeproceso = idSupeproceso;
    }

    @Transient
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Transient
    public String getLastParentId() {
        return lastParentId;
    }

    public void setLastParentId(String lastParentId) {
        this.lastParentId = lastParentId;
    }
}
