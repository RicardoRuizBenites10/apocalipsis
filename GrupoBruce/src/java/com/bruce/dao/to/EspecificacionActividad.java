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
@IdClass(value = EspecificacionActividadId.class)
@Table(name = "ESPECIFICACION_ACTIVIDAD", schema = "dbo", catalog = "BDBRUCE")
public class EspecificacionActividad implements java.io.Serializable {

    private int idEspecificacion;
    private int idActividad;
    private Date fecha;
    
    private String actividad;
    private String etapa;

    public EspecificacionActividad() {
    }
    
    @Id
    @Column(name="ID_ESPECIFICACION",nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    @Id
    @Column(name="ID_ACTIVIDAD",nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA",nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="ACTIVIDAD", insertable = false, updatable = false)
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="ETAPA", insertable = false, updatable = false)
    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
}
