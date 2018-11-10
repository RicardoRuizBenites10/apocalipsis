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
@Table(name = "EQUIPO_INFORMATICO", schema = "dbo", catalog = "BDBRUCE")
public class EquipoInformatico implements java.io.Serializable {

    private String idEinformatico;
    private String denominacion;
    private String serie;
    private Date fechaBase;
    private Date fechaUpdate;
    private String idTequipo;
    private int idEequipo;

    public EquipoInformatico() {
    }

    public EquipoInformatico(String idEinformatico, String denominacion, String serie, Date fechaBase, Date fechaUpdate, String idTequipo, int idEequipo) {
        this.idEinformatico = idEinformatico;
        this.denominacion = denominacion;
        this.serie = serie;
        this.fechaBase = fechaBase;
        this.fechaUpdate = fechaUpdate;
        this.idTequipo = idTequipo;
        this.idEequipo = idEequipo;
    }

    @Id
    @Column(name = "ID_EINFORMATICO", nullable = false)
    public String getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(String idEinformatico) {
        this.idEinformatico = idEinformatico;
    }

    @Column(name = "DENOMINACION", nullable = false)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Column(name = "SERIE")
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BASE", nullable = false)
    public Date getFechaBase() {
        return fechaBase;
    }

    public void setFechaBase(Date fechaBase) {
        this.fechaBase = fechaBase;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_UPDATE")
    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Column(name = "ID_TEQUIPO", nullable = false)
    public String getIdTequipo() {
        return idTequipo;
    }

    public void setIdTequipo(String idTequipo) {
        this.idTequipo = idTequipo;
    }

    @Column(name = "ID_EEQUIPO", nullable = false)
    public int getIdEequipo() {
        return idEequipo;
    }

    public void setIdEequipo(int idEequipo) {
        this.idEequipo = idEequipo;
    }
}
