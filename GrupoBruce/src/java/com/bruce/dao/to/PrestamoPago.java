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
@IdClass(PrestamoPagoId.class)
@Table(name = "PRESTAMO_PAGO", schema = "dbo", catalog = "BDBRUCE")
public class PrestamoPago implements java.io.Serializable {

    private String idPrestamo;
    private String idPpago;
    private Date fecha;
    private float monto;

    public PrestamoPago() {
    }

    @Id
    @Column(name = "ID_PRESTAMO", nullable = false)
    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Id
    @Column(name = "ID_PPAGO", nullable = false)
    public String getIdPpago() {
        return idPpago;
    }

    public void setIdPpago(String idPpago) {
        this.idPpago = idPpago;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "MONTO", nullable = false)
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
