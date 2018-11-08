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
    private Date fechaCreate;
    private Date fechaUpdate;
    private int idTequipo;
    private int idEequipo;

    public EquipoInformatico() {
    }

    public EquipoInformatico(String idEinformatico, String denominacion, String serie, Date fechaCreate, Date fechaUpdate, int idTequipo, int idEequipo) {
        this.idEinformatico = idEinformatico;
        this.denominacion = denominacion;
        this.serie = serie;
        this.fechaCreate = fechaCreate;
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
    @Column(name = "FECHA_CREATE", nullable = false)
    public Date getFechaCreate() {
        return fechaCreate;
    }

    public void setFechaCreate(Date fechaCreate) {
        this.fechaCreate = fechaCreate;
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
    public int getIdTequipo() {
        return idTequipo;
    }

    public void setIdTequipo(int idTequipo) {
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
