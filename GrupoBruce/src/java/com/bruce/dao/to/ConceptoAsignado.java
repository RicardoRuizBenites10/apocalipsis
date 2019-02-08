/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author RICARDO
 */
@Entity
@IdClass(value = ConceptoAsignadoId.class)
@Table(name = "CONCEPTO_ASIGNADO", schema = "dbo", catalog = "BDBRUCE")
public class ConceptoAsignado implements java.io.Serializable {

    private int idTtrabajador;
    private String idTplanilla;
    private String idConcepto;
    private Date fecha;
    private int orden;

    private String descripcion;

    public ConceptoAsignado() {
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
    @Column(name = "ID_TPLANILLA", nullable = false)
    public String getIdTplanilla() {
        return idTplanilla;
    }

    public void setIdTplanilla(String idTplanilla) {
        this.idTplanilla = idTplanilla;
    }

    @Id
    @Column(name = "ID_CONCEPTO", nullable = false)
    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "ORDEN", nullable = false)
    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "DESCRIPCION", insertable = false, updatable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
