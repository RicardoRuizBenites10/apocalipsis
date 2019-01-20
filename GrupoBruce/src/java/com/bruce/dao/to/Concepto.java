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
 * @author RICARDO
 */
@Entity
@Table(name = "CONCEPTO", schema = "dbo", catalog = "BDBRUCE")
public class Concepto implements java.io.Serializable {

    private String idConcepto;
    private String descripcion;
    private String formula;
    private String idTconcepto;
    private String idTvariable;
    private String idTplanilla;
    private boolean situacion;

    public Concepto() {
    }

    @Id
    @Column(name = "ID_CONCEPTO", nullable = false)
    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "FORMULA", nullable = false)
    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Column(name = "ID_TCONCEPTO", nullable = false)
    public String getIdTconcepto() {
        return idTconcepto;
    }

    public void setIdTconcepto(String idTconcepto) {
        this.idTconcepto = idTconcepto;
    }

    @Column(name = "ID_TVARIABLE", nullable = false)
    public String getIdTvariable() {
        return idTvariable;
    }

    public void setIdTvariable(String idTvariable) {
        this.idTvariable = idTvariable;
    }

    @Column(name = "ID_TPLANILLA", nullable = false)
    public String getIdTplanilla() {
        return idTplanilla;
    }

    public void setIdTplanilla(String idTplanilla) {
        this.idTplanilla = idTplanilla;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

}
