package com.bruce.dao.to;
// Generated 07/09/2018 11:57:55 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TipoPeriodo generated by hbm2java
 */
@Entity
@Table(name="TIPO_PERIODO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class TipoPeriodo  implements java.io.Serializable {


     private int idTperiodo;
     private String descripcion;
     private boolean situacion;

    public TipoPeriodo() {
    }

    public TipoPeriodo(int idTperiodo, String descripcion, boolean situacion) {
       this.idTperiodo = idTperiodo;
       this.descripcion = descripcion;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_TPERIODO", unique=true, nullable=false)
    public int getIdTperiodo() {
        return this.idTperiodo;
    }
    
    public void setIdTperiodo(int idTperiodo) {
        this.idTperiodo = idTperiodo;
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


