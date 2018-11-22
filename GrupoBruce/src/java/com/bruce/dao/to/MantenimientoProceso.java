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
@Table(name = "MANTENIMIENTO_PROCESO", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = MantenimientoProcesoId.class)
public class MantenimientoProceso implements java.io.Serializable {

    private String idAequipo;
    private String idMantenimiento;
    private String idMproceso;
    private Date fecha;
    private String observacion;
    private String idEmantenimiento;
    private String idGenerador;
    private String idSolucionador;

    public MantenimientoProceso() {
    }

    public MantenimientoProceso(String idAequipo, String idMantenimiento, String idEmantenimiento, Date fecha, String observacion, String idGenerador, String idSolucionador) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
        this.idEmantenimiento = idEmantenimiento;
        this.fecha = fecha;
        this.observacion = observacion;
        this.idGenerador = idGenerador;
        this.idSolucionador = idSolucionador;
    }

    @Id
    @Column(name = "ID_AEQUIPO", nullable = false)
    public String getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(String idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Id
    @Column(name = "ID_MANTENIMIENTO", nullable = false)
    public String getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(String idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    @Id
    @Column(name = "ID_MPROCESO", nullable = false)
    public String getIdMproceso() {
        return idMproceso;
    }

    public void setIdMproceso(String idMproceso) {
        this.idMproceso = idMproceso;
    }

    @Column(name = "ID_EMANTENIMIENTO", nullable = false)
    public String getIdEmantenimiento() {
        return idEmantenimiento;
    }

    public void setIdEmantenimiento(String idEmantenimiento) {
        this.idEmantenimiento = idEmantenimiento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Column(name = "ID_GENERADOR", nullable = false)
    public String getIdGenerador() {
        return idGenerador;
    }

    public void setIdGenerador(String idGenerador) {
        this.idGenerador = idGenerador;
    }

    @Column(name = "ID_SOLUCIONADOR")
    public String getIdSolucionador() {
        return idSolucionador;
    }

    public void setIdSolucionador(String idSolucionador) {
        this.idSolucionador = idSolucionador;
    }
}
