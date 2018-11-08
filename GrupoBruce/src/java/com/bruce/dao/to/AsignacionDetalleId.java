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
public class AsignacionDetalleId implements java.io.Serializable {

    private int idAequipo;
    private String idEinformatico;

    public AsignacionDetalleId() {
    }

    public AsignacionDetalleId(int idAequipo, String idEinformatico) {
        this.idAequipo = idAequipo;
        this.idEinformatico = idEinformatico;
    }

    @Column(name = "ID_AEQUIPO", nullable = false)
    public int getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(int idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Column(name = "ID_EINFORMATICO", nullable = false)
    public String getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(String idEinformatico) {
        this.idEinformatico = idEinformatico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idAequipo;
        hash = 97 * hash + Objects.hashCode(this.idEinformatico);
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
        final AsignacionDetalleId other = (AsignacionDetalleId) obj;
        if (this.idAequipo != other.idAequipo) {
            return false;
        }
        if (!Objects.equals(this.idEinformatico, other.idEinformatico)) {
            return false;
        }
        return true;
    }
}
