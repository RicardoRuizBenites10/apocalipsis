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
@IdClass(value = MaterialSubfamiliaId.class)
@Table(name = "MATERIAL_SUBFAMILIA", schema = "dbo", catalog = "BDBRUCE")
public class MaterialSubfamilia implements java.io.Serializable {

    private int idFamilia;
    private int idSubfamilia;
    private Date fecha;
    private String descripcion;
    private boolean situacion;

    public MaterialSubfamilia() {
    }
    
    @Id
    @Column(name="ID_FAMILIA", nullable = false)
    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    @Id
    @Column(name="ID_SUBFAMILIA", nullable = false)
    public int getIdSubfamilia() {
        return idSubfamilia;
    }

    public void setIdSubfamilia(int idSubfamilia) {
        this.idSubfamilia = idSubfamilia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
