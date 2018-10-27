package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import java.util.Objects;
import javax.persistence.Column;

/**
 * ContratoTrabajadorId generated by hbm2java
 */
public class ContratoTrabajadorId implements java.io.Serializable {

    private String idTrabajador;
    private int idContrato;

    public ContratoTrabajadorId() {
    }

    public ContratoTrabajadorId(String idTrabajador, int idContrato) {
        this.idTrabajador = idTrabajador;
        this.idContrato = idContrato;
    }

    @Column(name = "ID_TRABAJADOR", nullable = false, length = 15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Column(name = "ID_CONTRATO", nullable = false)
    public int getIdContrato() {
        return this.idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idTrabajador);
        hash = 29 * hash + this.idContrato;
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
        final ContratoTrabajadorId other = (ContratoTrabajadorId) obj;
        if (this.idContrato != other.idContrato) {
            return false;
        }
        if (!Objects.equals(this.idTrabajador, other.idTrabajador)) {
            return false;
        }
        return true;
    }

}
