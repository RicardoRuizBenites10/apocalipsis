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
public class ObraContratistaId implements java.io.Serializable {

    private int idObra;
    private String idContratista;

    public ObraContratistaId() {
    }

    @Column(name="ID_OBRA", nullable=false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name="ID_CONTRATISTA", nullable=false)
    public String getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(String idContratista) {
        this.idContratista = idContratista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idObra;
        hash = 79 * hash + Objects.hashCode(this.idContratista);
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
        final ObraContratistaId other = (ObraContratistaId) obj;
        if (this.idObra != other.idObra) {
            return false;
        }
        if (!Objects.equals(this.idContratista, other.idContratista)) {
            return false;
        }
        return true;
    }

}
