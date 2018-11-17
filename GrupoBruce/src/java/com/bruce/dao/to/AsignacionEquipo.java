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

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ASIGNACION_EQUIPO", schema = "dbo", catalog = "BDBRUCE")
public class AsignacionEquipo implements java.io.Serializable {

    private String idAequipo;
    private Date fecha;
    private String nroIp;
    private String nomUsu;
    private String pasUsu;
    private String idAsignador;
    private String idRecepcionador;

    private String recepcionador;

    public AsignacionEquipo() {
    }

    public AsignacionEquipo(String idAequipo, Date fecha, String nroIp, String nomUsu, String pasUsu, String idAsignador, String idRecepcionador) {
        this.idAequipo = idAequipo;
        this.fecha = fecha;
        this.nroIp = nroIp;
        this.nomUsu = nomUsu;
        this.pasUsu = pasUsu;
        this.idAsignador = idAsignador;
        this.idRecepcionador = idRecepcionador;
    }

    @Id
    @Column(name = "ID_AEQUIPO", nullable = false)
    public String getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(String idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "NRO_IP", nullable = false)
    public String getNroIp() {
        return nroIp;
    }

    public void setNroIp(String nroIp) {
        this.nroIp = nroIp;
    }

    @Column(name = "NOM_USU", nullable = false)
    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    @Column(name = "PAS_USU")
    public String getPasUsu() {
        return pasUsu;
    }

    public void setPasUsu(String pasUsu) {
        this.pasUsu = pasUsu;
    }

    @Column(name = "ID_ASIGNADOR", nullable = false)
    public String getIdAsignador() {
        return idAsignador;
    }

    public void setIdAsignador(String idAsignador) {
        this.idAsignador = idAsignador;
    }

    @Column(name = "ID_RECEPCIONADOR", nullable = false)
    public String getIdRecepcionador() {
        return idRecepcionador;
    }

    public void setIdRecepcionador(String idRecepcionador) {
        this.idRecepcionador = idRecepcionador;
    }

    @Column(name="RECEPCIONADOR", nullable = false)
    public String getRecepcionador() {
        return recepcionador;
    }

    public void setRecepcionador(String recepcionador) {
        this.recepcionador = recepcionador;
    }
}
