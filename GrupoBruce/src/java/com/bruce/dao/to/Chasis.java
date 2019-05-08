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
@IdClass(value = ChasisId.class)
@Table(name = "CHASIS", schema = "dbo", catalog = "BDBRUCE")
public class Chasis implements java.io.Serializable {

    private String idChapro;
    private int idChasis;
    private String modelo;
    private int ddee;
    private String idCarmod;
    
    private String proveedor;
    private String carroceria;

    public Chasis() {
    }
    
    @Id
    @Column(name="ID_CHAPRO", nullable = false)
    public String getIdChapro() {
        return idChapro;
    }

    public void setIdChapro(String idChapro) {
        this.idChapro = idChapro;
    }
    
    @Id
    @Column(name="ID_CHASIS", nullable = false)
    public int getIdChasis() {
        return idChasis;
    }

    public void setIdChasis(int idChasis) {
        this.idChasis = idChasis;
    }

    @Column(name="MODELO", nullable = false)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Column(name="DDEE", nullable = false)
    public int getDdee() {
        return ddee;
    }

    public void setDdee(int ddee) {
        this.ddee = ddee;
    }

    @Column(name="ID_CARMOD", nullable = false)
    public String getIdCarmod() {
        return idCarmod;
    }

    public void setIdCarmod(String idCarmod) {
        this.idCarmod = idCarmod;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="PROVEEDOR", insertable = false, updatable = false)
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="CARROCERIA", insertable = false, updatable = false)
    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }
}
