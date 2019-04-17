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
public class OrdenTrabajoAmortizacionId implements java.io.Serializable {

    private int idOtrabajo;
    private int anio;
    private int serie;
    private int idAmortizacion;

    public OrdenTrabajoAmortizacionId() {
    }

    @Column(name="ID_OTRABAJO", nullable = false)
    public int getIdOtrabajo() {
        return idOtrabajo;
    }

    public void setIdOtrabajo(int idOtrabajo) {
        this.idOtrabajo = idOtrabajo;
    }

    @Column(name="ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Column(name="SERIE", nullable = false)
    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Column(name="ID_AMORTIZACION", nullable = false)
    public int getIdAmortizacion() {
        return idAmortizacion;
    }

    public void setIdAmortizacion(int idAmortizacion) {
        this.idAmortizacion = idAmortizacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idOtrabajo;
        hash = 11 * hash + this.anio;
        hash = 11 * hash + this.serie;
        hash = 11 * hash + this.idAmortizacion;
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
        final OrdenTrabajoAmortizacionId other = (OrdenTrabajoAmortizacionId) obj;
        if (this.idOtrabajo != other.idOtrabajo) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.serie != other.serie) {
            return false;
        }
        if (this.idAmortizacion != other.idAmortizacion) {
            return false;
        }
        return true;
    }
}
