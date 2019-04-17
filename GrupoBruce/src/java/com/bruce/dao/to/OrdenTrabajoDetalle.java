/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = OrdenTrabajoDetalleId.class)
@Table(name = "ORDEN_TRABAJO_DETALLE", schema = "dbo", catalog = "BDBRUCE")
public class OrdenTrabajoDetalle implements java.io.Serializable {

    private int idOtrabajo;
    private int anio;
    private int serie;
    private int idTrabajo;
    private int idObra;
    private float cantidad;
    private float importe;
    private float recepcionado;

    public OrdenTrabajoDetalle() {
    }

    @Id
    @Column(name = "ID_OTRABAJO", nullable = false)
    public int getIdOtrabajo() {
        return idOtrabajo;
    }

    public void setIdOtrabajo(int idOtrabajo) {
        this.idOtrabajo = idOtrabajo;
    }

    @Id
    @Column(name = "ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Id
    @Column(name = "SERIE", nullable = false)
    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Id
    @Column(name = "ID_TRABAJO", nullable = false)
    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "CANTIDAD", nullable = false)
    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "IMPORTE", nullable = false)
    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Column(name = "RECEPCIONADO", nullable = false)
    public float getRecepcionado() {
        return recepcionado;
    }

    public void setRecepcionado(float recepcionado) {
        this.recepcionado = recepcionado;
    }

}
