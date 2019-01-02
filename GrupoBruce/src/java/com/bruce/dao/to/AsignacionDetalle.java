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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ASIGNACION_DETALLE", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = AsignacionDetalleId.class)
public class AsignacionDetalle implements java.io.Serializable {

    private String idAequipo;
    private String idEinformatico;
    private String idAdetalle;
    private Date fecha;
    private Date fechaAsignado;
    private boolean asignado;
    
    private String einformatico;

    public AsignacionDetalle() {
    }

    public AsignacionDetalle(String idAequipo, String idEinformatico, String idAdetalle, Date fecha,Date fechaAsignado, boolean asignado, String einformatico) {
        this.idAequipo = idAequipo;
        this.idEinformatico = idEinformatico;
        this.idAdetalle = idAdetalle;
        this.fecha = fecha;
        this.fechaAsignado = fechaAsignado;
        this.asignado = asignado;
        this.einformatico = einformatico;
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
    @Column(name = "ID_ADETALLE", nullable = false)
    public String getIdAdetalle() {
        return idAdetalle;
    }

    public void setIdAdetalle(String idAdetalle) {
        this.idAdetalle = idAdetalle;
    }

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
    
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ASIGNADO", nullable = false)
    public Date getFechaAsignado() {
        return fechaAsignado;
    }

    public void setFechaAsignado(Date fechaAsignado) {
        this.fechaAsignado = fechaAsignado;
    }

    @Column(name = "ASIGNADO", nullable = false)
    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "EINFORMATICO", insertable = false, updatable = false)
    public String getEinformatico() {
        return einformatico;
    }

    public void setEinformatico(String einformatico) {
        this.einformatico = einformatico;
    }
}
