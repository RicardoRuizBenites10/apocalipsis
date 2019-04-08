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
 * @author RICARDO
 */
@Entity
@Table(name = "CALENDARIO", schema = "dbo", catalog = "BDBRUCE")
public class Calendario implements java.io.Serializable {

    private Date fecha;
    private int nroSemana;
    private int dia;
    private int mes;
    private int anio;
    private boolean libre;
    private boolean refrigerio;
    private boolean especial;
    private String descripcion;
    private String horaEntrada;
    private String horaSalida;
    private int idDia;

    public Calendario() {
    }

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "NRO_SEMANA", nullable = false)
    public int getNroSemana() {
        return nroSemana;
    }

    public void setNroSemana(int nroSemana) {
        this.nroSemana = nroSemana;
    }

    @Column(name = "DIA", nullable = false)
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Column(name = "MES", nullable = false)
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Column(name = "ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

    @Column(name = "ESPECIAL", nullable = false)
    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "HORA_ENTRADA")
    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Column(name = "HORA_SALIDA")
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Column(name = "ID_DIA", nullable = false)
    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }
}
