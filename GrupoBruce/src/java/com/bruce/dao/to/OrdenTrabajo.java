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
@IdClass(value = OrdenTrabajoId.class)
@Table(name = "ORDEN_TRABAJO", schema = "dbo", catalog = "BDBRUCE")
public class OrdenTrabajo implements java.io.Serializable {

    private int idOtrabajo;
    private int anio;
    private int serie;
    private Date fecha;
    private float subtotal;
    private float impuesto;
    private float programado;
    private float pagado;
    private float extornado;
    private String idMoneda;
    private String idContratista;
    private int idDpago;
    private String idUsuario;

    public OrdenTrabajo() {
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

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "SUBTOTAL", nullable = false)
    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    @Column(name = "IMPUESTO", nullable = false)
    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    @Column(name = "PROGRAMADO", nullable = false)
    public float getProgramado() {
        return programado;
    }

    public void setProgramado(float programado) {
        this.programado = programado;
    }

    @Column(name = "PAGADO", nullable = false)
    public float getPagado() {
        return pagado;
    }

    public void setPagado(float pagado) {
        this.pagado = pagado;
    }

    @Column(name = "EXTORNADO", nullable = false)
    public float getExtornado() {
        return extornado;
    }

    public void setExtornado(float extornado) {
        this.extornado = extornado;
    }

    @Column(name = "ID_MONEDA", nullable = false)
    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    @Column(name = "ID_CONTRATISTA", nullable = false)
    public String getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(String idContratista) {
        this.idContratista = idContratista;
    }

    @Column(name = "ID_DPAGO", nullable = false)
    public int getIdDpago() {
        return idDpago;
    }

    public void setIdDpago(int idDpago) {
        this.idDpago = idDpago;
    }

    @Column(name = "ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
