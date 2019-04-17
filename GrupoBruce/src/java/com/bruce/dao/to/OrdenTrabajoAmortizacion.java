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
@IdClass(value = OrdenTrabajoAmortizacionId.class)
@Table(name = "ORDEN_TRABAJO_AMORTIZACION", schema = "dbo", catalog = "BDBRUCE")
public class OrdenTrabajoAmortizacion implements java.io.Serializable {

    private int idOtrabajo;
    private int anio;
    private int serie;
    private int idAmortizacion;
    private Date fecha;
    private String nroOperacion;
    private float monto;
    private boolean eliminado;
    private Date fechaDelete;
    private String idEfinanciera;
    private String idUsusave;
    private String idUsudelete;

    public OrdenTrabajoAmortizacion() {
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
    @Column(name = "ID_AMORTIZACION", nullable = false)
    public int getIdAmortizacion() {
        return idAmortizacion;
    }

    public void setIdAmortizacion(int idAmortizacion) {
        this.idAmortizacion = idAmortizacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "NRO_OPERACION", nullable = false)
    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    @Column(name = "MONTO", nullable = false)
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Column(name = "ELIMINADO", nullable = false)
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_DELETE", nullable = false)
    public Date getFechaDelete() {
        return fechaDelete;
    }

    public void setFechaDelete(Date fechaDelete) {
        this.fechaDelete = fechaDelete;
    }

    @Column(name = "ID_EFINANCIERA", nullable = false)
    public String getIdEfinanciera() {
        return idEfinanciera;
    }

    public void setIdEfinanciera(String idEfinanciera) {
        this.idEfinanciera = idEfinanciera;
    }

    @Column(name = "ID_USUSAVE", nullable = false)
    public String getIdUsusave() {
        return idUsusave;
    }

    public void setIdUsusave(String idUsusave) {
        this.idUsusave = idUsusave;
    }

    @Column(name = "ID_USUDELETE", nullable = false)
    public String getIdUsudelete() {
        return idUsudelete;
    }

    public void setIdUsudelete(String idUsudelete) {
        this.idUsudelete = idUsudelete;
    }
}
