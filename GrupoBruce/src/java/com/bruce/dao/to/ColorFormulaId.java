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
public class ColorFormulaId implements java.io.Serializable {

    private String idCdiseno;
    private int idMaterial;

    public ColorFormulaId() {
    }

    @Column(name = "ID_CDISENO", nullable = false)
    public String getIdCdiseno() {
        return idCdiseno;
    }

    public void setIdCdiseno(String idCdiseno) {
        this.idCdiseno = idCdiseno;
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idCdiseno);
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
        final ColorFormulaId other = (ColorFormulaId) obj;
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        if (!Objects.equals(this.idCdiseno, other.idCdiseno)) {
            return false;
        }
        return true;
    }
}
