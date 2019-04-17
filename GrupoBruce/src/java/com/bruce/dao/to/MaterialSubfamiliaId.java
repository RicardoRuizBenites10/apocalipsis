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
public class MaterialSubfamiliaId implements java.io.Serializable {

    private int idFamilia;
    private int idSubfamilia;

    public MaterialSubfamiliaId() {
    }

    @Column(name = "ID_FAMILIA", nullable = false)
    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    @Column(name = "ID_SUBFAMILIA", nullable = false)
    public int getIdSubfamilia() {
        return idSubfamilia;
    }

    public void setIdSubfamilia(int idSubfamilia) {
        this.idSubfamilia = idSubfamilia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idFamilia;
        hash = 17 * hash + this.idSubfamilia;
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
        final MaterialSubfamiliaId other = (MaterialSubfamiliaId) obj;
        if (this.idFamilia != other.idFamilia) {
            return false;
        }
        if (this.idSubfamilia != other.idSubfamilia) {
            return false;
        }
        return true;
    }
}
