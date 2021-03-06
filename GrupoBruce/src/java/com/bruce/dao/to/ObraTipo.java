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
 * @author SISTEMAS
 */
@Entity
@Table(name = "OBRA_TIPO", schema = "dbo", catalog = "BDBRUCE")
public class ObraTipo implements java.io.Serializable {

    private String idObrtip;
    private String descripcion;
    private boolean situacion;

    public ObraTipo() {
    }

    @Id
    @Column(name = "ID_OBRTIP", nullable = false)
    public String getIdObrtip() {
        return idObrtip;
    }

    public void setIdObrtip(String idObrtip) {
        this.idObrtip = idObrtip;
    }

    @Column(name = "DESCRIPCION", nullable = false)
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
}
