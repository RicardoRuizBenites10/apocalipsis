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
public class MaterialUnidadId implements java.io.Serializable {

    private String idEmpresa;
    private String idSucursal;
    private int idMaterial;
    private String idUmedida;

    public MaterialUnidadId() {
    }

    @Column(name="ID_EMPRESA",nullable = false)
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Column(name="ID_SUCURSAL",nullable = false)
    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Column(name="ID_MATERIAL",nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name="ID_UMEDIDA",nullable = false)
    public String getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(String idUmedida) {
        this.idUmedida = idUmedida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.idEmpresa);
        hash = 41 * hash + Objects.hashCode(this.idSucursal);
        hash = 41 * hash + this.idMaterial;
        hash = 41 * hash + Objects.hashCode(this.idUmedida);
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
        final MaterialUnidadId other = (MaterialUnidadId) obj;
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        if (!Objects.equals(this.idEmpresa, other.idEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.idSucursal, other.idSucursal)) {
            return false;
        }
        if (!Objects.equals(this.idUmedida, other.idUmedida)) {
            return false;
        }
        return true;
    }
    
}
