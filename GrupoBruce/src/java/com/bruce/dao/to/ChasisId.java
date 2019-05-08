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
public class ChasisId implements java.io.Serializable {

    private String idChapro;
    private int idChasis;

    public ChasisId() {
    }

    @Column(name = "ID_CHAPRO", nullable = false)
    public String getIdChapro() {
        return idChapro;
    }

    public void setIdChapro(String idChapro) {
        this.idChapro = idChapro;
    }

    @Column(name = "ID_CHASIS", nullable = false)
    public int getIdChasis() {
        return idChasis;
    }

    public void setIdChasis(int idChasis) {
        this.idChasis = idChasis;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idChapro);
        hash = 41 * hash + this.idChasis;
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
        final ChasisId other = (ChasisId) obj;
        if (this.idChasis != other.idChasis) {
            return false;
        }
        if (!Objects.equals(this.idChapro, other.idChapro)) {
            return false;
        }
        return true;
    }
}
