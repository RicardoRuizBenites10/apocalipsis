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
public class ObraPinturaId implements java.io.Serializable {

    private int idObra;
    private String idCdiseno;

    public ObraPinturaId() {
    }

    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "ID_CDISENO", nullable = false)
    public String getIdCdiseno() {
        return idCdiseno;
    }

    public void setIdCdiseno(String idCdiseno) {
        this.idCdiseno = idCdiseno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idObra;
        hash = 47 * hash + Objects.hashCode(this.idCdiseno);
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
        final ObraPinturaId other = (ObraPinturaId) obj;
        if (this.idObra != other.idObra) {
            return false;
        }
        if (!Objects.equals(this.idCdiseno, other.idCdiseno)) {
            return false;
        }
        return true;
    }
}
