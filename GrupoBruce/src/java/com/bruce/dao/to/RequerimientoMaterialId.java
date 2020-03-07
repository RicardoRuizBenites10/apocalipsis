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
public class RequerimientoMaterialId implements java.io.Serializable {

    private int idRequerimiento;
    private int idMaterial;

    public RequerimientoMaterialId() {
    }

    @Column(name = "ID_REQUERIMIENTO", nullable = false)
    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
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
        hash = 97 * hash + this.idRequerimiento;
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
        final RequerimientoMaterialId other = (RequerimientoMaterialId) obj;
        if (this.idRequerimiento != other.idRequerimiento) {
            return false;
        }
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        return true;
    }
}
