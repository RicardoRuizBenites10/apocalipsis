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
@Table(name = "ESPECIFICACION", schema = "dbo", catalog = "BDBRUCE")
public class Especificacion implements java.io.Serializable {

    private int idEspecificacion;
    private String descripcion;
    private Date fechaInsert;
    private String usuInsert;
    private Date fechaUpdate;
    private String usuUpdate;
    private boolean situacion;
    private boolean usaActividad;
    private String idEcategoria;
    
    private String categoria;

    public Especificacion() {
    }

    @Id
    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INSERT", nullable = false)
    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    @Column(name = "USU_INSERT", nullable = false)
    public String getUsuInsert() {
        return usuInsert;
    }

    public void setUsuInsert(String usuInsert) {
        this.usuInsert = usuInsert;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_UPDATE")
    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Column(name = "USU_UPDATE")
    public String getUsuUpdate() {
        return usuUpdate;
    }

    public void setUsuUpdate(String usuUpdate) {
        this.usuUpdate = usuUpdate;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "USA_ACTIVIDAD", nullable = false)
    public boolean isUsaActividad() {
        return usaActividad;
    }

    public void setUsaActividad(boolean usaActividad) {
        this.usaActividad = usaActividad;
    }
    
    @Column(name="ID_ECATEGORIA", nullable= false)
    public String getIdEcategoria() {
        return idEcategoria;
    }

    public void setIdEcategoria(String idEcategoria) {
        this.idEcategoria = idEcategoria;
    }

    @Column(name="CATEGORIA", insertable = false, updatable = false)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
