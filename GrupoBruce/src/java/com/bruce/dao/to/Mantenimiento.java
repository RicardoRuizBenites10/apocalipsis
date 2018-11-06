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

    private int idAequipo;
    private String idMantenimiento;
    private Date fecha;
    private Date fechaProgramada;
    private Date fechaAtendido;
    private boolean atendido;
    private String observacion;
    private float costo;
    private int idTmantenimiento;

    public Mantenimiento() {
    }

    public Mantenimiento(int idAequipo, String idMantenimiento, Date fecha, Date fechaProgramada, Date fechaAtendido, boolean atendido, String observacion, float costo, int idTmantenimiento) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
        this.fecha = fecha;
        this.fechaProgramada = fechaProgramada;
        this.fechaAtendido = fechaAtendido;
        this.atendido = atendido;
        this.observacion = observacion;
        this.costo = costo;
        this.idTmantenimiento = idTmantenimiento;
    }

    @Id
    @Column(name = "ID_AEQUIPO", nullable = false)
    public int getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(int idAequipo) {
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

    @Column(name = "ATENDIDO", nullable = false)
    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
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
    public int getIdTmantenimiento() {
        return idTmantenimiento;
    }

    public void setIdTmantenimiento(int idTmantenimiento) {
        this.idTmantenimiento = idTmantenimiento;
    }
}
