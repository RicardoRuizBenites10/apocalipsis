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
public class PlanillaTareoId implements java.io.Serializable {

    private int idPplanilla;
    private String idTrabajador;

    public PlanillaTareoId() {
    }

    @Column(name = "ID_PPLANILLA", nullable = false)
    public int getIdPplanilla() {
        return idPplanilla;
    }

    public void setIdPplanilla(int idPplanilla) {
        this.idPplanilla = idPplanilla;
    }

    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idPplanilla;
        hash = 83 * hash + Objects.hashCode(this.idTrabajador);
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
        final PlanillaTareoId other = (PlanillaTareoId) obj;
        if (this.idPplanilla != other.idPplanilla) {
            return false;
        }
        if (!Objects.equals(this.idTrabajador, other.idTrabajador)) {
            return false;
        }
        return true;
    }
}
