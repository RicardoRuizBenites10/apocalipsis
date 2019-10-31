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
@IdClass(value = ProformaDetalleId.class)
@Table(name = "PROFORMA_DETALLE", schema = "dbo", catalog = "BDBRUCE")
public class ProformaDetalle implements java.io.Serializable {

    private int idProforma;
    private int idEspecificacion;
    private Date fecha;
    private boolean wasstd;
    private boolean asignado;
    private String usuUpdate;

    private String especificacion;

    public ProformaDetalle() {
    }

    @Id
    @Column(name = "ID_PROFORMA", nullable = false)
    public int getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(int idProforma) {
        this.idProforma = idProforma;
    }

    @Id
    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "WASSTD", nullable = false)
    public boolean isWasstd() {
        return wasstd;
    }

    public void setWasstd(boolean wasstd) {
        this.wasstd = wasstd;
    }

    @Column(name = "ASIGNADO", nullable = false)
    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    @Column(name = "USU_UPDATE", nullable = false)
    public String getUsuUpdate() {
        return usuUpdate;
    }

    public void setUsuUpdate(String usuUpdate) {
        this.usuUpdate = usuUpdate;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "ESPECIFICACION", insertable = false, updatable = false)
    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
}
