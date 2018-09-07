package com.bruce.dao.to;
// Generated 07/09/2018 11:57:55 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subarea generated by hbm2java
 */
@Entity
@Table(name="SUBAREA"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Subarea  implements java.io.Serializable {


     private int idSubarea;
     private String nombre;
     private boolean situacion;
     private int idArea;

    public Subarea() {
    }

    public Subarea(int idSubarea, String nombre, boolean situacion, int idArea) {
       this.idSubarea = idSubarea;
       this.nombre = nombre;
       this.situacion = situacion;
       this.idArea = idArea;
    }
   
     @Id 

    
    @Column(name="ID_SUBAREA", unique=true, nullable=false)
    public int getIdSubarea() {
        return this.idSubarea;
    }
    
    public void setIdSubarea(int idSubarea) {
        this.idSubarea = idSubarea;
    }

    
    @Column(name="NOMBRE", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    
    @Column(name="ID_AREA", nullable=false)
    public int getIdArea() {
        return this.idArea;
    }
    
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }




}


