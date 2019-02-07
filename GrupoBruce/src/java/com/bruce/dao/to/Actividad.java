/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ACTIVIDAD", schema = "dbo", catalog = "BDBRUCE")
public class Actividad implements java.io.Serializable {

    private int idActividad;
    private Date fecha;
    private String nombre;
    private float duracion;
    private float precio;
    private boolean usaMaterial;
    private boolean situacion;
    private String idMoneda;
    private int idEproceso;
    private String idUsuario;

    public Actividad() {
    }

    public Actividad(int idActividad, Date fecha, String nombre, float duracion, float precio, boolean usaMaterial, boolean situacion, String idMoneda, int idEproceso, String idUsuario) {
        this.idActividad = idActividad;
        this.fecha = fecha;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.usaMaterial = usaMaterial;
        this.situacion = situacion;
        this.idMoneda = idMoneda;
        this.idEproceso = idEproceso;
        this.idUsuario = idUsuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ACTIVIDAD", nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DURACION", nullable = false)
    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Column(name = "PRECIO", nullable = false)
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "ID_MONEDA", nullable = false)
    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    @Column(name = "ID_EPROCESO", nullable = false)
    public int getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(int idEproceso) {
        this.idEproceso = idEproceso;
    }

    @Column(name = "USA_MATERIAL", nullable = false)
    public boolean isUsaMaterial() {
        return usaMaterial;
    }

    public void setUsaMaterial(boolean usaMaterial) {
        this.usaMaterial = usaMaterial;
    }

    @Column(name = "ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
