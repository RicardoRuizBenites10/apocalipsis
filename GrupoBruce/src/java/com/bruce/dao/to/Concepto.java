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
 * @author RICARDO
 */
@Entity
@IdClass(value = ConceptoId.class)
@Table(name = "CONCEPTO", schema = "dbo", catalog = "BDBRUCE")
public class Concepto implements java.io.Serializable {

    private int idTtrabajador;
    private String idConcepto;
    private String codPdt;
    private String descripcion;
    private String formula;
    private String idTconcepto;
    private String idTvariable;
    private boolean situacion;

    private String tconcepto;
    private String tvariable;

    public Concepto() {
    }

    @Id
    @Column(name = "ID_TTRABAJADOR", nullable = false)
    public int getIdTtrabajador() {
        return idTtrabajador;
    }

    public void setIdTtrabajador(int idTtrabajador) {
        this.idTtrabajador = idTtrabajador;
    }

    @Id
    @Column(name = "ID_CONCEPTO", nullable = false)
    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Column(name = "COD_PDT")
    public String getCodPdt() {
        return codPdt;
    }

    public void setCodPdt(String codPdt) {
        this.codPdt = codPdt;
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

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "TCONCEPTO", insertable = false, updatable = false)
    public String getTconcepto() {
        return tconcepto;
    }

    public void setTconcepto(String tconcepto) {
        this.tconcepto = tconcepto;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "TVARIABLE", insertable = false, updatable = false)
    public String getTvariable() {
        return tvariable;
    }

    public void setTvariable(String tvariable) {
        this.tvariable = tvariable;
    }

}
