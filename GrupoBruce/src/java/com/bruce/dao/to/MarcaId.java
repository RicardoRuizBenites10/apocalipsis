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
public class MarcaId implements java.io.Serializable {

    private String idTrabajador;
    private String idAsistencia;
    private String idMarca;

    public MarcaId() {
    }

    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Column(name = "ID_ASISTENCIA", nullable = false)
    public String getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(String idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    @Column(name = "ID_MARCA", nullable = false)
    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idTrabajador);
        hash = 97 * hash + Objects.hashCode(this.idAsistencia);
        hash = 97 * hash + Objects.hashCode(this.idMarca);
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
        final MarcaId other = (MarcaId) obj;
        if (!Objects.equals(this.idTrabajador, other.idTrabajador)) {
            return false;
        }
        if (!Objects.equals(this.idAsistencia, other.idAsistencia)) {
            return false;
        }
        if (!Objects.equals(this.idMarca, other.idMarca)) {
            return false;
        }
        return true;
    }

}
