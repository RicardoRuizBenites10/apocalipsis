/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "HORARIO", schema = "dbo", catalog = "BDBRUCE")
public class Horario implements java.io.Serializable {

    private int idHorario;
    private String horaEntrada;
    private String horaSalida;
    private boolean situacion;
    private int idDia;

    private String dia;

    public Horario() {
    }

    @Id
    @Column(name = "ID_HORARIO", nullable = false)
    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
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

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "ID_DIA", nullable = false)
    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
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
