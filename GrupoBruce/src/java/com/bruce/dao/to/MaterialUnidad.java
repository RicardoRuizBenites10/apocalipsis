/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = MaterialUnidadId.class)
@Table(name = "MATERIAL_UNIDAD", schema = "dbo", catalog = "BDBRUCE")
public class MaterialUnidad implements java.io.Serializable {

    private int idMaterial;
    private int idUmedida;
    private float precio;
    private boolean base;

    private String denominacion;

    public MaterialUnidad() {
    }

    @Id
    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Id
    @Column(name = "ID_UMEDIDA", nullable = false)
    public int getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(int idUmedida) {
        this.idUmedida = idUmedida;
    }

    @Column(name = "PRECIO", nullable = false)
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Column(name = "BASE", nullable = false)
    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "DENOMINACION", insertable = false, updatable = false)
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

}
