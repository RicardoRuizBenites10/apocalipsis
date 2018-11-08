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
public class MantenimientoDetalleId implements java.io.Serializable {

    private int idAequipo;
    private String idMantenimiento;
    private String idEinformatico;

    public MantenimientoDetalleId() {
    }

    public MantenimientoDetalleId(int idAequipo, String idMantenimiento, String idEinformatico) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
        this.idEinformatico = idEinformatico;
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

    @Column(name = "ID_EINFORMATICO", nullable = false)
    public String getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(String idEinformatico) {
        this.idEinformatico = idEinformatico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idAequipo;
        hash = 79 * hash + Objects.hashCode(this.idMantenimiento);
        hash = 79 * hash + Objects.hashCode(this.idEinformatico);
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
        final MantenimientoDetalleId other = (MantenimientoDetalleId) obj;
        if (this.idAequipo != other.idAequipo) {
            return false;
        }
        if (!Objects.equals(this.idMantenimiento, other.idMantenimiento)) {
            return false;
        }
        if (!Objects.equals(this.idEinformatico, other.idEinformatico)) {
            return false;
        }
        return true;
    }

}
