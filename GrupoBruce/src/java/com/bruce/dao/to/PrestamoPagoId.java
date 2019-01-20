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
public class PrestamoPagoId implements java.io.Serializable {

    private String idPrestamo;
    private String idPpago;

    public PrestamoPagoId() {
    }

    @Column(name="ID_PRESTAMO", nullable = false)
    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Column(name="ID_PPAGO", nullable = false)
    public String getIdPpago() {
        return idPpago;
    }

    public void setIdPpago(String idPpago) {
        this.idPpago = idPpago;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idPrestamo);
        hash = 83 * hash + Objects.hashCode(this.idPpago);
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
        final PrestamoPagoId other = (PrestamoPagoId) obj;
        if (!Objects.equals(this.idPrestamo, other.idPrestamo)) {
            return false;
        }
        if (!Objects.equals(this.idPpago, other.idPpago)) {
            return false;
        }
        return true;
    }
}
