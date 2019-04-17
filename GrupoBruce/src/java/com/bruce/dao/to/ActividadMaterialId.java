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
public class ActividadMaterialId implements java.io.Serializable {

    private int idActividad;
    private int idMaterial;

    public ActividadMaterialId() {
    }

    @Column(name = "ID_ACTIVIDAD", nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idActividad;
        hash = 37 * hash + this.idMaterial;
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
        final ActividadMaterialId other = (ActividadMaterialId) obj;
        if (this.idActividad != other.idActividad) {
            return false;
        }
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        return true;
    }
}
