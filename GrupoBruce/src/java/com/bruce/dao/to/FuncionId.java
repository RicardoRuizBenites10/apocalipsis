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
public class FuncionId implements java.io.Serializable {

    private String idArea;
    private String idCargo;
    private String idFuncion;

    public FuncionId() {
    }

    public FuncionId(String idArea, String idCargo, String idFuncion) {
        this.idArea = idArea;
        this.idCargo = idCargo;
        this.idFuncion = idFuncion;
    }

    @Column(name = "ID_AREA", nullable = false)
    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    @Column(name = "ID_CARGO", nullable = false)
    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    @Column(name = "ID_FUNCION", nullable = false)
    public String getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(String idFuncion) {
        this.idFuncion = idFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idArea);
        hash = 71 * hash + Objects.hashCode(this.idCargo);
        hash = 71 * hash + Objects.hashCode(this.idFuncion);
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
        final FuncionId other = (FuncionId) obj;
        if (!Objects.equals(this.idArea, other.idArea)) {
            return false;
        }
        if (!Objects.equals(this.idCargo, other.idCargo)) {
            return false;
        }
        if (!Objects.equals(this.idFuncion, other.idFuncion)) {
            return false;
        }
        return true;
    }
}
