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
public class RequerimientoActividadId implements java.io.Serializable {

    private int idObra;
    private int idEspecifiacion;
    private int idActividad;

    public RequerimientoActividadId() {
    }

    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecifiacion() {
        return idEspecifiacion;
    }

    public void setIdEspecifiacion(int idEspecifiacion) {
        this.idEspecifiacion = idEspecifiacion;
    }

    @Column(name = "ID_ACTIVIDAD", nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idObra;
        hash = 67 * hash + this.idEspecifiacion;
        hash = 67 * hash + this.idActividad;
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
        final RequerimientoActividadId other = (RequerimientoActividadId) obj;
        if (this.idObra != other.idObra) {
            return false;
        }
        if (this.idEspecifiacion != other.idEspecifiacion) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        return true;
    }
}
