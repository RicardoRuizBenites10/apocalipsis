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
public class CarroceriaTipoId implements java.io.Serializable {

    private String idCarmod;
    private String idCartip;

    public CarroceriaTipoId() {
    }

    @Column(name = "ID_CARMOD", nullable = false)
    public String getIdCarmod() {
        return idCarmod;
    }

    public void setIdCarmod(String idCarmod) {
        this.idCarmod = idCarmod;
    }

    @Column(name = "ID_CARTIP", nullable = false)
    public String getIdCartip() {
        return idCartip;
    }

    public void setIdCartip(String idCartip) {
        this.idCartip = idCartip;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.idCarmod);
        hash = 43 * hash + Objects.hashCode(this.idCartip);
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
        final CarroceriaTipoId other = (CarroceriaTipoId) obj;
        if (!Objects.equals(this.idCarmod, other.idCarmod)) {
            return false;
        }
        if (!Objects.equals(this.idCartip, other.idCartip)) {
            return false;
        }
        return true;
    }
}
