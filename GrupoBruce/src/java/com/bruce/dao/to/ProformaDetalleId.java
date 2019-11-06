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
public class ProformaDetalleId implements java.io.Serializable {

    private String idProforma;
    private int idEspecificacion;

    public ProformaDetalleId() {
    }

    @Column(name = "ID_PROFORMA", nullable = false)
    public String getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(String idProforma) {
        this.idProforma = idProforma;
    }

    @Column(name = "ID_ESPECIFICACION", nullable = false)
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idProforma);
        hash = 41 * hash + this.idEspecificacion;
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
        final ProformaDetalleId other = (ProformaDetalleId) obj;
        if (this.idEspecificacion != other.idEspecificacion) {
            return false;
        }
        if (!Objects.equals(this.idProforma, other.idProforma)) {
            return false;
        }
        return true;
    }
}
