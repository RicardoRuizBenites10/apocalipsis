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
@IdClass(value = ProgramaTrabajoId.class)
@Table(name = "PROGRAMA_TRABAJO", schema = "dbo", catalog = "BDBRUCE")
public class ProgramaTrabajo implements java.io.Serializable {

    private String idContratista;
    private int idTrabajo;
    private int idObra;
    private Date fecha;
    private float cantidad;
    private boolean terminado;
    private boolean otGenerado;
    private String otNumero;
    private String idUsuario;

    public ProgramaTrabajo() {
    }

    @Id
    @Column(name = "ID_CONTRATISTA", nullable = false)
    public String getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(String idContratista) {
        this.idContratista = idContratista;
    }

    @Id
    @Column(name = "ID_TRABAJO", nullable = false)
    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "CANTIDAD", nullable = false)
    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "TERMINADO", nullable = false)
    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    @Column(name = "OT_GENERADO", nullable = false)
    public boolean isOtGenerado() {
        return otGenerado;
    }

    public void setOtGenerado(boolean otGenerado) {
        this.otGenerado = otGenerado;
    }

    @Column(name = "OT_NUMERO")
    public String getOtNumero() {
        return otNumero;
    }

    public void setOtNumero(String otNumero) {
        this.otNumero = otNumero;
    }

    @Column(name = "ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
