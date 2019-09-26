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
@IdClass(value = ActividadMaterialId.class)
@Table(name = "ACTIVIDAD_MATERIAL", schema = "dbo", catalog = "BDBRUCE")
public class ActividadMaterial implements java.io.Serializable {

    private int idActividad;
    private int idMaterial;
    private float cantidad;
    private String idUmedida;

    private String material;
    private String unidad;

    public ActividadMaterial() {
    }

    @Id
    @Column(name = "ID_ACTIVIDAD", nullable = false)
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    @Id
    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name = "CANTIDAD", nullable = false)
    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "ID_UMEDIDA", nullable = false)
    public String getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(String idUmedida) {
        this.idUmedida = idUmedida;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "MATERIAL", updatable = false, insertable = false)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "UNIDAD", updatable = false, insertable = false)
    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
