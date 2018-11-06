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
public class MantenimientoId implements java.io.Serializable {

    private int idAequipo;
    private String idMantenimiento;

    public MantenimientoId() {
    }

    public MantenimientoId(int idAequipo, String idMantenimiento) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
    }

    @Column(name = "ID_AEQUIPO", nullable = false)
    public int getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(int idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Column(name = "ID_MANTENIMIENTO", nullable = false)
    public String getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(String idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idAequipo;
        hash = 29 * hash + Objects.hashCode(this.idMantenimiento);
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
        final MantenimientoId other = (MantenimientoId) obj;
        if (this.idAequipo != other.idAequipo) {
            return false;
        }
        if (!Objects.equals(this.idMantenimiento, other.idMantenimiento)) {
            return false;
        }
        return true;
    }
}
