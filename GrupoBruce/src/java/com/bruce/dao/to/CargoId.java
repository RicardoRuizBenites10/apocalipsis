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
public class CargoId implements java.io.Serializable {

    private String idArea;
    private String idCargo;

    public CargoId() {
    }

    public CargoId(String idArea, String idCargo) {
        this.idArea = idArea;
        this.idCargo = idCargo;
    }

    @Column(name = "ID_AREA", nullable = false, length = 5)
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idArea);
        hash = 97 * hash + Objects.hashCode(this.idCargo);
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
        final CargoId other = (CargoId) obj;
        if (!Objects.equals(this.idArea, other.idArea)) {
            return false;
        }
        if (!Objects.equals(this.idCargo, other.idCargo)) {
            return false;
        }
        return true;
    }
}
