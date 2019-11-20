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
@IdClass(value = ColorFormulaId.class)
@Table(name = "COLOR_FORMULA", schema = "dbo", catalog = "BDBRUCE")
public class ColorFormula implements java.io.Serializable {

    private String idCdiseno;
    private int idMaterial;
    private float cantidad;

    private String colordiseno;
    private String material;

    public ColorFormula() {
    }

    @Id
    @Column(name = "ID_CDISENO", nullable = false)
    public String getIdCdiseno() {
        return idCdiseno;
    }

    public void setIdCdiseno(String idCdiseno) {
        this.idCdiseno = idCdiseno;
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

    @Generated(GenerationTime.NEVER)
    @Column(name = "COLORDISENO", insertable = false, updatable = false)
    public String getColordiseno() {
        return colordiseno;
    }

    public void setColordiseno(String colordiseno) {
        this.colordiseno = colordiseno;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "MATERIAL", insertable = false, updatable = false)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
