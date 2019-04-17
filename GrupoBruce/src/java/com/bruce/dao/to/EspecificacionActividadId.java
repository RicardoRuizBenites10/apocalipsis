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
public class EspecificacionActividadId implements java.io.Serializable {

    private int idEspecificacion;
    private int idActividad;

    public EspecificacionActividadId() {
    }

    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    public int getIdActividad() {
        return idActividad;
    }

    @Column(name = "ID_ACTIVIDAD", nullable = false)
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idEspecificacion;
        hash = 23 * hash + this.idActividad;
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
        final EspecificacionActividadId other = (EspecificacionActividadId) obj;
        if (this.idEspecificacion != other.idEspecificacion) {
            return false;
        }
        if (this.idActividad != other.idActividad) {
            return false;
        }
        return true;
    }
}
