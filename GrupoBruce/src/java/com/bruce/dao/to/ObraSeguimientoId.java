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
public class ObraSeguimientoId implements java.io.Serializable {

    private int idObra;
    private String idEproceso;

    public ObraSeguimientoId() {
    }

    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "ID_EPROCESO", nullable = false)
    public String getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(String idEproceso) {
        this.idEproceso = idEproceso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idObra;
        hash = 79 * hash + Objects.hashCode(this.idEproceso);
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
        final ObraSeguimientoId other = (ObraSeguimientoId) obj;
        if (this.idObra != other.idObra) {
            return false;
        }
        if (!Objects.equals(this.idEproceso, other.idEproceso)) {
            return false;
        }
        return true;
    }
}
