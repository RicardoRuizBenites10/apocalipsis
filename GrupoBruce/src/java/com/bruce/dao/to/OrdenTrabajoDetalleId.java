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
public class OrdenTrabajoDetalleId implements java.io.Serializable {

    private int idOtrabajo;
    private int anio;
    private int serie;
    private int idTrabajo;
    private int idObra;

    public OrdenTrabajoDetalleId() {
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

    @Column(name = "ID_TRABAJO", nullable = false)
    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idOtrabajo;
        hash = 53 * hash + this.anio;
        hash = 53 * hash + this.serie;
        hash = 53 * hash + this.idTrabajo;
        hash = 53 * hash + this.idObra;
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
        final OrdenTrabajoDetalleId other = (OrdenTrabajoDetalleId) obj;
        if (this.idOtrabajo != other.idOtrabajo) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.serie != other.serie) {
            return false;
        }
        if (this.idTrabajo != other.idTrabajo) {
            return false;
        }
        if (this.idObra != other.idObra) {
            return false;
        }
        return true;
    }
}
