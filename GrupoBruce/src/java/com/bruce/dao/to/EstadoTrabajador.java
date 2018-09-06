package com.bruce.dao.to;
// Generated 06/09/2018 09:02:17 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EstadoTrabajador generated by hbm2java
 */
@Entity
@Table(name="ESTADO_TRABAJADOR"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class EstadoTrabajador  implements java.io.Serializable {


     private int idEtrabajador;
     private int codigo;
     private String descripcion;
     private boolean situacion;

    public EstadoTrabajador() {
    }

    public EstadoTrabajador(int idEtrabajador, int codigo, String descripcion, boolean situacion) {
       this.idEtrabajador = idEtrabajador;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_ETRABAJADOR", unique=true, nullable=false)
    public int getIdEtrabajador() {
        return this.idEtrabajador;
    }
    
    public void setIdEtrabajador(int idEtrabajador) {
        this.idEtrabajador = idEtrabajador;
    }

    
    @Column(name="CODIGO", nullable=false)
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="DESCRIPCION", nullable=false, length=20)
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


