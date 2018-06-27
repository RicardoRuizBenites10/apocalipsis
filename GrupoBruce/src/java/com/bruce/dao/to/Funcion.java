package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Funcion generated by hbm2java
 */
@Entity
@Table(name="FUNCION"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Funcion  implements java.io.Serializable {


     private int idFuncion;
     private Cargo cargo;
     private Date fecha;
     private String descripcion;
     private String detalle;
     private Boolean situacion;

    public Funcion() {
    }

	
    public Funcion(int idFuncion, Cargo cargo, Date fecha) {
        this.idFuncion = idFuncion;
        this.cargo = cargo;
        this.fecha = fecha;
    }
    public Funcion(int idFuncion, Cargo cargo, Date fecha, String descripcion, String detalle, Boolean situacion) {
       this.idFuncion = idFuncion;
       this.cargo = cargo;
       this.fecha = fecha;
       this.descripcion = descripcion;
       this.detalle = detalle;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_FUNCION", unique=true, nullable=false)
    public int getIdFuncion() {
        return this.idFuncion;
    }
    
    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_CARGO", nullable=false)
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="DESCRIPCION", length=50)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="DETALLE", length=200)
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
    @Column(name="SITUACION")
    public Boolean getSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(Boolean situacion) {
        this.situacion = situacion;
    }




}


