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
@Table(name = "MANTENIMIENTO", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = MantenimientoId.class)
public class Mantenimiento implements java.io.Serializable {

    private String idAequipo;
    private String idMantenimiento;
    private Date fecha;
    private Date fechaProgramada;
    private Date fechaAtendido;
    private String observacion;
    private float costo;
    private String idTmantenimiento;
    private String idEmantenimiento;
    private String idGenerador;

    public Mantenimiento() {
    }

    public Mantenimiento(String idAequipo, String idMantenimiento) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
    }


    @Id
    @Column(name = "ID_AEQUIPO", nullable = false)
    public String getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(String idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Id
    @Column(name = "ID_MANTENIMIENTO", nullable = false)
    public String getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(String idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
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
    @Column(name = "FECHA_PROGRAMADA", nullable = false)
    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ATENDIDO")
    public Date getFechaAtendido() {
        return fechaAtendido;
    }

    public void setFechaAtendido(Date fechaAtendido) {
        this.fechaAtendido = fechaAtendido;
    }

    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(name = "COSTO")
    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Column(name = "ID_TMANTENIMIENTO", nullable = false)
    public String getIdTmantenimiento() {
        return idTmantenimiento;
    }

    public void setIdTmantenimiento(String idTmantenimiento) {
        this.idTmantenimiento = idTmantenimiento;
    }

    @Column(name = "ID_EMANTENIMIENTO", nullable = false)
    public String getIdEmantenimiento() {
        return idEmantenimiento;
    }

    public void setIdEmantenimiento(String idEmantenimiento) {
        this.idEmantenimiento = idEmantenimiento;
    }

    @Column(name = "ID_GENERADOR", nullable = false)
    public String getIdGenerador() {
        return idGenerador;
    }

    public void setIdGenerador(String idGenerador) {
        this.idGenerador = idGenerador;
    }
}
