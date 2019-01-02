package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nacionalidad generated by hbm2java
 */
@Entity
@Table(name="NACIONALIDAD",schema="dbo",catalog="BDBRUCE")
public class Nacionalidad  implements java.io.Serializable {


     private int idNacionalidad;
     private String descripcion;
     private boolean situacion;

    public Nacionalidad() {
    }

    public Nacionalidad(int idNacionalidad, String descripcion, boolean situacion) {
       this.idNacionalidad = idNacionalidad;
       this.descripcion = descripcion;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_NACIONALIDAD", unique=true, nullable=false)
    public int getIdNacionalidad() {
        return this.idNacionalidad;
    }
    
    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
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


