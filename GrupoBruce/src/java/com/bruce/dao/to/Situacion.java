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
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "SITUACION", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = SituacionId.class)
public class Situacion implements java.io.Serializable {

    private String idTrabajador;
    private int idSituacion;
    private Date fechaAlta;
    private int contratoAlta;
    private Date fechaBaja;
    private int contratoBaja;
    private boolean activa;

    public Situacion() {
    }

    public Situacion(String idTrabajador, int idSituacion, Date fechaAlta, int contratoAlta, Date fechaBaja, int contratoBaja, boolean activa) {
        this.idTrabajador = idTrabajador;
        this.idSituacion = idSituacion;
        this.fechaAlta = fechaAlta;
        this.contratoAlta = contratoAlta;
        this.fechaBaja = fechaBaja;
        this.contratoBaja = contratoBaja;
        this.activa = activa;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", length = 15, nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_SITUACION", nullable = false)
    public int getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(int idSituacion) {
        this.idSituacion = idSituacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ALTA", nullable = false, length = 10)
    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Column(name = "CONTRATO_ALTA", nullable = false)
    public int getContratoAlta() {
        return contratoAlta;
    }

    public void setContratoAlta(int contratoAlta) {
        this.contratoAlta = contratoAlta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BAJA", length = 10)
    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Column(name = "CONTRATO_BAJA")
    public int getContratoBaja() {
        return contratoBaja;
    }

    public void setContratoBaja(int contratoBaja) {
        this.contratoBaja = contratoBaja;
    }

    @Column(name = "ACTIVA", nullable = false)
    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
