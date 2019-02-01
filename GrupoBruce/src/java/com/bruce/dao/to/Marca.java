/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = MarcaId.class)
@Table(name = "MARCA", schema = "dbo", catalog = "BDBRUCE")
public class Marca implements java.io.Serializable {

    private String idTrabajador;
    private Date fecha;
    private String idMarca;
    private String hmarca;
    private boolean automatico;
    private boolean situacion;

    private int dia;
    private int mes;
    private int anio;
    private String fechaTemp;
    private String trabajador;

    public Marca() {
    }

    public Marca(String idTrabajador, String idMarca, Date fecha, String hmarca, boolean situacion) {
        this.idTrabajador = idTrabajador;
        this.idMarca = idMarca;
        this.fecha = fecha;
        this.hmarca = hmarca;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false, length = 10)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Id
    @Column(name = "ID_MARCA", nullable = false)
    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    @Column(name = "HMARCA", nullable = false)
    public String getHmarca() {
        return hmarca;
    }

    public void setHmarca(String hmarca) {
        this.hmarca = hmarca;
    }

    @Column(name = "AUTOMATICO", nullable = false)
    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Transient
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Transient
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Transient
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Transient
    public String getFechaTemp() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(this.fecha);
    }

    public void setFechaTemp(String fechaTemp) {
        this.fechaTemp = fechaTemp;
    }

    @Transient
    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
}
