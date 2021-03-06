/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = HorarioId.class)
@Table(name = "HORARIO", schema = "dbo", catalog = "BDBRUCE")
public class Horario implements java.io.Serializable {

    private String idTurno;
    private int idDia;
    private String horaEntrada;
    private String horaSalida;
    private boolean libre;
    private boolean refrigerio;
    private boolean situacion;

    private String dia;

    public Horario() {
    }

    @Id
    @Column(name = "ID_TURNO", nullable = false)
    public String getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    @Id
    @Column(name = "ID_DIA", nullable = false)
    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    @Column(name = "HORA_ENTRADA", nullable = false)
    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Column(name = "HORA_SALIDA", nullable = false)
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Column(name = "LIBRE", nullable = false)
    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    @Column(name = "REFRIGERIO", nullable = false)
    public boolean isRefrigerio() {
        return refrigerio;
    }

    public void setRefrigerio(boolean refrigerio) {
        this.refrigerio = refrigerio;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "DIA", insertable = false, updatable = false)
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

}
