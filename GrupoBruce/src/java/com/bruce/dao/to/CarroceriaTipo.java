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
@Table(name = "CARROCERIA_TIPO", schema = "dbo", catalog = "BDBRUCE")
public class CarroceriaTipo implements java.io.Serializable {

    private String idCartip;
    private String codigo;
    private Date fecha;
    private String descripcion;
    private boolean situacion;
    private String idCarmod;

    public CarroceriaTipo() {
    }

    @Id
    @Column(name = "ID_CARTIP", nullable = false)
    public String getIdCartip() {
        return idCartip;
    }

    public void setIdCartip(String idCartip) {
        this.idCartip = idCartip;
    }

    @Column(name = "CODIGO", nullable = false)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "ID_CARMOD", nullable = false)
    public String getIdCarmod() {
        return idCarmod;
    }

    public void setIdCarmod(String idCarmod) {
        this.idCarmod = idCarmod;
    }
}
