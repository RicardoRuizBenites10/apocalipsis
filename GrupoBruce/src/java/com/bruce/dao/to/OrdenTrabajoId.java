/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;

/**
 *
 * @author SISTEMAS
 */
public class OrdenTrabajoId implements java.io.Serializable {

    private int idOtrabajo;
    private int anio;
    private int serie;

    public OrdenTrabajoId() {
    }

    @Column(name = "ID_OTRABAJO", nullable = false)
    public int getIdOtrabajo() {
        return idOtrabajo;
    }

    public void setIdOtrabajo(int idOtrabajo) {
        this.idOtrabajo = idOtrabajo;
    }

    @Column(name = "ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Column(name = "SERIE", nullable = false)
    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idOtrabajo;
        hash = 97 * hash + this.anio;
        hash = 97 * hash + this.serie;
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
        final OrdenTrabajoId other = (OrdenTrabajoId) obj;
        if (this.idOtrabajo != other.idOtrabajo) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.serie != other.serie) {
            return false;
        }
        return true;
    }
}
