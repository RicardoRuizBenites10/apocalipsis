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
@Table(name = "COLOR_DISENO", schema = "dbo", catalog = "BDBRUCE")
public class ColorDiseno implements java.io.Serializable{

    private String idCdiseno;
    private Date fecha;
    private String denominacion;

    public ColorDiseno() {
    }

    @Id
    @Column(name = "ID_CDISENO", nullable = false)
    public String getIdCdiseno() {
        return idCdiseno;
    }

    public void setIdCdiseno(String idCdiseno) {
        this.idCdiseno = idCdiseno;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "DENOMINACION", nullable = false)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
