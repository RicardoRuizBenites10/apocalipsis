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
 * @author SISTEMAS
 */
@Entity
@IdClass(value = PlanillaId.class)
@Table(name = "PLANILLA", schema = "dbo", catalog = "BDBRUCE")
public class Planilla implements java.io.Serializable {

    private int idPplanilla;
    private String idTrabajador;
    private String idTplanilla;
    private String idTtrabajador;
    private String idConcepto;
    private Date fecha;
    private float importe;
    
    private String descripcion;
    private int id;

    public Planilla() {
    }

    public Planilla(int idPplanilla, String idTrabajador, String idTplanilla, String idTtrabajador, String idConcepto, Date fecha, float importe) {
        this.idPplanilla = idPplanilla;
        this.idTrabajador = idTrabajador;
        this.idTplanilla = idTplanilla;
        this.idTtrabajador = idTtrabajador;
        this.idConcepto = idConcepto;
        this.fecha = fecha;
        this.importe = importe;
    }

    @Id
    @Column(name = "ID_PPLANILLA", nullable = false)
    public int getIdPplanilla() {
        return idPplanilla;
    }

    public void setIdPplanilla(int idPplanilla) {
        this.idPplanilla = idPplanilla;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
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
    @Column(name = "ID_TTRABAJADOR", nullable = false)
    public String getIdTtrabajador() {
        return idTtrabajador;
    }

    public void setIdTtrabajador(String idTtrabajador) {
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

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "IMPORTE", nullable = false)
    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    @Generated(GenerationTime.NEVER)
    @Column(name="DESCRIPCION", insertable = false, updatable = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="ID", insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
