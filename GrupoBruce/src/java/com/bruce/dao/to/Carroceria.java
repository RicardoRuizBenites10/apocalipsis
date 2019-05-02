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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "CARROCERIA", schema = "dbo", catalog = "BDBRUCE")
public class Carroceria implements java.io.Serializable {

    private int idCarroceria;
    private Date fecha;
    private String codigo;
    private String descripcion;
    private boolean situacion;
    private String idCartip;
    private String idCarfal;
    private int idChasis;
    
    private String tipo;
    private String falda;
    private String chasis;

    public Carroceria() {
    }

    @Id
    @Column(name = "ID_CARROCERIA", nullable = false)
    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "CODIGO", nullable = false)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @Column(name = "ID_CARTIP", nullable = false)
    public String getIdCartip() {
        return idCartip;
    }

    public void setIdCartip(String idCartip) {
        this.idCartip = idCartip;
    }

    @Column(name = "ID_CARFAL", nullable = false)
    public String getIdCarfal() {
        return idCarfal;
    }

    public void setIdCarfal(String idCarfal) {
        this.idCarfal = idCarfal;
    }

    @Column(name = "ID_CHASIS", nullable = false)
    public int getIdChasis() {
        return idChasis;
    }

    public void setIdChasis(int idChasis) {
        this.idChasis = idChasis;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "TIPO", updatable = false, insertable = false )
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "FALDA", updatable = false, insertable = false )
    public String getFalda() {
        return falda;
    }

    public void setFalda(String falda) {
        this.falda = falda;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "CHASIS", updatable = false, insertable = false )
    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }
}
