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
public class PlanillaId implements java.io.Serializable {

    private int idPplanilla;
    private String idTrabajador;
    private String idTplanilla;
    private String idTtrabajador;
    private String idConcepto;

    public PlanillaId() {
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

    @Column(name = "ID_TPLANILLA", nullable = false)
    public String getIdTplanilla() {
        return idTplanilla;
    }

    public void setIdTplanilla(String idTplanilla) {
        this.idTplanilla = idTplanilla;
    }

    @Column(name = "ID_TTRABAJADOR", nullable = false)
    public String getIdTtrabajador() {
        return idTtrabajador;
    }

    public void setIdTtrabajador(String idTtrabajador) {
        this.idTtrabajador = idTtrabajador;
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
        hash = 43 * hash + this.idPplanilla;
        hash = 43 * hash + Objects.hashCode(this.idTrabajador);
        hash = 43 * hash + Objects.hashCode(this.idTplanilla);
        hash = 43 * hash + Objects.hashCode(this.idTtrabajador);
        hash = 43 * hash + Objects.hashCode(this.idConcepto);
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
        final PlanillaId other = (PlanillaId) obj;
        if (this.idPplanilla != other.idPplanilla) {
            return false;
        }
        if (!Objects.equals(this.idTrabajador, other.idTrabajador)) {
            return false;
        }
        if (!Objects.equals(this.idTplanilla, other.idTplanilla)) {
            return false;
        }
        if (!Objects.equals(this.idTtrabajador, other.idTtrabajador)) {
            return false;
        }
        if (!Objects.equals(this.idConcepto, other.idConcepto)) {
            return false;
        }
        return true;
    }
}
