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
public class MantenimientoProcesoId implements java.io.Serializable {

    private String idAequipo;
    private String idMantenimiento;
    private String idMproceso;

    public MantenimientoProcesoId() {
    }

    public MantenimientoProcesoId(String idAequipo, String idMantenimiento, String idMproceso) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
        this.idMproceso = idMproceso;
    }

    @Column(name = "ID_AEQUIPO", nullable = false)
    public String getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(String idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Column(name = "ID_MANTENIMIENTO", nullable = false)
    public String getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(String idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    @Column(name = "ID_MPROCESO", nullable = false)
    public String getIdMproceso() {
        return idMproceso;
    }

    public void setIdMproceso(String idMproceso) {
        this.idMproceso = idMproceso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idAequipo);
        hash = 71 * hash + Objects.hashCode(this.idMantenimiento);
        hash = 71 * hash + Objects.hashCode(this.idMproceso);
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
        final MantenimientoProcesoId other = (MantenimientoProcesoId) obj;
        if (!Objects.equals(this.idAequipo, other.idAequipo)) {
            return false;
        }
        if (!Objects.equals(this.idMantenimiento, other.idMantenimiento)) {
            return false;
        }
        if (!Objects.equals(this.idMproceso, other.idMproceso)) {
            return false;
        }
        return true;
    }
}
