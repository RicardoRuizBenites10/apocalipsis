package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TipoDocumento generated by hbm2java
 */
@Entity
@Table(name="TIPO_DOCUMENTO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class TipoDocumento  implements java.io.Serializable {


     private String idTdocumento;
     private String descripcion;
     private String descripcionAbreviada;
     private boolean situacion;

    public TipoDocumento() {
    }

	
    public TipoDocumento(String idTdocumento, boolean situacion) {
        this.idTdocumento = idTdocumento;
        this.situacion = situacion;
    }
    public TipoDocumento(String idTdocumento, String descripcion, String descripcionAbreviada, boolean situacion) {
       this.idTdocumento = idTdocumento;
       this.descripcion = descripcion;
       this.descripcionAbreviada = descripcionAbreviada;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_TDOCUMENTO", unique=true, nullable=false, length=2)
    public String getIdTdocumento() {
        return this.idTdocumento;
    }
    
    public void setIdTdocumento(String idTdocumento) {
        this.idTdocumento = idTdocumento;
    }

    
    @Column(name="DESCRIPCION", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="DESCRIPCION_ABREVIADA", length=25)
    public String getDescripcionAbreviada() {
        return this.descripcionAbreviada;
    }
    
    public void setDescripcionAbreviada(String descripcionAbreviada) {
        this.descripcionAbreviada = descripcionAbreviada;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }




}


