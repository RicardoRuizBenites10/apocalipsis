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
public class MaterialId implements java.io.Serializable {

    private String idEmpresa;
    private String idSucursal;
    private int idMaterial;

    public MaterialId() {
    }

    @Column(name="ID_EMPRESA", nullable = false)
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Column(name="ID_SUCURSAL", nullable = false)
    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Column(name="ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idEmpresa);
        hash = 59 * hash + Objects.hashCode(this.idSucursal);
        hash = 59 * hash + this.idMaterial;
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
        final MaterialId other = (MaterialId) obj;
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        if (!Objects.equals(this.idEmpresa, other.idEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.idSucursal, other.idSucursal)) {
            return false;
        }
        return true;
    }
}
