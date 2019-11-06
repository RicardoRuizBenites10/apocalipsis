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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "PROFORMA", schema = "dbo", catalog = "BDBRUCE")
public class Proforma implements java.io.Serializable{

    private int anio;
    private Date fechaInsert;
    private Date fechaUpdate;
    private String idCliente;
    private String idProforma;
    private String idCarroceria;
    private boolean situacion;
    private String usuInsert;
    private String usuUpdate;
    
    private String cliente;
    private String carroceria;

    public Proforma() {
    }

    @Id
    @Column(name = "ID_PROFORMA", nullable = false)
    public String getIdProforma() {
        return idProforma;
    }

    @Column(name = "ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setIdProforma(String idProforma) {
        this.idProforma = idProforma;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_UPDATE", nullable = false)
    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INSERT", nullable = false)
    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    @Column(name = "ID_CLIENTE", nullable = false)
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Column(name = "ID_CARROCERIA", nullable = false)
    public String getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(String idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "USU_INSERT", nullable = false)
    public String getUsuInsert() {
        return usuInsert;
    }

    public void setUsuInsert(String usuInsert) {
        this.usuInsert = usuInsert;
    }

    @Column(name = "USU_UPDATE", nullable = false)
    public String getUsuUpdate() {
        return usuUpdate;
    }

    public void setUsuUpdate(String usuUpdate) {
        this.usuUpdate = usuUpdate;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="CLIENTE", insertable = false, updatable = false)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="CARROCERIA", insertable = false, updatable = false)
    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }
}
