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
public class TrabajoMaterialId implements java.io.Serializable {

    private int idTrabajador;
    private int idMaterial;

    public TrabajoMaterialId() {
    }

    @Column(name = "ID_TRABAJADOR", nullable = false)
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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
        int hash = 3;
        hash = 97 * hash + this.idTrabajador;
        hash = 97 * hash + this.idMaterial;
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
        final TrabajoMaterialId other = (TrabajoMaterialId) obj;
        if (this.idTrabajador != other.idTrabajador) {
            return false;
        }
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        return true;
    }
}
