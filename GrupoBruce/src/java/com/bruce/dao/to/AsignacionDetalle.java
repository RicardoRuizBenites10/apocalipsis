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
@Table(name = "ASIGNACION_DETALLE", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = AsignacionDetalleId.class)
public class AsignacionDetalle implements java.io.Serializable {

    private int idAequipo;
    private String idEinformatico;
    private Date fecha;
    private int cantidad;
    private boolean asignado;

    public AsignacionDetalle() {
    }

    public AsignacionDetalle(int idAequipo, String idEinformatico, Date fecha, int cantidad, boolean asignado) {
        this.idAequipo = idAequipo;
        this.idEinformatico = idEinformatico;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.asignado = asignado;
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
    @Column(name = "ID_EINFORMATICO", nullable = false)
    public String getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(String idEinformatico) {
        this.idEinformatico = idEinformatico;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "CANTIDAD", nullable = false)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "ASIGNADO", nullable = false)
    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
}
