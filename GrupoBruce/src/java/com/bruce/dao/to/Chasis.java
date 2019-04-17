/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "CHASIS", schema = "dbo", catalog = "BDBRUCE")
public class Chasis implements java.io.Serializable {

    private int idChasis;
    private String modelo;
    private int ddee;
    private String idChapro;
    private String idCarmod;

    public Chasis() {
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

    @Column(name="ID_CHAPRO", nullable = false)
    public String getIdChapro() {
        return idChapro;
    }

    public void setIdChapro(String idChapro) {
        this.idChapro = idChapro;
    }

    @Column(name="ID_CARMOD", nullable = false)
    public String getIdCarmod() {
        return idCarmod;
    }

    public void setIdCarmod(String idCarmod) {
        this.idCarmod = idCarmod;
    }
}
