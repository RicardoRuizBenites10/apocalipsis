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
import javax.persistence.Transient;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ESPECIFICACION_CATEGORIA", catalog = "BDBRUCE", schema = "dbo")
public class EspecificacionCategoria implements java.io.Serializable {

    private String idEcategoria;
    private String nombre;
    private Date fecha;
    private Date fechaUpdate;
    private boolean situacion;
    private boolean leaf;
    private String idSupecategoria;

    private String parentId;
    private String lastParentId;
    private boolean expanded;

    public EspecificacionCategoria() {
    }

    @Id
    @Column(name = "ID_ECATEGORIA", nullable = false)
    public String getIdEcategoria() {
        return idEcategoria;
    }

    public void setIdEcategoria(String idEcategoria) {
        this.idEcategoria = idEcategoria;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_UPDATE", nullable = false)
    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "LEAF", nullable = false)
    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Column(name = "ID_SUPECATEGORIA", nullable = false)
    public String getIdSupecategoria() {
        return idSupecategoria;
    }

    public void setIdSupecategoria(String idSupecategoria) {
        this.idSupecategoria = idSupecategoria;
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

    @Transient
    public boolean isExpanded() {
        return true;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
