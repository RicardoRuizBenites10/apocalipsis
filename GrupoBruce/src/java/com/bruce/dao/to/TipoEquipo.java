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
@Table(name = "TIPO_EQUIPO", schema = "dbo", catalog = "BDBRUCE")
public class TipoEquipo implements java.io.Serializable {

    private int idTequipo;
    private String descripcion;
    private boolean situacion;

    public TipoEquipo() {
    }

    public TipoEquipo(int idTequipo, String descripcion, boolean situacion) {
        this.idTequipo = idTequipo;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_TEQUIPO", nullable = false)
    public int getIdTequipo() {
        return idTequipo;
    }

    public void setIdTequipo(int idTequipo) {
        this.idTequipo = idTequipo;
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
