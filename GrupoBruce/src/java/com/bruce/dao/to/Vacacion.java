package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vacacion generated by hbm2java
 */
@Entity
@Table(name = "VACACION", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = VacacionId.class)
public class Vacacion implements java.io.Serializable {

    private String idTrabajador;
    private int idPVacacion;
    private Date fechaBase;
    private Date fechaSalida;
    private Date fechaRetorno;
    private Integer diasTomados;
    private Integer diasComprados;
    private int idTVacacion;

    public Vacacion() {
    }

    public Vacacion(String idTrabajador, int idPVacacion, Date fechaBase, Date fechaSalida, Date fechaRetorno, Integer diasTomados, Integer diasComprados, int idTVacacion) {
        this.idTrabajador = idTrabajador;
        this.idPVacacion = idPVacacion;
        this.fechaBase = fechaBase;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.diasTomados = diasTomados;
        this.diasComprados = diasComprados;
        this.idTVacacion = idTVacacion;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false, length = 15)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_PVACACION", nullable = false)
    public int getIdPVacacion() {
        return idPVacacion;
    }

    public void setIdPVacacion(int idPVacacion) {
        this.idPVacacion = idPVacacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BASE", nullable = false, length = 10)
    public Date getFechaBase() {
        return fechaBase;
    }

    public void setFechaBase(Date fechaBase) {
        this.fechaBase = fechaBase;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_SALIDA", nullable = false, length = 10)
    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_RETORNO", nullable = false, length = 10)
    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    @Column(name = "DIAS_TOMADOS", nullable = false)
    public Integer getDiasTomados() {
        return diasTomados;
    }

    public void setDiasTomados(Integer diasTomados) {
        this.diasTomados = diasTomados;
    }

    @Column(name = "DIAS_COMPRADOS", nullable = false)
    public Integer getDiasComprados() {
        return diasComprados;
    }

    public void setDiasComprados(Integer diasComprados) {
        this.diasComprados = diasComprados;
    }
    
    @Column(name = "ID_TVACACION", nullable = false)
    public int getIdTVacacion() {
        return idTVacacion;
    }

    public void setIdTVacacion(int idTVacacion) {
        this.idTVacacion = idTVacacion;
    }

}
