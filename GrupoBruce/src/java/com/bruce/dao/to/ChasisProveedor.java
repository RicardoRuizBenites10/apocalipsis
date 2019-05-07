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
@Table(name = "CHASIS_PROVEEDOR", schema = "dbo", catalog = "BDBRUCE")
public class ChasisProveedor implements java.io.Serializable {

    private String idChapro;
    private Date fecha;
    private String nombre;
    private boolean situacion;

    public ChasisProveedor() {
    }

    @Id
    @Column(name = "ID_CHAPRO", nullable = false)
    public String getIdChapro() {
        return idChapro;
    }

    public void setIdChapro(String idChapro) {
        this.idChapro = idChapro;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
