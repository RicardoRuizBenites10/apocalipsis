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
@Table(name = "PROFORMA", schema = "dbo", catalog = "BDBRUCE")
public class Proforma implements java.io.Serializable{

    private String idCliente;
    private int idProforma;
    private Date fecha;
    private String idCarroceria;
    
    private String cliente;
    private String carroceria;

    public Proforma() {
    }

    @Id
    @Column(name = "ID_PROFORMA", nullable = false)
    public int getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(int idProforma) {
        this.idProforma = idProforma;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "ID_CLIENTE", nullable = false)
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Column(name = "ID_CARROCERIA", nullable = false)
    public String getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(String idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name="CLIENTE", insertable = false, updatable = false)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
