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
public class ConceptoAsignadoId implements java.io.Serializable {

    private int idTtrabajador;
    private String idTplanilla;
    private String idConcepto;

    public ConceptoAsignadoId() {
    }

    public ConceptoAsignadoId(int idTtrabajador, String idTplanilla, String idConcepto) {
        this.idTtrabajador = idTtrabajador;
        this.idTplanilla = idTplanilla;
        this.idConcepto = idConcepto;
    }

    @Column(name = "ID_TTRABAJADOR", nullable = false)
    public int getIdTtrabajador() {
        return idTtrabajador;
    }

    public void setIdTtrabajador(int idTtrabajador) {
        this.idTtrabajador = idTtrabajador;
    }

    @Column(name = "ID_TPLANILLA", nullable = false)
    public String getIdTplanilla() {
        return idTplanilla;
    }

    public void setIdTplanilla(String idTplanilla) {
        this.idTplanilla = idTplanilla;
    }

    @Column(name = "ID_CONCEPTO", nullable = false)
    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idTtrabajador;
        hash = 83 * hash + Objects.hashCode(this.idTplanilla);
        hash = 83 * hash + Objects.hashCode(this.idConcepto);
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
        final ConceptoAsignadoId other = (ConceptoAsignadoId) obj;
        if (this.idTtrabajador != other.idTtrabajador) {
            return false;
        }
        if (!Objects.equals(this.idTplanilla, other.idTplanilla)) {
            return false;
        }
        if (!Objects.equals(this.idConcepto, other.idConcepto)) {
            return false;
        }
        return true;
    }
}
