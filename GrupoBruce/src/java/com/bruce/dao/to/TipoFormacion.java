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
@Table(name = "TIPO_FORMACION", schema = "dbo", catalog = "BDBRUCE")
public class TipoFormacion implements java.io.Serializable {

    private int idTformacion;
    private String descripcion;
    private boolean situacion;

    public TipoFormacion() {
    }

    public TipoFormacion(int idTformacion, String descripcion, boolean situacion) {
        this.idTformacion = idTformacion;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }
    
    @Id
    @Column(name="ID_TFORMACION", unique = true, nullable=false)
    public int getIdTformacion() {
        return idTformacion;
    }

    public void setIdTformacion(int idTformacion) {
        this.idTformacion = idTformacion;
    }

    @Column(name="DESCRIPCION", nullable=false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
