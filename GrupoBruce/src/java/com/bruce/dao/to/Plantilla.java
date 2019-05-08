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
@IdClass(value = PlantillaId.class)
@Table(name = "PLANTILLA", schema = "dbo", catalog = "BDBRUCE")
public class Plantilla implements java.io.Serializable {

    private String idCarroceria;
    private int idEspecificacion;
    private Date fechaInsert;
    private Date fechaUpdate;
    
    private String especificacion;

    public Plantilla() {
    }

    @Id
    @Column(name = "ID_CARROCERIA", nullable = false)
    public String getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(String idCarroceria) {
        this.idCarroceria = idCarroceria;
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
    @Column(name = "FECHA_INSERT", nullable = false)
    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_UPDATE", nullable = false)
    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="ESPECIFICACION", insertable = false, updatable = false)
    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
}
