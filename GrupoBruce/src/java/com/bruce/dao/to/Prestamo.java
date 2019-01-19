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
@Table(name = "PRESTAMO", schema = "dbo", catalog = "BDBRUCE")
public class Prestamo implements java.io.Serializable {

    private String idPrestamo;
    private Date fecha;
    private Date fechaEntrega;
    private String descripcion;
    private float mprestado;
    private float mpagado;
    private float pagoCuota;
    private boolean pagado;
    private String idTrabajador;

    public Prestamo() {
    }

    @Id
    @Column(name = "ID_PRESTAMO", nullable = false)
    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "FECHA_ENTREGA", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "MPRESTADO", nullable = false)
    public float getMprestado() {
        return mprestado;
    }

    public void setMprestado(float mprestado) {
        this.mprestado = mprestado;
    }

    @Column(name = "MPAGADO", nullable = false)
    public float getMpagado() {
        return mpagado;
    }

    public void setMpagado(float mpagado) {
        this.mpagado = mpagado;
    }

    @Column(name = "PAGO_CUOTA", nullable = false)
    public float getPagoCuota() {
        return pagoCuota;
    }

    public void setPagoCuota(float pagoCuota) {
        this.pagoCuota = pagoCuota;
    }

    @Column(name = "PAGADO", nullable = false)
    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
}
