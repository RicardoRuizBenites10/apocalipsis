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

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ESTADO_MANTENIMIENTO", schema = "dbo", catalog = "BDBRUCE")
public class EstadoMantenimiento implements java.io.Serializable {

    private String idEmantenimiento;
    private int orden;
    private String descripcion;
    private String accion;
    private boolean solucionador;
    private boolean situacion;
    private boolean ultimo;
    private String idPosterior;

    public EstadoMantenimiento() {
    }

    public EstadoMantenimiento(String idEmantenimiento, String descripcion, boolean situacion) {
        this.idEmantenimiento = idEmantenimiento;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_EMANTENIMIENTO", nullable = false)
    public String getIdEmantenimiento() {
        return idEmantenimiento;
    }

    public void setIdEmantenimiento(String idEmantenimiento) {
        this.idEmantenimiento = idEmantenimiento;
    }

    @Column(name = "ORDEN", nullable = false)
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "ACCION", nullable = false)
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Column(name = "SOLUCIONADOR", nullable = false)
    public boolean isSolucionador() {
        return solucionador;
    }

    public void setSolucionador(boolean solucionador) {
        this.solucionador = solucionador;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "ULTIMO", nullable = false)
    public boolean isUltimo() {
        return ultimo;
    }

    public void setUltimo(boolean ultimo) {
        this.ultimo = ultimo;
    }

    @Column(name = "ID_POSTERIOR", nullable = false)
    public String getIdPosterior() {
        return idPosterior;
    }

    public void setIdPosterior(String idPosterior) {
        this.idPosterior = idPosterior;
    }
}
