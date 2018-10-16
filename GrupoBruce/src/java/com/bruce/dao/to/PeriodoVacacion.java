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
@Table(name = "PERIODO_VACACION", schema = "dbo", catalog = "BDBRUCE")
public class PeriodoVacacion implements java.io.Serializable {

    private int idPVacacion;
    private Date limInicio;
    private Date limFin;
    private boolean cerrado;
    private boolean situacion;

    public PeriodoVacacion() {
    }

    public PeriodoVacacion(int idPVacacion, Date limInicio, Date limFin, boolean cerrado, boolean situacion) {
        this.idPVacacion = idPVacacion;
        this.limInicio = limInicio;
        this.limFin = limFin;
        this.cerrado = cerrado;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_PVACACION", nullable = false, unique = true)
    public int getIdPVacacion() {
        return idPVacacion;
    }

    public void setIdPVacacion(int idPVacacion) {
        this.idPVacacion = idPVacacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "LIM_INICIO", nullable = false, length = 10)
    public Date getLimInicio() {
        return limInicio;
    }

    public void setLimInicio(Date limInicio) {
        this.limInicio = limInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "LIM_FIN", nullable = false, length = 10)
    public Date getLimFin() {
        return limFin;
    }

    public void setLimFin(Date limFin) {
        this.limFin = limFin;
    }

    @Column(name = "CERRADO", nullable = false)
    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
