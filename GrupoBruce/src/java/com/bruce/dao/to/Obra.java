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
@Table(name = "OBRA", schema = "dbo", catalog = "BDBRUCE")
public class Obra implements java.io.Serializable {

    private int idObra;
    private String nombre;
    private Date fecha;
    private Date fechaInicio;
    private Date fechaFin;
    private int idObrtip;
    private String idCliente;
    private String idProforma;

    private String tipo;
    private String cliente;
    
    public Obra() {
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO", nullable = false)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN", nullable = false)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "ID_OBRTIP", nullable = false)
    public int getIdObrtip() {
        return idObrtip;
    }

    public void setIdObrtip(int idObrtip) {
        this.idObrtip = idObrtip;
    }

    @Column(name = "ID_CLIENTE", nullable = false)
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Column(name = "ID_PROFORMA", nullable = false)
    public String getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(String idProforma) {
        this.idProforma = idProforma;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="TIPO",insertable = false,updatable = false)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="CLIENTE",insertable = false,updatable = false)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
