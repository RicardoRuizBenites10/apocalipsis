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
public class ProgramaTrabajoId implements java.io.Serializable {

    private String idContratista;
    private int idTrabajo;
    private int idObra;

    public ProgramaTrabajoId() {
    }

    @Column(name = "ID_CONTRATISTA", nullable = false)
    public String getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(String idContratista) {
        this.idContratista = idContratista;
    }

    @Column(name = "ID_TRABAJO", nullable = false)
    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idContratista);
        hash = 89 * hash + this.idTrabajo;
        hash = 89 * hash + this.idObra;
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
        final ProgramaTrabajoId other = (ProgramaTrabajoId) obj;
        if (this.idTrabajo != other.idTrabajo) {
            return false;
        }
        if (this.idObra != other.idObra) {
            return false;
        }
        if (!Objects.equals(this.idContratista, other.idContratista)) {
            return false;
        }
        return true;
    }
}
