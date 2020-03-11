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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "REQUERIMIENTO", schema = "dbo", catalog = "BDBRUCE")
public class Requerimiento implements java.io.Serializable {

    private int idRequerimiento;
    private Date fechaGenerado;
    private Date fechaProgramado;
    private boolean extornado;
    private float requerido;
    private float despachado;
    private int idObra;
    private String idTrabajador;
    private int idEspecificacion;
    private int idActividad;
    private String idUsuario;
    
    private String obra;
    private String actividad;
    private String trabajador;

    public Requerimiento() {
    }
    
    @Id
    @Column(name="ID_REQUERIMIENTO", nullable = false)
    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_GENERADO", nullable = false)
    public Date getFechaGenerado() {
        return fechaGenerado;
    }

    public void setFechaGenerado(Date fechaGenerado) {
        this.fechaGenerado = fechaGenerado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_PROGRAMADO", nullable = false)
    public Date getFechaProgramado() {
        return fechaProgramado;
    }

    public void setFechaProgramado(Date fechaProgramado) {
        this.fechaProgramado = fechaProgramado;
    }

    @Column(name="EXTORNADO", nullable = false)
    public boolean isExtornado() {
        return extornado;
    }

    public void setExtornado(boolean extornado) {
        this.extornado = extornado;
    }

    @Column(name="REQUERIDO", nullable = false)
    public float getRequerido() {
        return requerido;
    }

    public void setRequerido(float requerido) {
        this.requerido = requerido;
    }

    @Column(name="DESPACHADO", nullable = false)
    public float getDespachado() {
        return despachado;
    }

    public void setDespachado(float despachado) {
        this.despachado = despachado;
    }

    @Column(name="ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name="ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Column(name="ID_ESPECIFICACION", nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    @Column(name="ID_ACTIVIDAD", nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Column(name="ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Generated(GenerationTime.NEVER)
    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    @Generated(GenerationTime.NEVER)
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Generated(GenerationTime.NEVER)
    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
}
