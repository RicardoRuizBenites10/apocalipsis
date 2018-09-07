package com.bruce.dao.to;
// Generated 07/09/2018 11:57:55 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TiempoContrato generated by hbm2java
 */
@Entity
@Table(name="TIEMPO_CONTRATO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class TiempoContrato  implements java.io.Serializable {


     private int idTiempo;
     private int nroMeses;
     private String descripcion;
     private boolean situacion;

    public TiempoContrato() {
    }

    public TiempoContrato(int idTiempo, int nroMeses, String descripcion, boolean situacion) {
       this.idTiempo = idTiempo;
       this.nroMeses = nroMeses;
       this.descripcion = descripcion;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_TIEMPO", unique=true, nullable=false)
    public int getIdTiempo() {
        return this.idTiempo;
    }
    
    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }

    
    @Column(name="NRO_MESES", nullable=false)
    public int getNroMeses() {
        return this.nroMeses;
    }
    
    public void setNroMeses(int nroMeses) {
        this.nroMeses = nroMeses;
    }

    
    @Column(name="DESCRIPCION", nullable=false, length=30)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }




}


