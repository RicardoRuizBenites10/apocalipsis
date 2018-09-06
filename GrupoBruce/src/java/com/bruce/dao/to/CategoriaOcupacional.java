package com.bruce.dao.to;
// Generated 06/09/2018 09:02:17 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CategoriaOcupacional generated by hbm2java
 */
@Entity
@Table(name="CATEGORIA_OCUPACIONAL"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class CategoriaOcupacional  implements java.io.Serializable {


     private int idCocupacional;
     private String codigo;
     private String descripcion;
     private boolean situacion;

    public CategoriaOcupacional() {
    }

    public CategoriaOcupacional(int idCocupacional, String codigo, String descripcion, boolean situacion) {
       this.idCocupacional = idCocupacional;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_COCUPACIONAL", unique=true, nullable=false)
    public int getIdCocupacional() {
        return this.idCocupacional;
    }
    
    public void setIdCocupacional(int idCocupacional) {
        this.idCocupacional = idCocupacional;
    }

    
    @Column(name="CODIGO", nullable=false, length=2)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="DESCRIPCION", nullable=false, length=45)
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


