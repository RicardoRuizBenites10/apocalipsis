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
    private int idCargo;
    private int idFuncion;

    public FuncionId() {
    }

    public FuncionId(String idArea, int idCargo, int idFuncion) {
        this.idArea = idArea;
        this.idCargo = idCargo;
        this.idFuncion = idFuncion;
    }

    @Column(name = "ID_AREA", nullable = false, length = 5)
    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    @Column(name = "ID_CARGO", nullable = false)
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    @Column(name = "ID_FUNCION", nullable = false)
    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idArea);
        hash = 37 * hash + this.idCargo;
        hash = 37 * hash + this.idFuncion;
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
        if (this.idCargo != other.idCargo) {
            return false;
        }
        if (this.idFuncion != other.idFuncion) {
            return false;
        }
        if (!Objects.equals(this.idArea, other.idArea)) {
            return false;
        }
        return true;
    }
}
