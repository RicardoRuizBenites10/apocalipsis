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
 * @author RICARDO
 */
@Entity
@Table(name = "AUSENCIA", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = AusenciaId.class)
public class Ausencia implements java.io.Serializable{

    private String idTrabajador;
    private int idAusencia;
    private Date fechaInicio;
    private Date fechaFin;
    private String horaInicio;
    private String horaFin;
    private String detalle;
    private int idTausencia;
    private int idTmausencia;

    public Ausencia() {
    }

    public Ausencia(String idTrabajador, int idAusencia, Date fechaInicio, Date fechaFin, String horaInicio, String horaFin, String detalle, int idTausencia, int idTmausencia) {
        this.idTrabajador = idTrabajador;
        this.idAusencia = idAusencia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.detalle = detalle;
        this.idTausencia = idTausencia;
        this.idTmausencia = idTmausencia;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false, length = 15)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_AUSENCIA", nullable = false)
    public int getIdAusencia() {
        return idAusencia;
    }

    public void setIdAusencia(int idAusencia) {
        this.idAusencia = idAusencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO", nullable = false, length = 10)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN", nullable = false, length = 10)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "HORA_INICIO", length = 10)
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Column(name = "HORA_FIN", length = 10)
    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Column(name = "DETALLE")
    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Column(name = "ID_TAUSENCIA", nullable = false)
    public int getIdTausencia() {
        return idTausencia;
    }

    public void setIdTausencia(int idTausencia) {
        this.idTausencia = idTausencia;
    }

    @Column(name = "ID_TMAUSENCIA", nullable = false)
    public int getIdTmausencia() {
        return idTmausencia;
    }

    public void setIdTmausencia(int idTmausencia) {
        this.idTmausencia = idTmausencia;
    }
}
