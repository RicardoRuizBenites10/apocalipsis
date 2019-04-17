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
public class PlantillaId implements java.io.Serializable {

    private int idCarroceria;
    private int idEspecificacion;

    public PlantillaId() {
    }

    @Column(name = "ID_CARROCERIA", nullable = false)
    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idCarroceria;
        hash = 79 * hash + this.idEspecificacion;
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
        final PlantillaId other = (PlantillaId) obj;
        if (this.idCarroceria != other.idCarroceria) {
            return false;
        }
        if (this.idEspecificacion != other.idEspecificacion) {
            return false;
        }
        return true;
    }
}
