package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Periocidad generated by hbm2java
 */
@Entity
@Table(name="PERIOCIDAD"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Periocidad  implements java.io.Serializable {


     private int idPeriocidad;
     private String descripcion;
     private boolean situacion;

    public Periocidad() {
    }

    public Periocidad(int idPeriocidad, String descripcion, boolean situacion) {
       this.idPeriocidad = idPeriocidad;
       this.descripcion = descripcion;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_PERIOCIDAD", unique=true, nullable=false)
    public int getIdPeriocidad() {
        return this.idPeriocidad;
    }
    
    public void setIdPeriocidad(int idPeriocidad) {
        this.idPeriocidad = idPeriocidad;
    }

    
    @Column(name="DESCRIPCION", nullable=false, length=25)
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


