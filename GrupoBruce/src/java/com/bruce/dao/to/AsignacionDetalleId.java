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

    private String idAequipo;
    private String idAdetalle;

    public AsignacionDetalleId() {
    }

    public AsignacionDetalleId(String idAequipo, String idAdetalle) {
        this.idAequipo = idAequipo;
        this.idAdetalle = idAdetalle;
    }

    @Column(name = "ID_AEQUIPO", nullable = false)
    public String getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(String idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Column(name = "ID_ADETALLE", nullable = false)
    public String getIdAdetalle() {
        return idAdetalle;
    }

    public void setIdAdetalle(String idAdetalle) {
        this.idAdetalle = idAdetalle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idAequipo);
        hash = 79 * hash + Objects.hashCode(this.idAdetalle);
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
        if (!Objects.equals(this.idAequipo, other.idAequipo)) {
            return false;
        }
        if (!Objects.equals(this.idAdetalle, other.idAdetalle)) {
            return false;
        }
        return true;
    }

}
