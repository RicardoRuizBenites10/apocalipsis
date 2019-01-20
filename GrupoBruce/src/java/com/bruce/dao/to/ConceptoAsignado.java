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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author RICARDO
 */
@Entity
@Table(name = "CONCEPTO_ASIGNADO", schema = "dbo", catalog = "BDBRUCE")
public class ConceptoAsignado implements java.io.Serializable {

    private String idCasignado;
    private Date fecha;
    private String idConcepto;
    private String idTtrabajador;

    public ConceptoAsignado() {
    }

    @Id
    @Column(name = "ID_CASIGNADO", nullable = false)
    public String getIdCasignado() {
        return idCasignado;
    }

    public void setIdCasignado(String idCasignado) {
        this.idCasignado = idCasignado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "ID_CONCEPTO", nullable = false)
    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Column(name = "ID_TTRABAJADOR", nullable = false)
    public String getIdTtrabajador() {
        return idTtrabajador;
    }

    public void setIdTtrabajador(String idTtrabajador) {
        this.idTtrabajador = idTtrabajador;
    }

}
