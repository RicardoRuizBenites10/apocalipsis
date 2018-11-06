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
public class AsignacionDetalleId implements java.io.Serializable {

    private int idAequipo;
    private int idEinformatico;

    public AsignacionDetalleId() {
    }

    public AsignacionDetalleId(int idAequipo, int idEinformatico) {
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
    public int getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(int idEinformatico) {
        this.idEinformatico = idEinformatico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idAequipo;
        hash = 47 * hash + this.idEinformatico;
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
        if (this.idEinformatico != other.idEinformatico) {
            return false;
        }
        return true;
    }
}
