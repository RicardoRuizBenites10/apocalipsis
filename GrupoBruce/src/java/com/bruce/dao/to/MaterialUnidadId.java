/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.util.Objects;
import javax.persistence.Column;

/**
 *
 * @author SISTEMAS
 */
public class MaterialUnidadId implements java.io.Serializable {

    private int idMaterial;
    private String idUmedida;

    public MaterialUnidadId() {
    }

    @Column(name="ID_MATERIAL",nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name="ID_UMEDIDA",nullable = false)
    public String getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(String idUmedida) {
        this.idUmedida = idUmedida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idMaterial;
        hash = 79 * hash + Objects.hashCode(this.idUmedida);
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
        final MaterialUnidadId other = (MaterialUnidadId) obj;
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        if (!Objects.equals(this.idUmedida, other.idUmedida)) {
            return false;
        }
        return true;
    }
}
