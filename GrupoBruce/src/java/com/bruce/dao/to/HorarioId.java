/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.util.Objects;
import javax.persistence.Column;

/**
 *
 * @author SISTEMAS
 */
public class HorarioId implements java.io.Serializable {

    private String idTurno;
    private int idDia;

    public HorarioId() {
    }

    public HorarioId(String idTurno, int idDia) {
        this.idTurno = idTurno;
        this.idDia = idDia;
    }

    @Column(name = "ID_TURNO", nullable = false)
    public String getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    @Column(name = "ID_DIA", nullable = false)
    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idTurno);
        hash = 59 * hash + this.idDia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HorarioId other = (HorarioId) obj;
        if (this.idDia != other.idDia) {
            return false;
        }
        if (!Objects.equals(this.idTurno, other.idTurno)) {
            return false;
        }
        return true;
    }
}
