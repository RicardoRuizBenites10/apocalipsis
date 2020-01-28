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
@IdClass(value = ObraSeguimientoId.class)
@Table(name = "OBRA_SEGUIMIENTO", schema = "dbo", catalog = "BDBRUCE")
public class ObraSeguimiento implements java.io.Serializable {

    private int idObra;
    private String idEproceso;
    private Date inicioProgramado;
    private Date finProgramado;
    private Date inicio;
    private Date fin;
    private String observacion;
    private boolean ubicacion;
    private String idUsuario;

    private String etapa;
    private int orden;

    public ObraSeguimiento() {
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
    @Column(name = "ID_EPROCESO", nullable = false)
    public String getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(String idEproceso) {
        this.idEproceso = idEproceso;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "INICIO_PROGRAMADO", nullable = false)
    public Date getInicioProgramado() {
        return inicioProgramado;
    }

    public void setInicioProgramado(Date inicioProgramado) {
        this.inicioProgramado = inicioProgramado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FIN_PROGRAMADO", nullable = false)
    public Date getFinProgramado() {
        return finProgramado;
    }

    public void setFinProgramado(Date finProgramado) {
        this.finProgramado = finProgramado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "INICIO", nullable = true)
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FIN", nullable = true)
    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Column(name = "OBSERVACION", nullable = true)
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(name = "UBICACION", nullable = false)
    public boolean isUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(boolean ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Column(name = "ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "ETAPA", insertable = false, updatable = false)
    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "ORDEN", insertable = false, updatable = false)
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
