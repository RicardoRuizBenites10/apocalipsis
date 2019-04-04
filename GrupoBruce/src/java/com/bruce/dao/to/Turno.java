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

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "TURNO", schema = "dbo", catalog = "BDBRUCE")
public class Turno implements java.io.Serializable {

    private String idTurno;
    private String descripcion;
    private boolean actual;
    private int mlbSemana;
    private int dlbSemana;

    public Turno() {
    }

    public Turno(String idTurno, String descripcion, boolean actual) {
        this.idTurno = idTurno;
        this.descripcion = descripcion;
        this.actual = actual;
    }

    @Id
    @Column(name = "ID_TURNO", nullable = false)
    public String getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "ACTUAL", nullable = false)
    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    @Column(name = "MLB_SEMANA", nullable = false)
    public int getMlbSemana() {
        return mlbSemana;
    }

    public void setMlbSemana(int mlbSemana) {
        this.mlbSemana = mlbSemana;
    }

    @Column(name = "DLB_SEMANA", nullable = false)
    public int getDlbSemana() {
        return dlbSemana;
    }

    public void setDlbSemana(int dlbSemana) {
        this.dlbSemana = dlbSemana;
    }
}
