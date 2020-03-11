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
@IdClass(value = RequerimientoMaterialId.class)
@Table(name = "REQUERIMIENTO_MATERIAL", schema = "dbo", catalog = "BDBRUCE")
public class RequerimientoMaterial implements java.io.Serializable {

    private int idRequerimiento;
    private int idMaterial;
    private float estandar;
    private float requerido;
    private float despachado;
    private String idUmedida;
    
    private String material;
    private float stock;
    private float requeridot;
    private float despachadot;

    public RequerimientoMaterial() {
    }

    @Id
    @Column(name = "ID_REQUERIMIENTO", nullable = false)
    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    @Id
    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name = "ESTANDAR", nullable = false)
    public float getEstandar() {
        return estandar;
    }

    public void setEstandar(float estandar) {
        this.estandar = estandar;
    }

    @Column(name = "REQUERIDO", nullable = false)
    public float getRequerido() {
        return requerido;
    }

    public void setRequerido(float requerido) {
        this.requerido = requerido;
    }

    @Column(name = "DESPACHADO", nullable = false)
    public float getDespachado() {
        return despachado;
    }

    public void setDespachado(float despachado) {
        this.despachado = despachado;
    }

    @Column(name = "ID_UMEDIDA", nullable = false)
    public String getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(String idUmedida) {
        this.idUmedida = idUmedida;
    }

    @Generated(GenerationTime.NEVER)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Generated(GenerationTime.NEVER)
    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    @Generated(GenerationTime.NEVER)
    public float getRequeridot() {
        return requeridot;
    }

    public void setRequeridot(float requeridot) {
        this.requeridot = requeridot;
    }

    @Generated(GenerationTime.NEVER)
    public float getDespachadot() {
        return despachadot;
    }

    public void setDespachadot(float despachadot) {
        this.despachadot = despachadot;
    }
}
