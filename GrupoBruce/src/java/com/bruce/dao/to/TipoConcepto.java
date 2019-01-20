/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author RICARDO
 */
@Entity
@Table(name = "TIPO_CONCEPTO", schema = "dbo", catalog = "BDBRUCE")
public class TipoConcepto implements java.io.Serializable {

    private String idTconcepto;
    private String descripcion;
    private boolean situacion;

    public TipoConcepto() {
    }

    @Id
    @Column(name="ID_TIPO", nullable = false)
    public String getIdTconcepto() {
        return idTconcepto;
    }

    public void setIdTconcepto(String idTconcepto) {
        this.idTconcepto = idTconcepto;
    }

    @Column(name="DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
