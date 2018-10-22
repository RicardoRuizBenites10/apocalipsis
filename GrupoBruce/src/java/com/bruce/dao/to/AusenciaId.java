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
 * @author RICARDO
 */
public class AusenciaId implements java.io.Serializable{

    private String idTrabajador;
    private int idAusencia;

    public AusenciaId() {
    }

    public AusenciaId(String idTrabajador, int idAusencia) {
        this.idTrabajador = idTrabajador;
        this.idAusencia = idAusencia;
    }

    @Column(name = "ID_TRABAJADOR", nullable = false, length = 15)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Column(name = "ID_AUSENCIA", nullable = false)
    public int getIdAusencia() {
        return idAusencia;
    }

    public void setIdAusencia(int idAusencia) {
        this.idAusencia = idAusencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idTrabajador);
        hash = 53 * hash + this.idAusencia;
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
        final AusenciaId other = (AusenciaId) obj;
        if (this.idAusencia != other.idAusencia) {
            return false;
        }
        if (!Objects.equals(this.idTrabajador, other.idTrabajador)) {
            return false;
        }
        return true;
    }

}
