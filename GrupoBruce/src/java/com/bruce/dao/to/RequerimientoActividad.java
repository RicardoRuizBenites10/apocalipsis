/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = RequerimientoActividadId.class)
@Table(name = "REQUERIMIENTO_ACTIVIDAD", schema = "dbo", catalog = "BDBRUCE")
public class RequerimientoActividad implements java.io.Serializable {

    private int idObra;
    private int idEspecifiacion;
    private int idActividad;
    private float requerido;
    private float despachado;
    private String estado;

    private String actividad;

    public RequerimientoActividad() {
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Id
    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecifiacion() {
        return idEspecifiacion;
    }

    public void setIdEspecifiacion(int idEspecifiacion) {
        this.idEspecifiacion = idEspecifiacion;
    }

    @Id
    @Column(name = "ID_ACTIVIDAD", nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Column(name = "REQUERIDO", nullable = false)
    public float getRequerido() {
        return requerido;
    }

    public void setRequerido(float requerido) {
        this.requerido = requerido;
    }

    @Column(name = "DESPACHADO", nullable = false)
    public float getDespachado() {
        return despachado;
    }

    public void setDespachado(float despachado) {
        this.despachado = despachado;
    }

    @Column(name = "ESTADO", nullable = false)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "ACTIVIDAD", nullable = false)
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
